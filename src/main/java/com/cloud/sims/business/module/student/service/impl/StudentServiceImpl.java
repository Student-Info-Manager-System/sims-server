package com.cloud.sims.business.module.student.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cloud.sims.business.module.student.mapper.StudentMapper;
import com.cloud.sims.business.module.student.pojo.dto.GradeStudentListInfoDTO;
import com.cloud.sims.business.module.student.pojo.from.AddStudentFrom;
import com.cloud.sims.business.module.student.pojo.from.EditStudentFrom;
import com.cloud.sims.common.config.shiro.AccountProfile;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import com.cloud.sims.business.module.student.pojo.entity.Student;
import com.cloud.sims.business.module.student.pojo.vo.GradeStudentInfoVO;
import com.cloud.sims.system.sysuser.pojo.from.EditUserFrom;
import com.cloud.sims.system.sysuser.pojo.from.LoginFrom;
import com.cloud.sims.system.sysuser.pojo.vo.UserInfoVO;
import com.cloud.sims.business.module.student.service.StudentService;
import com.cloud.sims.common.base.service.impl.IBaseServiceImpl;
import com.cloud.sims.common.config.exception.Assert;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.constant.Constant;
import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.ServiceUtil;
import com.cloud.sims.system.sysuser.pojo.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Long
 */
@Slf4j
@Service
public class StudentServiceImpl extends IBaseServiceImpl<Student, String, StudentMapper> implements StudentService {


    @Override
    public List<Student> searchByNumber(String number) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Student::getNumber, number);
        return mapper.selectList(wrapper);
    }

    @Override
    public GradeStudentListInfoDTO search(String search) {
        GradeStudentListInfoDTO dto = new GradeStudentListInfoDTO();

        if (ServiceUtil.isNull(search)) {
            throw new CloudException(ErrorMsg.CHECK_DATA);
        }
        String name = search, number = search;
        List<SysUser> users = manager.sysUserService.search(name);
        List<Student> students = this.searchByNumber(number);

        Set<GradeStudentInfoVO> vos = new HashSet<>();
        for (Student student : students) {
            SysUser sysUser = manager.sysUserService.getById(student.getSysUserId());
            if (ServiceUtil.isNull(sysUser)) {
                continue;
            }
            GradeStudentInfoVO vo = new GradeStudentInfoVO();
            BeanUtils.copyProperties(student, vo);
            BeanUtils.copyProperties(sysUser, vo);
            vos.add(vo);
        }
        for (SysUser user : users) {
            Student s = this.findBySysUserId(user.getId());
            if (ServiceUtil.isNull(s)) {
                continue;
            }

            GradeStudentInfoVO vo = new GradeStudentInfoVO();
            BeanUtils.copyProperties(s, vo);
            BeanUtils.copyProperties(user, vo);

            vos.add(vo);
        }
        if (vos.isEmpty()) {
            throw new CloudException("搜不到哦");
        }
        return dto.ok(new ArrayList<>(vos));
    }

    @Override
    public void edit(EditStudentFrom from) {
        if (ServiceUtil.hasNull(from.getGradeId())) {
            throw new CloudException("这里有个BUG，手动选上班级");
        }
        manager.sysUserService.editName(from.getId(), from.getName());
        LambdaUpdateWrapper<Student> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Student::getSysUserId, from.getId());
        wrapper.set(Student::getGradeId, from.getGradeId());
        wrapper.set(Student::getNumber, from.getNumber());
        wrapper.set(Student::getPosition, from.getPosition());
        super.update(wrapper);
    }

    @Override
    public void del(String id) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getSysUserId, id);
        mapper.delete(wrapper);
        manager.sysUserService.del(id);
    }

    @Override
    public AccountProfile login(UserInfoDTO dto) {
        return manager.sysUserService.login(dto);
    }

    @Override
    public UserInfoDTO add(AddStudentFrom from) {
        if (ServiceUtil.hasNull(from.getName(), from.getNumber(), from.getGradeId())) {
            throw new CloudException(ErrorMsg.DATA_NOT_FOLL);
        }
        SysUser user = new SysUser();
        user.setName(from.getName());
        user.setUsername(from.getNumber());
        user.setPassword(from.getNumber());
        Student student = this.findByNumber(from.getNumber());
        if (ServiceUtil.isNotNull(student)) {
            throw new CloudException(ErrorMsg.STUDENT_NUMBER_HAS);
        }
        user.setType(Constant.USER_TYPE_STUDENT);
        user = manager.sysUserService.add(user);
        student = new Student();
        BeanUtils.copyProperties(from, student);
        student.setSysUserId(user.getId());
        mapper.insert(student);
        return this.getDtoByNumber(from.getNumber());
    }

    @Override
    public UserInfoDTO getLogin() {
        SysUser user = manager.sysUserService.getLoginUser();
        Student student = this.getBySysUserId(user.getId());
        return this.getDto(student, user);
    }

    @Override
    public UserInfoDTO edit(EditUserFrom from) {
        SysUser user = manager.sysUserService.getLoginUser();
        Student student = this.getBySysUserId(user.getId());
        user = manager.sysUserService.edit(from, user);
        return this.getDto(student, user);
    }

    @Override
    public Student getBySysUser(SysUser user) {
        Assert.notNull(user, ErrorMsg.ACCOUNT_NOT_FOUND);
        return this.getBySysUserId(user.getId());
    }

    @Override
    public Student findByNumber(String number) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getNumber, number);
        return mapper.selectOne(wrapper);
    }

    @Override
    public UserInfoDTO login(LoginFrom from) {
        if (!ServiceUtil.equal(from.getType(), Constant.USER_TYPE_STUDENT)) {
            throw new CloudException(ErrorMsg.ACCOUNT_IDENTITY_ERROR);
        }

        String account = from.getAccount();
        String password = from.getPassword();
        Assert.isTrue(!ServiceUtil.hasNull(account, password), ErrorMsg.USER_INFO_MUST_NOT_NULL);

        Student student = this.findByNumber(account);
        SysUser user = null;
        if (ServiceUtil.isNotNull(student)) {
            user = manager.sysUserService.getById(student.getSysUserId());
        } else {
            user = manager.sysUserService.findByUserName(account);
            student = this.getBySysUser(user);
        }
        Assert.notNull(user, ErrorMsg.ACCOUNT_NOT_FOUND);

        manager.sysUserService.login(user, password);

        return this.getDto(student, user);
    }

    @Override
    public String getGradeId(String sysUserId) {
        return this.getBySysUserId(sysUserId).getGradeId();
    }


    @Override
    public Student getBySysUserId(String sysUserId) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getSysUserId, sysUserId);
        Student entity = mapper.selectOne(wrapper);
        Assert.notNull(entity);
        return entity;
    }

    @Override
    public Student findBySysUserId(String sysUserId) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getSysUserId, sysUserId);
        return mapper.selectOne(wrapper);
    }

    @Override
    public Student getByNumber(String number) {
        Student entity = this.findByNumber(number);
        Assert.notNull(entity);
        return entity;
    }

    @Override
    public List<Student> getByGradeId(String gradeId) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getGradeId, gradeId);
        List<Student> entitys = mapper.selectList(wrapper);
//        Assert.notNull(entitys);
        return entitys;
    }

    @Override
    public GradeStudentListInfoDTO findDtoByGradeId(String gradeId) {
        GradeStudentListInfoDTO dto = new GradeStudentListInfoDTO();

        List<Student> entitys = this.getByGradeId(gradeId);

        List<GradeStudentInfoVO> vos = new ArrayList<>();
        for (Student entity : entitys) {
            SysUser sysUser = manager.sysUserService.getById(entity.getSysUserId());
            if (ServiceUtil.isNull(sysUser)) {
                continue;
            }

            GradeStudentInfoVO vo = new GradeStudentInfoVO();
            BeanUtils.copyProperties(entity, vo);
            BeanUtils.copyProperties(sysUser, vo);

            vos.add(vo);
        }

//        Assert.notNull(vos);
        return dto.ok(vos);
    }

    @Override
    public UserInfoDTO getDtoByNumber(String number) {
        Student student = this.getByNumber(number);
        SysUser user = manager.sysUserService.getById(student.getSysUserId());
        Assert.notNull(user);

        return this.getDto(student, user);
    }

    @Override
    public UserInfoDTO getDto(Student student, SysUser user) {
        UserInfoDTO dto = new UserInfoDTO();

        UserInfoVO vo = new UserInfoVO();
        BeanUtils.copyProperties(student, vo);
        BeanUtils.copyProperties(user, vo);
//        vo.setId(user.getId());
        if (ServiceUtil.isNotNull(user.getBirth())) {
            vo.setBirthDay(DateUtil.format(user.getBirth(), "yyyy/MM/dd"));
        }
        Assert.notNull(vo);
        vo.setType(Constant.USER_TYPE_STUDENT);
        return dto.ok(vo);
    }
}

package com.cloud.sims.business.module.student.service;

import com.cloud.sims.business.module.student.pojo.dto.GradeStudentListInfoDTO;
import com.cloud.sims.business.module.student.pojo.from.AddStudentFrom;
import com.cloud.sims.business.module.student.pojo.from.EditStudentFrom;
import com.cloud.sims.common.config.shiro.AccountProfile;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import com.cloud.sims.business.module.student.pojo.entity.Student;
import com.cloud.sims.common.base.service.IBaseService;
import com.cloud.sims.system.sysuser.pojo.entity.SysUser;
import com.cloud.sims.system.sysuser.pojo.from.EditUserFrom;
import com.cloud.sims.system.sysuser.pojo.from.LoginFrom;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Long
 */
public interface StudentService extends IBaseService<Student, String> {
    List<Student> searchByNumber(String number);

    /**
     * 搜索
     * @param search
     * @return
     */
    GradeStudentListInfoDTO search(String search);
    /**
     * 编辑
     * @param from
     */
    void edit(EditStudentFrom from);

    /**
     * 删除
     * @param id
     */
    void del(String id);

    /**
     * 登陆信息
     * @param dto
     * @return
     */
    AccountProfile login(UserInfoDTO dto);
    /**
     * 添加学生
     * @param from
     * @return
     */
    UserInfoDTO add(AddStudentFrom from);

    /**
     * 获取当前登录学生信息
     * @return
     */
    UserInfoDTO getLogin();

    /**
     *
     * @param from
     * @return
     */
    UserInfoDTO edit(EditUserFrom from);

    /**
     *
     * @param user
     * @return
     */
    Student getBySysUser(SysUser user);

    /**
     * 根据学号查找
     * @param number
     * @return
     */
    Student findByNumber(String number);

    /**
     * 账号登录
     * @param account
     * @param password
     * @return
     */
    UserInfoDTO login(LoginFrom from);

    /**
     * 根据用户ID获取学生所在班级ID
     * @param sysUserId
     * @return
     */
    String getGradeId(String sysUserId);

    /**
     * 根据用户ID获取学生信息
     * @param sysUserId
     * @return
     */
    Student getBySysUserId(String sysUserId);

    Student findBySysUserId(String sysUserId);

    /**
     * 根据学号获取学生信息
     * @param number
     * @return
     */
    Student getByNumber(String number);

    /**
     * 根据班级ID获取
     * @param gradeId
     * @return
     */
    List<Student> getByGradeId(String gradeId);

    /**
     * 根据班级ID获取
     * @param gradeId
     * @return
     */
    GradeStudentListInfoDTO findDtoByGradeId(String gradeId);

    /**
     * 根据学号获取学生信息
     * @param number
     * @return
     */
    UserInfoDTO getDtoByNumber(String number);

    /**
     * 组装学生信息
     * @param student
     * @param user
     * @return
     */
    UserInfoDTO getDto(Student student, SysUser user);
}

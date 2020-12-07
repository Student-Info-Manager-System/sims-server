package com.cloud.sims.business.module.grade.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cloud.sims.business.module.course.pojo.dto.GradeCourseListInfoDTO;
import com.cloud.sims.business.module.grade.mapper.GradeMapper;
import com.cloud.sims.business.module.grade.pojo.dto.GradeInfoDTO;
import com.cloud.sims.business.module.grade.pojo.dto.GradeShortInfoDTO;
import com.cloud.sims.business.module.grade.pojo.entity.Grade;
import com.cloud.sims.business.module.grade.pojo.from.EditFrom;
import com.cloud.sims.business.module.grade.pojo.from.GradeFrom;
import com.cloud.sims.business.module.grade.pojo.from.NoticeFrom;
import com.cloud.sims.business.module.grade.pojo.vo.GradeInfoVO;
import com.cloud.sims.business.module.grade.pojo.vo.GradeShortInfoVO;
import com.cloud.sims.business.module.grade.service.GradeService;
import com.cloud.sims.business.module.leader.pojo.dto.GradeLeaderInfoDTO;
import com.cloud.sims.business.module.leader.pojo.entity.Leader;
import com.cloud.sims.business.module.student.pojo.dto.GradeStudentListInfoDTO;
import com.cloud.sims.common.base.service.impl.IBaseServiceImpl;
import com.cloud.sims.common.config.exception.Assert;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.constant.Constant;
import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Long
 */
@Slf4j
@Service
public class GradeServiceImpl extends IBaseServiceImpl<Grade, String, GradeMapper> implements GradeService {


    @Override
    public List<Grade> findByName(String name) {
        LambdaQueryWrapper<Grade> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Grade::getName, name );
        return mapper.selectList(wrapper);
    }

    @Override
    public void edit(EditFrom from) {
        if (ServiceUtil.hasNull(from.getGradeId(), from.getName())) {
            throw new CloudException(ErrorMsg.CHECK_DATA);
        }
        LambdaUpdateWrapper<Grade> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Grade::getId, from.getGradeId());
        wrapper.set(Grade::getName, from.getName());
        super.update(wrapper);
    }

    @Override
    public void setNotice(NoticeFrom from) {
        if (ServiceUtil.hasNull(from.getGradeId())) {
            throw new CloudException(ErrorMsg.CHECK_DATA);
        }
        Grade grade = this.getById(from.getGradeId());
        grade.setNotice(from.getNotice());
        LambdaUpdateWrapper<Grade> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Grade::getId, from.getGradeId());
        wrapper.set(Grade::getNotice, from.getNotice());
        super.update(wrapper);
    }

    @Override
    public List<Grade> findByNumber(String number) {
        LambdaQueryWrapper<Grade> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Grade::getNumber, number);
        return mapper.selectList(wrapper);
    }

    @Override
    public Grade add(GradeFrom from) {
        if (ServiceUtil.hasNull(from.getName(), from.getLeaderId(), from.getNumber())){
            throw new CloudException(ErrorMsg.CHECK_DATA);
        }
        List<Grade> grades = this.findByName(from.getName());
        if (grades.size() > 0) {
            throw new CloudException(ErrorMsg.NAME_HAS);
        }
        grades = this.findByNumber(from.getNumber());
        if (grades.size() > 0) {
            throw new CloudException(ErrorMsg.NUMBER_HAS);
        }
        Grade grade = new Grade();
        BeanUtils.copyProperties(from, grade);
        grade.setYear(""+DateUtil.year(new Date()));
        Leader leader = manager.leaderService.getBySysUserId(from.getLeaderId());
        grade.setLeaderId(leader.getId());
        mapper.insert(grade);
        return grade;
    }

    @Override
    public List<Grade> getGradeByLeaderId(String leaderId) {
        LambdaQueryWrapper<Grade> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Grade::getLeaderId, leaderId);
        List<Grade> entitys = mapper.selectList(wrapper);
        Assert.notNull(entitys);
        return entitys;
    }

    @Override
    public GradeInfoDTO findGradeInfoDTOByGradeId(String id) {
        Grade entity = mapper.selectById(id);
        Assert.notNull(entity);
        return this.findByGrade(entity);
    }

    @Override
    public GradeInfoDTO findGradeStudentInfoDTOByGradeId(String id) {
        GradeInfoDTO dto = new GradeInfoDTO();
        Grade grade = mapper.selectById(id);
        Assert.notNull(grade);
        GradeInfoVO vo = new GradeInfoVO();
        BeanUtils.copyProperties(grade, vo);
        GradeStudentListInfoDTO studentListInfoDTO = manager.studentService.findDtoByGradeId(grade.getId());
        if (studentListInfoDTO.getSuccess()) {
            vo.setStudents(studentListInfoDTO.getVo());
        }
        Assert.notNull(vo);
        return dto.ok(vo);
    }

    @Override
    public GradeInfoDTO findGradeCourseInfoDTOByGradeId(String id) {
        GradeInfoDTO dto = new GradeInfoDTO();
        Grade grade = mapper.selectById(id);
        Assert.notNull(grade);
        GradeInfoVO vo = new GradeInfoVO();
        BeanUtils.copyProperties(grade, vo);
        GradeCourseListInfoDTO courseListInfoDTO = manager.courseService.findDtoByGradeId(grade.getId());
        if (courseListInfoDTO.getSuccess()) {
            vo.setCourses(courseListInfoDTO.getVo());
        }
        Assert.notNull(vo);
        return dto.ok(vo);
    }


    @Override
    public GradeInfoDTO findByGrade(Grade grade) {
        GradeInfoDTO dto = new GradeInfoDTO();

        GradeInfoVO vo = new GradeInfoVO();
        BeanUtils.copyProperties(grade, vo);

        GradeLeaderInfoDTO leaderInfoDTO = manager.leaderService.findDtoById(grade.getLeaderId());
        GradeStudentListInfoDTO studentListInfoDTO = manager.studentService.findDtoByGradeId(grade.getId());
        GradeCourseListInfoDTO courseListInfoDTO = manager.courseService.findDtoByGradeId(grade.getId());

        if (leaderInfoDTO.getSuccess()) {
            vo.setLeader(leaderInfoDTO.getVo());
        }
        if (studentListInfoDTO.getSuccess()) {
            vo.setStudents(studentListInfoDTO.getVo());
        }
        if (courseListInfoDTO.getSuccess()) {
            vo.setCourses(courseListInfoDTO.getVo());
        }
        Assert.notNull(vo);
        return dto.ok(vo);
    }

    @Override
    public GradeShortInfoDTO findGradeShortInfoDTO(String userId, String type) {
        GradeShortInfoDTO dto = new GradeShortInfoDTO();

        List<Grade> entitys = new ArrayList<>();

        Leader leader = manager.leaderService.getBySysUserId(userId);

        if (Constant.USER_TYPE_TEACHER.equals(type)) {
            entitys = this.getGradeByLeaderId(leader.getId());
        }
        if (Constant.USER_TYPE_STUDENT.equals(type)) {
            entitys = this.getStudentGrade(leader.getId());
        }
        List<GradeShortInfoVO> vos = new ArrayList<>();
        for (Grade entity : entitys) {
            GradeShortInfoVO vo = new GradeShortInfoVO();
            BeanUtils.copyProperties(entity, vo);
            vos.add(vo);
        }
        Assert.notNull(vos);
        return dto.ok(vos);
    }

    /*@Override
    public List<Grade> findLeaderGradeS(String userId) {
        List<String> gradeIds = manager.leaderService.findGradeIds(userId);
        List<Grade> entitys = new ArrayList<>();
        for (String gradeId : gradeIds) {
            Grade entity = mapper.selectById(gradeId);
            if (ServiceUtil.isNotNull(entity)) {
                entitys.add(entity);
            }
        }
        Assert.notNull(entitys);
        return entitys;
    }*/

    @Override
    public List<Grade> getStudentGrade(String userId) {
        String gradeId = manager.studentService.getGradeId(userId);
        Grade entity = mapper.selectById(gradeId);
        Assert.notNull(entity);
        return new ArrayList<Grade>(){{this.add(entity);}};
    }
}

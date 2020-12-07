package com.cloud.sims.business.module.achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cloud.sims.business.module.achievement.mapper.AchievementMapper;
import com.cloud.sims.business.module.achievement.pojo.dto.StudentAchievementListDTO;
import com.cloud.sims.business.module.achievement.pojo.entity.Achievement;
import com.cloud.sims.business.module.achievement.pojo.vo.AchievmentVO;
import com.cloud.sims.business.module.achievement.pojo.vo.StudentAchievementVO;
import com.cloud.sims.business.module.achievement.service.AchievementService;
import com.cloud.sims.business.module.student.pojo.entity.Student;
import com.cloud.sims.common.base.service.impl.IBaseServiceImpl;
import com.cloud.sims.common.config.exception.Assert;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Long
 */
@Slf4j
@Service
public class AchievementServiceImpl extends IBaseServiceImpl<Achievement, String, AchievementMapper> implements AchievementService {
    @Override
    public void putScore(String courseId, String studentId, String score) {
        if (ServiceUtil.hasNull(courseId, studentId, score)) {
            throw new CloudException(ErrorMsg.CHECK_DATA);
        }
        Achievement achievement = this.getByStudentIdAndCourseId(studentId, courseId);
        if (ServiceUtil.isNull(achievement)){
            achievement = new Achievement();
            achievement.setScore(score);
            achievement.setCourseId(courseId);
            achievement.setStudentId(studentId);
            mapper.insert(achievement);
        }else {
            achievement.setScore(score);
            LambdaUpdateWrapper<Achievement> wrapper = new LambdaUpdateWrapper<>();
            wrapper.eq(Achievement::getStudentId, studentId);
            wrapper.eq(Achievement::getCourseId, courseId);
            wrapper.set(Achievement::getScore, score);
            super.update(wrapper);
        }

    }

    @Override
    public Achievement getByStudentIdAndCourseId(String studentId, String courseId) {
        LambdaQueryWrapper<Achievement> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Achievement::getStudentId, studentId).eq(Achievement::getCourseId, courseId);
        return mapper.selectOne(wrapper);
    }

    @Override
    public List<AchievmentVO> getAchievmentVO(String gradeId, String courseId) {
        Assert.notNull(gradeId, courseId);
        List<Student> students = manager.studentService.getByGradeId(gradeId);
        List<AchievmentVO> vos = new ArrayList<>();
        for (Student student : students){
            Achievement achievement = this.getByStudentIdAndCourseId(student.getSysUserId(), courseId);
            if(ServiceUtil.isNull(achievement)) {
                continue;
            }
            AchievmentVO vo = new AchievmentVO(student.getSysUserId(), achievement.getScore());
            vos.add(vo);
        }
        /*if (vos.size() < 1){
            throw new CloudException(ErrorMsg.NOT_FOUNT);
        }*/
        return vos;
    }

    @Override
    public List<Achievement> getByStudentId(String studentId) {
        LambdaQueryWrapper<Achievement> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Achievement::getStudentId, studentId);
        List<Achievement> entitys = mapper.selectList(wrapper);
        Assert.notNull(entitys, "还没有成绩哦");
        return entitys;
    }

    @Override
    public List<Achievement> getByStudentId(String studentId, String courseName) {
        List<String> courseIds = manager.courseService.findCourseIdByName(courseName);
        LambdaQueryWrapper<Achievement> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Achievement::getStudentId, studentId).in(Achievement::getCourseId, courseIds);
        List<Achievement> entitys = mapper.selectList(wrapper);
        Assert.notNull(entitys);
        return entitys;
    }

    @Override
    public StudentAchievementListDTO findStudentAchievement(String studentId) {
        StudentAchievementListDTO dto = new StudentAchievementListDTO();

        List<Achievement> entitys = this.getByStudentId(studentId);

        List<StudentAchievementVO> vos = new ArrayList<>();
        for (Achievement entity : entitys){
            String name = manager.courseService.getCourseNameById(entity.getCourseId());
            if (ServiceUtil.isNull(name)) {
                continue;
            }
            StudentAchievementVO vo = new StudentAchievementVO(entity.getScore(), name);
            vos.add(vo);
        }
        Assert.notNull(vos);
        return dto.ok(vos);
    }

    @Override
    public StudentAchievementListDTO findStudentAchievement(String studentId, String courseName) {
        StudentAchievementListDTO dto = new StudentAchievementListDTO();

        List<Achievement> entitys = this.getByStudentId(studentId, courseName);

        List<StudentAchievementVO> vos = new ArrayList<>();
        for (Achievement entity : entitys){
            String name = manager.courseService.getCourseNameById(entity.getCourseId());
            if (ServiceUtil.isNull(name)) {
                continue;
            }
            StudentAchievementVO vo = new StudentAchievementVO(entity.getScore(), name);
            vos.add(vo);
        }
        Assert.notNull(vos);
        return dto.ok(vos);
    }
}

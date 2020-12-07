package com.cloud.sims.business.module.achievement.service;

import com.cloud.sims.business.module.achievement.pojo.dto.StudentAchievementListDTO;
import com.cloud.sims.business.module.achievement.pojo.entity.Achievement;
import com.cloud.sims.business.module.achievement.pojo.vo.AchievmentVO;
import com.cloud.sims.common.base.service.IBaseService;

import java.util.List;

/**
 * @author Long
 */
public interface AchievementService extends IBaseService<Achievement, String> {

    void putScore( String courseId, String studentId, String score);

    Achievement getByStudentIdAndCourseId(String studentId, String courseId);

    List<AchievmentVO> getAchievmentVO(String gradeId, String courseId);

    /**
     * 获取学生成绩表
     * @param studentId
     * @return
     */
    List<Achievement> getByStudentId(String studentId);

    /**
     * 模糊查询
     * @param studentId
     * @param courseName
     * @return
     */
    List<Achievement> getByStudentId(String studentId, String courseName);

    /**
     * 获取学生成绩表VO
     * @param studentId
     * @return
     */
    StudentAchievementListDTO findStudentAchievement(String studentId);

    /**
     * 模糊查询
     * @param studentId
     * @param courseName
     * @return
     */
    StudentAchievementListDTO findStudentAchievement(String studentId, String courseName);
}

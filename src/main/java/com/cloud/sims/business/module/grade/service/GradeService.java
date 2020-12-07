package com.cloud.sims.business.module.grade.service;

import com.cloud.sims.business.module.grade.pojo.dto.GradeInfoDTO;
import com.cloud.sims.business.module.grade.pojo.dto.GradeShortInfoDTO;
import com.cloud.sims.business.module.grade.pojo.entity.Grade;
import com.cloud.sims.business.module.grade.pojo.from.EditFrom;
import com.cloud.sims.business.module.grade.pojo.from.GradeFrom;
import com.cloud.sims.business.module.grade.pojo.from.NoticeFrom;
import com.cloud.sims.common.base.service.IBaseService;

import java.util.List;

/**
 * @author Long
 */
public interface GradeService extends IBaseService<Grade, String> {
    void edit(EditFrom from);

    /**
     * 发布公告
     * @param from
     */
    void setNotice(NoticeFrom from);

    List<Grade> findByNumber(String number);

    List<Grade> findByName(String name);
    /**
     *
     * @param from
     * @return
     */
    Grade add(GradeFrom from);

    /**
     *
     * @param leaderId
     * @return
     */
    List<Grade> getGradeByLeaderId(String leaderId);

    /**
     * 根据ID获取班级信息
     * @param id
     * @return
     */
    GradeInfoDTO    findGradeInfoDTOByGradeId(String id);


    /**
     * 根据ID获取班级学生信息
     * @param id
     * @return
     */
    GradeInfoDTO    findGradeStudentInfoDTOByGradeId(String id);

    /**
     * 根据ID获取班级课程信息
     * @param id
     * @return
     */
    GradeInfoDTO    findGradeCourseInfoDTOByGradeId(String id);

    /**
     * 根据班级获取班级信息
     * @param grade
     * @return
     */
    GradeInfoDTO findByGrade(Grade grade);

    /**
     * 根据用户ID获取其班级简短信息
     * @param userId
     * @return
     */
    GradeShortInfoDTO findGradeShortInfoDTO(String userId, String type);

    /**
     * 获取教师的班级列表
     * @param userId
     * @return
     */
//    List<Grade>findLeaderGradeS(String userId);

    /**
     * 获取学生班级列表
     * @param userId
     * @return
     */
    List<Grade> getStudentGrade(String userId);
}

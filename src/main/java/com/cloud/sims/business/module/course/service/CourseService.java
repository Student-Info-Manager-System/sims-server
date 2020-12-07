package com.cloud.sims.business.module.course.service;

import com.cloud.sims.business.module.course.pojo.dto.GradeCourseListInfoDTO;
import com.cloud.sims.business.module.course.pojo.entity.Course;
import com.cloud.sims.business.module.course.pojo.from.CourseFrom;
import com.cloud.sims.business.module.course.pojo.from.EditFrom;
import com.cloud.sims.common.base.service.IBaseService;

import java.util.List;

/**
 * @author Long
 */
public interface CourseService extends IBaseService<Course, String> {


    /**
     *
     * @param search
     * @return
     */
    List<Course> search(String search);

    /**
     *
     * @param from
     */
    void edit(EditFrom from);


    /**
     * 新增课程
     * @param from
     * @return
     */
    Course add(CourseFrom from);

    /**
     * 获取课程名
     * @param id
     * @return
     */
    String getCourseNameById(String id);

    /**
     * 根据name模糊查询
     * @param name
     * @return
     */
    List<String> findCourseIdByName(String name);

    /**
     *
     * @param gradeId
     * @return
     */
    GradeCourseListInfoDTO findDtoByGradeId(String gradeId);
}

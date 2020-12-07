package com.cloud.sims.business.module.timetable.pojo.vo;

import com.cloud.sims.business.module.course.pojo.entity.Course;
import com.cloud.sims.business.module.grade.pojo.entity.Grade;
import com.cloud.sims.business.module.timetable.pojo.entity.Timetable;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ApiModel("课程表")
public class TimetableVO {
    private String name;
    private String teachTime;
    private String teacher;
    private String teachPosition;
}

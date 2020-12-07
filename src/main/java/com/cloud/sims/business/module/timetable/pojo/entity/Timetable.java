package com.cloud.sims.business.module.timetable.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.sims.common.base.pojo.entity.IBaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Long
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName(value = "cloud_sims_timetable")
@Entity
@Table(name = "cloud_sims_timetable")
public class Timetable extends IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "grade_id", columnDefinition="varchar(36) COMMENT '班级ID'")
    private String gradeId;

    @Column(name = "course_id", columnDefinition="varchar(36) COMMENT '课程ID'")
    private String courseId;

    @Column(name = "teach_position", columnDefinition="varchar(64) COMMENT '授课地点'")
    private String teachPosition;

    @Column(name = "teach_time", columnDefinition="varchar(16) COMMENT '授课时间'")
    private String teachTime;

    @Column(name = "teacher", columnDefinition="varchar(16) COMMENT '授课教师'")
    private String teacher;
}

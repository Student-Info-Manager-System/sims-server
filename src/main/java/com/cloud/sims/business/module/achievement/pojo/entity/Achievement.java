package com.cloud.sims.business.module.achievement.pojo.entity;

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
@TableName(value = "cloud_sims_achievement")
@Entity
@Table(name = "cloud_sims_achievement")
public class Achievement extends IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "student_id", columnDefinition="varchar(36) COMMENT '学生ID'")
    private String studentId;

    @Column(name = "course_id", columnDefinition="varchar(36) COMMENT '课程号'")
    private String courseId;

    @Column(name = "score", columnDefinition="varchar(8) COMMENT '学分'")
    private String score;
}

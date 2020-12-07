package com.cloud.sims.business.module.course.pojo.entity;

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
@TableName(value = "cloud_sims_course")
@Entity
@Table(name = "cloud_sims_course")
public class Course extends IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "number", columnDefinition="varchar(16) COMMENT '课程号'")
    private String number;

    @Column(name = "major_id", columnDefinition="varchar(36) COMMENT '专业ID'")
    private String majorId;

    @Column(name = "name", columnDefinition="varchar(36) COMMENT '课程名'")
    private String name;

    @Column(name = "learn_time", columnDefinition="varchar(8) COMMENT '学时'")
    private String learnTime;

    @Column(name = "credit", columnDefinition="varchar(8) COMMENT '学分'")
    private String credit;
}

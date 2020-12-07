package com.cloud.sims.business.module.student.pojo.entity;

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
@TableName(value = "cloud_sims_student")
@Entity
@Table(name = "cloud_sims_student")
public class Student extends IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "sys_user_id", columnDefinition="varchar(36) COMMENT '系统用户ID'")
    private String sysUserId;

    @Column(name = "number", columnDefinition="varchar(16) COMMENT '学号'")
    private String number;

    @Column(name = "grade_id", columnDefinition="varchar(36) COMMENT '班级ID'")
    private String gradeId;

    @Column(name = "position", columnDefinition="varchar(16) COMMENT '职位'")
    private String position;
}

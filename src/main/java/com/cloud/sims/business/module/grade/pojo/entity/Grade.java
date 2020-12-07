package com.cloud.sims.business.module.grade.pojo.entity;

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
@TableName(value = "cloud_sims_grade")
@Entity
@Table(name = "cloud_sims_grade")
public class Grade extends IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "name", columnDefinition="varchar(36) COMMENT '班级名'")
    private String name;

    @Column(name = "number", columnDefinition="varchar(16) COMMENT '班级号'")
    private String number;

    @Column(name = "major_id", columnDefinition="varchar(36) COMMENT '专业ID'")
    private String majorId;

    @Column(name = "leader_id", columnDefinition="varchar(36) COMMENT '班主任ID'")
    private String leaderId;

    @Column(name = "year", columnDefinition="varchar(8) COMMENT '开设年份'")
    private String year;

    @Column(name = "notice", columnDefinition="varchar(512) COMMENT '班级公告'")
    private String notice;
}

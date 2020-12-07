package com.cloud.sims.business.module.major.pojo.entity;


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
@TableName(value = "cloud_sims_major")
@Entity
@Table(name = "cloud_sims_major")
public class Major extends IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "name", columnDefinition="varchar(36) COMMENT '专业名称'")
    private String name;

    @Column(name = "code", columnDefinition="varchar(16) COMMENT '专业代码'")
    private String code;
}

package com.cloud.sims.business.module.leader.pojo.entity;

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
@TableName(value = "cloud_sims_leader")
@Entity
@Table(name = "cloud_sims_leader")
public class Leader extends IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "sys_user_id", columnDefinition="varchar(36) COMMENT '系统用户ID'")
    private String sysUserId;

    @Column(name = "number", columnDefinition="varchar(16) COMMENT '工号'")
    private String number;

    @Column(name = "leader_type", columnDefinition="varchar(4) COMMENT '领导类型'")
    private String leaderType;
}

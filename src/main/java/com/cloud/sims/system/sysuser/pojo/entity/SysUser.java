package com.cloud.sims.system.sysuser.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.sims.common.base.pojo.entity.IBaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

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
@TableName(value = "cloud_sims_sys_user")
@Entity
@Table(name = "cloud_sims_sys_user")
public class SysUser extends IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "username", columnDefinition="varchar(32) COMMENT '用户名'")
    private String username;

    @Column(name = "name", columnDefinition="varchar(32) COMMENT '姓名'")
    private String name;

    @Column(name = "sex", columnDefinition="varchar(2) COMMENT '性别'")
    private String sex;

    @Column(name = "avatar", columnDefinition="varchar(256) COMMENT '头像'")
    private String avatar;

    @Column(name = "password", columnDefinition="varchar(64) COMMENT '密码'")
    private String password;

    @Column(name = "email", columnDefinition="varchar(64) COMMENT '邮箱'")
    private String email;

    @Column(name = "phone", columnDefinition="varchar(16) COMMENT '邮箱'")
    private String phone;

    @Column(name = "address", columnDefinition="varchar(256) COMMENT '住址'")
    private String address;

    @Column(name = "birth", columnDefinition="datetime(0) COMMENT '出生日期'")
    private Date birth;

    @Column(name = "type", columnDefinition="varchar(2) COMMENT '用户类型'")
    private String type;

    @Column(name = "status", columnDefinition="varchar(2) COMMENT '状态' DEFAULT '1'")
    private String status;
}

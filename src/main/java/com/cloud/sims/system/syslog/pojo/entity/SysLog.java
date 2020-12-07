package com.cloud.sims.system.syslog.pojo.entity;

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
@TableName(value = "cloud_sims_sys_log")
@Entity
@Table(name = "cloud_sims_sys_log")
public class SysLog extends IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 操作模块
     */
    @Column(name = "model", columnDefinition="varchar(255) COMMENT '操作模块' DEFAULT '信息未授权'")
    private String model;

    /**
     * 操作模块
     */
    @Column(name = "url", columnDefinition="varchar(255) COMMENT '操作地址' DEFAULT '操作地址'")
    private String url;

    /**
     * 日志类型
     */
    @Column(name = "log_type", columnDefinition="int(4) COMMENT '操作类型'")
    private Integer logType;
    /**
     * 操作类型
     */
    @Column(name = "operate_type", columnDefinition="int(4) COMMENT '操作类型'")
    private Integer operateType;

    /**
     * 操作说明
     */
    @Column(name = "content", columnDefinition="varchar(255) COMMENT '操作信息' DEFAULT '信息未授权'")
    private String content;

    /**
     * 操作方法
     */
    @Column(name = "method", columnDefinition="varchar(500) COMMENT '操作方法' DEFAULT '信息未授权'")
    private String method;

    @Column(name = "ip", columnDefinition="varchar(64) COMMENT 'IP'")
    private String ip;

    @Column(name = "device", columnDefinition="varchar(36) COMMENT '设备型号' DEFAULT '未知'")
    private String device;

    @Column(name = "message", columnDefinition="text COMMENT '结果信息'")
    private String message;

    @Column(name = "success", columnDefinition="tinyint(1) COMMENT '操作状态'")
    private Boolean success;

    @Column(name = "code", columnDefinition="int(6) COMMENT '操作状态码(-1未知)'")
    private Integer code;

    @Column(name = "user_id", columnDefinition="varchar(36) COMMENT '操作者'")
    private String userId;


    public SysLog setModel(String model) {
        this.model = model;
        return this;
    }

    public SysLog setUrl(String url) {
        this.url = url;
        return this;
    }

    public SysLog setLogType(Integer logType) {
        this.logType = logType;
        return this;
    }

    public SysLog setOperateType(Integer operateType) {
        this.operateType = operateType;
        return this;
    }

    public SysLog setValue(String content) {
        this.content = content;
        return this;
    }

    public SysLog setMethod(String method) {
        this.method = method;
        return this;
    }

    public SysLog setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public SysLog setDevice(String device) {
        this.device = device;
        return this;
    }

    public SysLog setMessage(String message) {
        this.message = message;
        return this;
    }

    public SysLog setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public SysLog setCode(Integer code) {
        this.code = code;
        return this;
    }

    public SysLog setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}

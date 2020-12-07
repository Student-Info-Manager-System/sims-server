package com.cloud.sims.common.base.pojo.entity;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Long
 */
@Setter
@Getter
//作为实体父类要让子类拥有自己的属性（数据库表中），需要加此注解
@MappedSuperclass
public class IBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @TableId(type = IdType.UUID)
    @Column(name = "id", columnDefinition="varchar(36) COMMENT '主键'")
    protected String id;

    @TableField(fill = FieldFill.INSERT)
    @Column(name = "create_time", columnDefinition="datetime(0) COMMENT '创建时间'")
    protected Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    @Column(name = "update_time", columnDefinition="datetime(0) COMMENT '更新时间'")
    protected Date updateTime;

    /**
     * @TableLogic 逻辑删除
     */
    @TableLogic(value = "0", delval = "1")
    @Column(name = "is_delete", columnDefinition="tinyint(1) COMMENT '是否删除' default '0'")
    protected Boolean isDelete;

    /**
     * 使用version 乐观锁
     */
    @Version
    @Column(name = "version", columnDefinition="int(11) COMMENT '版本号' default '0'")
    private Integer version;
}

package com.cloud.sims.business.module.course.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Long
 */
@Getter
@Setter
@ApiModel(description="班级课程信息")
public class GradeCourseInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "课程号")
    private String number;

    @ApiModelProperty(value = "学时")
    private String learnTime;

    @ApiModelProperty(value = "课程名")
    private String name;

    @ApiModelProperty(value = "学分")
    private String credit;

    protected Date createTime;
}

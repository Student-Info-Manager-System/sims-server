package com.cloud.sims.business.module.grade.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Long
 */
@Getter
@Setter
@ApiModel(description="班级信息")
public class GradeShortInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "班级名称")
    private String name;
}

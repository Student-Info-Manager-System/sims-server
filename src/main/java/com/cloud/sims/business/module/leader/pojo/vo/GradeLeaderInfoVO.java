package com.cloud.sims.business.module.leader.pojo.vo;


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
@ApiModel(description="班级教师信息")
public class GradeLeaderInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "教师工号")
    private String number;

    @ApiModelProperty(value = "教师姓名")
    private String name;

    @ApiModelProperty(value = "教师头像")
    private String avatar;

//    @ApiModelProperty(value = "教师类型")
//    private String leaderType;
}

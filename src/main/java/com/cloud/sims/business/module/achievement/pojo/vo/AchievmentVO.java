package com.cloud.sims.business.module.achievement.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Long
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description="学生成绩信息")
public class AchievmentVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    @ApiModelProperty(value = "学分")
    private String score;
}

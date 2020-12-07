package com.cloud.sims.business.module.grade.pojo.vo;

import com.cloud.sims.business.module.course.pojo.vo.GradeCourseInfoVO;
import com.cloud.sims.business.module.leader.pojo.vo.GradeLeaderInfoVO;
import com.cloud.sims.business.module.student.pojo.vo.GradeStudentInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Long
 */
@Getter
@Setter
@ApiModel(description="班级信息")
public class GradeInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "班级名称")
    private String name;
    @ApiModelProperty(value = "班级号")
    private String number;
    @ApiModelProperty(value = "所属专业")
    private String majorId;
    @ApiModelProperty(value = "建立学年")
    private String year;
    @ApiModelProperty(value = "班级公告")
    private String notice;

    @ApiModelProperty(value = "班主任")
    private GradeLeaderInfoVO leader;

    @ApiModelProperty(value = "班级学生")
    private List<GradeStudentInfoVO> students;

    @ApiModelProperty(value = "班级课程")
    private List<GradeCourseInfoVO> courses;
}

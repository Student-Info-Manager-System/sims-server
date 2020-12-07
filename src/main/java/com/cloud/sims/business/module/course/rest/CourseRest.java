package com.cloud.sims.business.module.course.rest;

import com.cloud.sims.business.module.course.pojo.dto.GradeCourseListInfoDTO;
import com.cloud.sims.business.module.course.pojo.entity.Course;
import com.cloud.sims.business.module.course.pojo.from.CourseFrom;
import com.cloud.sims.business.module.course.pojo.from.EditFrom;
import com.cloud.sims.business.module.course.service.CourseService;
import com.cloud.sims.common.base.rest.IBaseRest;
import com.cloud.sims.common.config.annotation.ApiLog;
import com.cloud.sims.common.config.annotation.Authority;
import com.cloud.sims.common.config.annotation.VisitController;
import com.cloud.sims.common.config.result.Result;
import com.cloud.sims.common.constant.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Long
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/sims/course/v1")
@RequiredArgsConstructor
@Api(tags = "课程模块")
public class CourseRest extends IBaseRest<Course, String, CourseService, CourseRest> {
//    @Authority(root = {Constant.USER_TYPE_LEADER})
    @ApiLog(value = "新增课程", model = "课程模块")
    @VisitController
    @ApiOperation(value = "新增课程")
    @PostMapping(value = "add")
    public Result<?> add(@Validated @RequestBody CourseFrom from){
        return Result.ok(service.add(from));
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "获取班级课程列表", model = "课程模块")
    @VisitController
    @ApiOperation(value = "获取班级课程列表")
    @GetMapping(value = "getByGradeId/{gradeId}")
    public Result<?> geByGradeId(@PathVariable("gradeId") String gradeId) {
        GradeCourseListInfoDTO dto = service.findDtoByGradeId(gradeId);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "修改课程信息", model = "课程模块")
    @VisitController
    @ApiOperation(value = "修改课程信息")
    @PostMapping(value = "edit")
    public Result<?> edit(@Validated @RequestBody EditFrom from) {
        service.edit(from);
        return Result.ok();
    }
}

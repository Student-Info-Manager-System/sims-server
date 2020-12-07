package com.cloud.sims.business.module.grade.rest;

import com.cloud.sims.business.module.grade.pojo.dto.GradeInfoDTO;
import com.cloud.sims.business.module.grade.pojo.dto.GradeShortInfoDTO;
import com.cloud.sims.business.module.grade.pojo.entity.Grade;
import com.cloud.sims.business.module.grade.pojo.from.EditFrom;
import com.cloud.sims.business.module.grade.pojo.from.GradeFrom;
import com.cloud.sims.business.module.grade.pojo.from.NoticeFrom;
import com.cloud.sims.business.module.grade.service.GradeService;
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
@Authority
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/sims/grade/v1")
@RequiredArgsConstructor
@Api(tags = "班级模块")
public class GradeRest extends IBaseRest<Grade, String, GradeService, GradeRest> {


    //    @ApiLog(value = "获取当前登录用户班级信息", model = "班级模块")
//    @VisitController
//    @ApiOperation(value = "获取当前登录用户班级信息")
//    @GetMapping(value = "findByLogin")
//    public Result<?> findByLogin(){
//        return Result.ok();
//    }



    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "修改班级名称", model = "班级模块")
    @VisitController
    @ApiOperation(value = "修改班级名称")
    @PostMapping(value = "edit")
    public Result<?> edit(@Validated @RequestBody EditFrom from) {
        service.edit(from);
        return Result.ok();
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "发布公告", model = "班级模块")
    @VisitController
    @ApiOperation(value = "发布公告")
    @PostMapping(value = "notice")
    public Result<?> notice(@Validated @RequestBody NoticeFrom from) {
        service.setNotice(from);
        return Result.ok();
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "新增班级", model = "班级模块")
    @VisitController
    @ApiOperation(value = "新增班级")
    @PostMapping(value = "add")
    public Result<?> add(@Validated @RequestBody GradeFrom from) {
        return Result.ok(service.add(from));
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "根据班级ID获取班级信息", model = "班级模块")
    @VisitController
    @ApiOperation(value = "根据班级ID获取班级信息")
    @GetMapping(value = "findInfoById/{id}")
    public Result<?> findInfoById(@PathVariable("id") String id) {
        GradeInfoDTO dto = service.findGradeInfoDTOByGradeId(id);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "根据班级ID获取班级学生信息", model = "班级模块")
    @VisitController
    @ApiOperation(value = "根据班级ID获取班级学生信息")
    @GetMapping(value = "findStudentInfoById/{id}")
    public Result<?> findStudentInfoById(@PathVariable("id") String id) {
        GradeInfoDTO dto = service.findGradeStudentInfoDTOByGradeId(id);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "根据班级ID获取班级课程信息", model = "班级模块")
    @VisitController
    @ApiOperation(value = "根据班级ID获取班级课程信息")
    @GetMapping(value = "findCourseInfoById/{id}")
    public Result<?> findCourseInfoById(@PathVariable("id") String id) {
        GradeInfoDTO dto = service.findGradeCourseInfoDTOByGradeId(id);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "获取用户的班级列表", model = "班级模块")
    @VisitController
    @ApiOperation(value = "获取用户的班级列表")
    @GetMapping(value = "findInfoByUserId/{type}/{id}")
    public Result<?> findInfoById(@PathVariable("type") String type, @PathVariable("id") String id) {
        GradeShortInfoDTO dto = service.findGradeShortInfoDTO(id, type);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }
}

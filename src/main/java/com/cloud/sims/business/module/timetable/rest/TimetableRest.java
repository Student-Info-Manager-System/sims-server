package com.cloud.sims.business.module.timetable.rest;

import com.cloud.sims.business.module.timetable.pojo.entity.Timetable;
import com.cloud.sims.business.module.timetable.pojo.from.TimetableFrom;
import com.cloud.sims.business.module.timetable.service.TimetableService;
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
@RequestMapping("/sims/timetable/v1")
@RequiredArgsConstructor
@Api(tags = "课表模块")
public class TimetableRest extends IBaseRest<Timetable, String, TimetableService, TimetableRest> {

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "新增课表", model = "课表模块")
    @VisitController
    @ApiOperation(value = "新增课表")
    @PostMapping(value = "add")
    public Result<?> add(@Validated @RequestBody TimetableFrom from){
        return Result.ok(service.add(from));
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER, Constant.USER_TYPE_STUDENT})
    @ApiLog(value = "课表查询", model = "课表模块")
    @VisitController
    @ApiOperation(value = "课表查询")
    @GetMapping(value = "table/{gradeId}")
    public Result<?> table(@PathVariable("gradeId") String gradeId){
        return Result.ok(service.getTimetableVO(gradeId));
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER, Constant.USER_TYPE_STUDENT})
    @ApiLog(value = "课表搜索", model = "课表模块")
    @VisitController
    @ApiOperation(value = "课表搜索")
    @GetMapping(value = "table/{gradeId}/{search}")
    public Result<?> search(@PathVariable("gradeId") String gradeId, @PathVariable("search") String search){
        return Result.ok(service.search(gradeId, search));
    }
}

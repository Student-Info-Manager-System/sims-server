package com.cloud.sims.business.module.major.rest;

import com.cloud.sims.business.module.major.pojo.entity.Major;
import com.cloud.sims.business.module.major.pojo.from.MajorFrom;
import com.cloud.sims.business.module.major.service.MajorService;
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
@RequestMapping("/sims/major/v1")
@RequiredArgsConstructor
@Api(tags = "专业模块")
public class MajorRest extends IBaseRest<Major, String, MajorService, MajorRest> {

//    @Authority(root = {Constant.USER_TYPE_LEADER})
    @ApiLog(value = "新增专业", model = "专业模块")
    @VisitController
    @ApiOperation(value = "新增专业")
    @PostMapping(value = "add")
    public Result<?> add(@Validated @RequestBody MajorFrom from){
        return Result.ok(service.addMajor(from));
    }
}

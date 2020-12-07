package com.cloud.sims.business.module.leader.rest;

import com.cloud.sims.business.module.leader.pojo.entity.Leader;
import com.cloud.sims.business.module.leader.service.LeaderService;
import com.cloud.sims.common.base.rest.IBaseRest;
import com.cloud.sims.common.config.annotation.ApiLog;
import com.cloud.sims.common.config.annotation.Authority;
import com.cloud.sims.common.config.annotation.VisitController;
import com.cloud.sims.common.config.result.Result;
import com.cloud.sims.common.constant.Constant;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import com.cloud.sims.system.sysuser.pojo.from.LoginFrom;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Long
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/sims/leader/v1")
@RequiredArgsConstructor
@Api(tags = "管理员模块")
public class LeaderRest extends IBaseRest<Leader, String, LeaderService, LeaderRest> {



    @ApiLog(value = "教师登录", model = "管理员模块")
    @VisitController
    @ApiOperation(value = "教师登录")
    @PostMapping(value = "login")
    public Result<?> login(HttpServletResponse res, @Validated @RequestBody LoginFrom from){
        UserInfoDTO dto = service.login(from);
        if (dto.getSuccess()) {
            service.login(res, dto);
            return Result.ok(service.login(dto));
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "根据工号获取教师信息", model = "管理员模块")
    @VisitController
    @ApiOperation(value = "根据工号获取教师信息")
    @GetMapping(value = "findByNumber/{number}")
    public Result<?> findByNumber(HttpServletRequest req, HttpServletResponse res, @PathVariable("number") String number){
        UserInfoDTO dto = service.getDtoByNumber(number);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "获取当前登录教师信息", model = "管理员模块")
    @VisitController
    @ApiOperation(value = "获取当前登录教师信息")
    @GetMapping(value = "findLogin")
    public Result<?> getLogin(){
        UserInfoDTO dto = service.getLogin();
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "获取当前登录教师的班级ID", model = "管理员模块")
    @VisitController
    @ApiOperation(value = "获取当前登录教师的班级ID")
    @GetMapping(value = "getGradeId")
    public Result<?> getGradeId(){
        UserInfoDTO dto = service.getLogin();
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }
}

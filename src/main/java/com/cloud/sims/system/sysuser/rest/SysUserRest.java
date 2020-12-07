package com.cloud.sims.system.sysuser.rest;

import com.cloud.sims.common.base.rest.IBaseRest;
import com.cloud.sims.common.config.annotation.ApiLog;
import com.cloud.sims.common.config.annotation.Authority;
import com.cloud.sims.common.config.annotation.VisitController;
import com.cloud.sims.common.config.result.Result;
import com.cloud.sims.common.constant.Constant;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import com.cloud.sims.system.sysuser.pojo.entity.SysUser;
import com.cloud.sims.system.sysuser.pojo.from.EditPwdFrom;
import com.cloud.sims.system.sysuser.pojo.from.EditUserFrom;
import com.cloud.sims.system.sysuser.service.SysUserService;
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
@RequestMapping("/sims/user/v1")
@RequiredArgsConstructor
@Api(tags = "用户模块")
public class SysUserRest extends IBaseRest<SysUser, String, SysUserService, SysUserRest> {

    @ApiLog(value = "注销登录", model = "用户管理")
    @VisitController
    @ApiOperation(value = "注销登录")
    @GetMapping("/logout")
    public Result<?> logout() {
        service.logout();
        return Result.ok();
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "修改个人信息", model = "用户模块")
    @VisitController
    @ApiOperation(value = "修改个人信息")
    @PostMapping(value = "edit")
    public Result<?> edit(@Validated @RequestBody EditUserFrom from){
        UserInfoDTO dto = service.edit(from);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }


    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "修改密码", model = "用户模块")
    @VisitController
    @ApiOperation(value = "修改密码")
    @PostMapping(value = "editPwd")
    public Result<?> editPwd(@Validated @RequestBody EditPwdFrom from){
        service.editPwd(from);
        return Result.ok();
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "获取当前登录用户信息", model = "用户模块")
    @VisitController
    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "findUserInfo")
    public Result<?> findUserInfo(){
        UserInfoDTO dto = service.findByUserLogin();
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }
}

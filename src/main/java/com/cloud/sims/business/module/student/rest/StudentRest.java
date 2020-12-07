package com.cloud.sims.business.module.student.rest;

import com.cloud.sims.business.module.student.pojo.dto.GradeStudentListInfoDTO;
import com.cloud.sims.business.module.student.pojo.from.AddStudentFrom;
import com.cloud.sims.business.module.student.pojo.from.EditStudentFrom;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import com.cloud.sims.business.module.student.pojo.entity.Student;
import com.cloud.sims.business.module.student.service.StudentService;
import com.cloud.sims.common.base.rest.IBaseRest;
import com.cloud.sims.common.config.annotation.ApiLog;
import com.cloud.sims.common.config.annotation.Authority;
import com.cloud.sims.common.config.annotation.VisitController;
import com.cloud.sims.common.config.result.Result;
import com.cloud.sims.common.constant.Constant;
import com.cloud.sims.system.sysuser.pojo.from.EditUserFrom;
import com.cloud.sims.system.sysuser.pojo.from.LoginFrom;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Long
 */

@Authority
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/sims/student/v1")
@RequiredArgsConstructor
@Api(tags = "学生模块")
public class StudentRest extends IBaseRest<Student, String, StudentService, StudentRest> {

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "搜索(学号/姓名)", model = "学生模块")
    @VisitController
    @ApiOperation(value = "搜索(学号/姓名)")
    @GetMapping(value = "search/{search}")
    public Result<?> search(@PathVariable("search") String search) {
        GradeStudentListInfoDTO dto = service.search(search);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "根据系统用户ID获取", model = "学生模块")
    @VisitController
    @ApiOperation(value = "根据系统用户ID获取")
    @GetMapping(value = "getSysUserId/{sysUserId}")
    public Result<?> getBySysUserId(@PathVariable("sysUserId") String sysUserId) {
        return Result.ok(service.getBySysUserId(sysUserId));
    }


    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "删除用户", model = "学生模块")
    @VisitController
    @ApiOperation(value = "删除用户")
    @GetMapping(value = "del/{id}")
    public Result<?> del(@PathVariable("id") String id) {
        service.del(id);
        return Result.ok();
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT})
    @ApiLog(value = "获取当前登录学生信息", model = "学生模块")
    @VisitController
    @ApiOperation(value = "获取当前登录学生信息")
    @GetMapping(value = "findLogin")
    public Result<?> getLogin() {
        UserInfoDTO dto = service.getLogin();
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "根据学号获取学生信息", model = "学生模块")
    @VisitController
    @ApiOperation(value = "根据学号获取学生信息")
    @GetMapping(value = "findByNumber/{number}")
    public Result<?> findByNumber(HttpServletRequest req, HttpServletResponse res, @PathVariable("number") String number) {
        UserInfoDTO dto = service.getDtoByNumber(number);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "修改个人信息", model = "学生模块")
    @VisitController
    @ApiOperation(value = "修改个人信息")
    @PostMapping(value = "edit")
    public Result<?> edit(@Validated @RequestBody EditUserFrom from) {
        UserInfoDTO dto = service.edit(from);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "新增学生", model = "学生模块")
    @VisitController
    @ApiOperation(value = "新增学生")
    @PostMapping(value = "add")
    public Result<?> add(@Validated @RequestBody AddStudentFrom from) {
        UserInfoDTO dto = service.add(from);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @Authority(root = {Constant.USER_TYPE_TEACHER})
    @ApiLog(value = "修改学生信息", model = "学生模块")
    @VisitController
    @ApiOperation(value = "修改学生信息")
    @PostMapping(value = "editStudent")
    public Result<?> editStudent(@Validated @RequestBody EditStudentFrom from) {
        service.edit(from);
        return Result.ok();
    }

    @ApiLog(value = "学生登录", model = "学生模块")
    @VisitController
    @ApiOperation(value = "学生登录")
    @PostMapping(value = "login")
    public Result<?> login(HttpServletResponse res, @Validated @RequestBody LoginFrom from) {
        UserInfoDTO dto = service.login(from);
        if (dto.getSuccess()) {
            service.login(res, dto);
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }
}

package com.cloud.sims.business.module.achievement.rest;

import com.cloud.sims.business.module.achievement.pojo.dto.StudentAchievementListDTO;
import com.cloud.sims.business.module.achievement.pojo.entity.Achievement;
import com.cloud.sims.business.module.achievement.service.AchievementService;
import com.cloud.sims.common.base.rest.IBaseRest;
import com.cloud.sims.common.config.annotation.ApiLog;
import com.cloud.sims.common.config.annotation.VisitController;
import com.cloud.sims.common.config.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Long
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/sims/achievement/v1")
@RequiredArgsConstructor
@Api(tags = "成绩模块")
public class AchievementRest extends IBaseRest<Achievement, String, AchievementService, AchievementRest> {



    @ApiLog(value = "修改成绩", model = "成绩模块")
    @VisitController
    @ApiOperation(value = "修改成绩")
    @GetMapping(value = "putScore/{courseId}/{studentId}/{score}")
    public Result<?> putScore( @PathVariable("courseId") String courseId, @PathVariable("studentId") String studentId, @PathVariable("score") String score) {
        service.putScore( courseId, studentId, score);
        return Result.ok();
    }

    @ApiLog(value = "学生成绩", model = "班级模块")
    @VisitController
    @ApiOperation(value = "学生成绩")
    @GetMapping(value = "getStudentScore/{gradeId}/{courseId}")
    public Result<?> getStudentScore(@PathVariable("gradeId") String gradeId, @PathVariable("courseId") String courseId) {
        return Result.ok(service.getAchievmentVO(gradeId, courseId));
    }

    @ApiLog(value = "获取学生成绩表", model = "班级模块")
    @VisitController
    @ApiOperation(value = "获取学生成绩表")
    @GetMapping(value = "findStudentAchievement/{studentId}")
    public Result<?> findStudentAchievement(@PathVariable("studentId") String studentId) {
        StudentAchievementListDTO dto = service.findStudentAchievement(studentId);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }

    @ApiLog(value = "课程名模糊查询学生成绩", model = "班级模块")
    @VisitController
    @ApiOperation(value = "课程名模糊查询学生成绩")
    @GetMapping(value = "findStudentAchievement/{studentId}/{courseName}")
    public Result<?> findStudentAchievement(@PathVariable("studentId") String studentId, @PathVariable("courseName") String courseName) {
        StudentAchievementListDTO dto = service.findStudentAchievement(studentId, courseName);
        if (dto.getSuccess()) {
            return Result.ok(dto.getVo());
        }
        return Result.error(dto.getMessage());
    }
}

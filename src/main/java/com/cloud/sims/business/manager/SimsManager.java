package com.cloud.sims.business.manager;

import com.cloud.sims.business.module.achievement.service.AchievementService;
import com.cloud.sims.business.module.course.service.CourseService;
import com.cloud.sims.business.module.grade.service.GradeService;
import com.cloud.sims.business.module.leader.service.LeaderService;
import com.cloud.sims.business.module.major.service.MajorService;
import com.cloud.sims.business.module.student.service.StudentService;
import com.cloud.sims.business.module.timetable.service.TimetableService;
import com.cloud.sims.system.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Long
 */
@Component
public class SimsManager {
    @Autowired
    public SysUserService sysUserService;
    @Autowired
    public AchievementService achievementService;
    @Autowired
    public CourseService courseService;
    @Autowired
    public LeaderService leaderService;
    @Autowired
    public GradeService gradeService;
    @Autowired
    public MajorService majorService;
    @Autowired
    public StudentService studentService;
    @Autowired
    public TimetableService timetableService;
}

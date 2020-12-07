

--系统用户信息 Start
INSERT INTO
`cloud_sims_sys_user`
(`id`, `is_delete`, `version`, `address`, `avatar`, `email`, `name`, `password`, `phone`, `sex`, `status`, `type`, `username`)
VALUES ('admin', '0', '0', '地球', 'http://qzapp.qlogo.cn/qzapp/101914038/5B0473076C3092B3AB5A4062D1132C04/100', '1753047507@qq.com', '管理员', '123456', '17683905916', '1', '0', '3', 'admin');

INSERT INTO
`cloud_sims_sys_user`
(`id`, `is_delete`, `version`, `address`, `avatar`, `email`, `name`, `password`, `phone`, `sex`, `status`, `type`, `username`)
VALUES ('t1', '0', '0', '湖北', 'http://qzapp.qlogo.cn/qzapp/101914038/5B0473076C3092B3AB5A4062D1132C04/100', '1753047507@qq.com', '杜君', '123456', '17683905916', '1', '0', '3', 'dj');

INSERT INTO
`cloud_sims_sys_user`
(`id`, `is_delete`, `version`, `address`, `avatar`, `email`, `name`, `password`, `phone`, `sex`, `status`, `type`, `username`)
VALUES ('s1', '0', '0', '湖北', 'http://qzapp.qlogo.cn/qzapp/101914038/5B0473076C3092B3AB5A4062D1132C04/100', '1753047507@qq.com', '龙芯', '123456', '17683905916', '1', '0', '3', 'lx');

INSERT INTO
`cloud_sims_sys_user`
(`id`, `is_delete`, `version`, `address`, `avatar`, `email`, `name`, `password`, `phone`, `sex`, `status`, `type`, `username`)
VALUES ('s2', '0', '0', '湖北', 'http://qzapp.qlogo.cn/qzapp/101914038/5B0473076C3092B3AB5A4062D1132C04/100', '1753047507@qq.com', '张涛', '123456', '17683905916', '1', '0', '3', 'zt');

INSERT INTO
`cloud_sims_sys_user`
(`id`, `is_delete`, `version`, `address`, `avatar`, `email`, `name`, `password`, `phone`, `sex`, `status`, `type`, `username`)
VALUES ('s3', '0', '0', '河南', 'http://qzapp.qlogo.cn/qzapp/101914038/5B0473076C3092B3AB5A4062D1132C04/100', '1753047507@qq.com', '王鑫', '123456', '17683905916', '1', '0', '3', 'wx');

INSERT INTO
`cloud_sims_sys_user`
(`id`, `is_delete`, `version`, `address`, `avatar`, `email`, `name`, `password`, `phone`, `sex`, `status`, `type`, `username`)
VALUES ('s4', '0', '0', '湖北', 'http://qzapp.qlogo.cn/qzapp/101914038/5B0473076C3092B3AB5A4062D1132C04/100', '1753047507@qq.com', '沈赛琪', '123456', '17683905916', '1', '0', '3', 'ssq');

-- 系统用户信息 End


-- 教师信息 Start
INSERT INTO
`sims`.`cloud_sims_leader`
(`id`, `is_delete`, `version`, `leader_type`, `number`, `sys_user_id`)
VALUES ('l2', '0', '0', '0', '51830021401', 't1');

INSERT INTO
`sims`.`cloud_sims_leader`
(`id`, `is_delete`, `version`, `leader_type`, `number`, `sys_user_id`)
VALUES ('l1', '0', '0', '0', '51830021402', 't2');

-- 教师信息 End

-- 班级信息 Start



INSERT INTO
`sims`.`cloud_sims_grade`
(`id`, `is_delete`, `version`, `leader_id`, `major_id`, `name`, `notice`, `number`)
VALUES ('g2', '0', '0', 'l2', '1', '计科二班', '抓紧时间钉钉打卡，每天都要坚持啊，革命尚未成功，同志仍需努力！', '5183002142');

-- 班级信息 End

-- 学生信息 Start

INSERT INTO
`sims`.`cloud_sims_student`
(`id`, `is_delete`, `version`, `grade_id`, `number`, `position`, `sys_user_id`)
VALUES ('s1', '0', '0', 'g2', '518300214213', '', 's1');

INSERT INTO
`sims`.`cloud_sims_student`
(`id`, `is_delete`, `version`, `grade_id`, `number`, `position`, `sys_user_id`)
VALUES ('s2', '0', '0', 'g2', '518300214231', '', 's2');

INSERT INTO
`sims`.`cloud_sims_student`
(`id`, `is_delete`, `version`, `grade_id`, `number`, `position`, `sys_user_id`)
VALUES ('s4', '0', '0', 'g2', '518300214215', '', 's4');

INSERT INTO
`sims`.`cloud_sims_student`
(`id`, `is_delete`, `version`, `grade_id`, `number`, `position`, `sys_user_id`)
VALUES ('s3', '0', '0', 'g2', '518300214220', '', 's3');

-- 学生信息





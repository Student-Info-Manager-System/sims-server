package com.cloud.sims.common.constant;

/**
 * @author Long
 */
public interface Constant {
    /**
     * 导出模板路由
     */
    String MAPP_URL_SUPER_EXPORT_TEMPLAT = "/super-export-templat";

    String MAPP_URL_SUPER_EXPORT_DATA = "/super-export-data";

    /**
     * 加密串过期时间（秒）
     */
    Integer ENCRYPT_TIME_OUT_MAX_SECONDES = 60;


    /**
     * 系统日志类型： 登录
     */
    int LOG_TYPE_1 = 1;

    /**
     * 系统日志类型： 操作
     */
    int LOG_TYPE_2 = 2;

    /**
     * 操作日志类型： 查询
     */
    int OPERATE_TYPE_1 = 1;

    /**
     * 操作日志类型： 添加
     */
    int OPERATE_TYPE_2 = 2;

    /**
     * 操作日志类型： 更新
     */
    int OPERATE_TYPE_3 = 3;

    /**
     * 操作日志类型： 删除
     */
    int OPERATE_TYPE_4 = 4;

    /**
     * 操作日志类型： 倒入
     */
    int OPERATE_TYPE_5 = 5;

    /**
     * 操作日志类型： 导出
     */
    int OPERATE_TYPE_6 = 6;

    /**
     * 超级管理员
     */
    String USER_TYPE_ROOT = "0";

    /**
     * 管理员
     */
    String USER_TYPE_ADMIN = "1";

    /**
     * 领导
     */
    String USER_TYPE_LEADER = "2";

    /**
     * 教师
     */
    String USER_TYPE_TEACHER = "3";

    /**
     * 学生
     */
    String USER_TYPE_STUDENT = "4";
}

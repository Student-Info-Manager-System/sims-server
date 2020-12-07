package com.cloud.sims.common.config.annotation;


import java.lang.annotation.*;

/**
 * @author Long
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface ApiLog {
    /**
     * 日志内容
     *
     * @return
     */
    String value() default "";

    /**
     * 操作模块
     * @return
     */
    String model() default "";

    /**
     * 日志类型
     *
     * @return 0:操作日志;1:登录日志;2:定时任务;
     */
    int logType() default 0;

    /**
     * 操作日志类型
     *
     * @return （1查询，2添加，3修改，4删除）
     */
    int operateType() default 0;
}

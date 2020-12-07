package com.cloud.sims.common.config.annotation;

import com.cloud.sims.common.constant.Constant;

import java.lang.annotation.*;

/**
 * @author longxin
 *  接口权限监控切面
 */

//注解放置的目标位置,METHOD是可注解在方法级别上, TYPE在类上
@Target({ElementType.METHOD, ElementType.TYPE})
//@Target(ElementType.METHOD)
//注解在哪个阶段执行
@Retention(RetentionPolicy.RUNTIME)
//说明该注解将被包含在javadoc中
@Documented
@Inherited
public @interface Authority {

    /**
     * 开启权限限制，默认true为开启状态
     * @return
     */
    boolean auth() default true;

    /**
     * 警告说明
     * @return
     */
    String desc() default "无权查看！";

    /**
     * 限制权限
     * @return
     */
    String[] root() default {Constant.USER_TYPE_STUDENT, Constant.USER_TYPE_TEACHER, Constant.USER_TYPE_LEADER};
}

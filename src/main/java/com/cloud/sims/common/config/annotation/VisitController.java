package com.cloud.sims.common.config.annotation;

import java.lang.annotation.*;

/**
 * @author longxin
 */

//注解放置的目标位置,METHOD是可注解在方法级别上, TYPE在类上
@Target({ElementType.METHOD, ElementType.TYPE})
//@Target(ElementType.METHOD)
//注解在哪个阶段执行
@Retention(RetentionPolicy.RUNTIME)
//说明该注解将被包含在javadoc中
@Documented
public @interface VisitController {
    /**
     * 开启访问限制，默认true为开启状态
     * @return
     */
    boolean visit() default true;

    /**
     * wartime 秒内操作 限制次数为 warcount 次
     */
    long wartime() default 30;

    /**
     * warcount 短时间内操作次数上限，
     * @return
     */
    int warcount() default 6;

    /**
     * 缓存过期时间，改时间决定改访问限制的效果，请谨慎赋值
     * @return
     */
    long timeout() default 10;

    /**
     * 警告说明
     * @return
     */
    String desc() default "您的操作过于频繁，请稍后再试";
}

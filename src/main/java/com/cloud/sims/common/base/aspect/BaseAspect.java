package com.cloud.sims.common.base.aspect;


import com.cloud.sims.common.config.catche.redis.CatcheEvent;
import com.cloud.sims.common.config.result.Result;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * 切面外壳
 */
public class BaseAspect {
    @Resource
    protected CatcheEvent catche;

    protected ThreadLocal<Long> currentTime = new ThreadLocal<>();

    @Value("${cloud.version}")
    protected String version;

    @Value("${cloud.api-version}")
    protected String apiVersion;




    protected void doBefore(JoinPoint jp) {

    }

    protected void doAfter(JoinPoint jp) {

    }

    protected void doAfterRuturn(JoinPoint jp, Result<?> result) {

    }
}

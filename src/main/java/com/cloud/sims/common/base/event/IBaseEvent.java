package com.cloud.sims.common.base.event;

import com.cloud.sims.common.base.aspect.BaseAspect;
import com.cloud.sims.common.base.service.IBaseService;
import com.cloud.sims.common.config.exception.CloudException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * @author Long
 */
@Slf4j
public class IBaseEvent<DOMAIN, ID,  S extends IBaseService<DOMAIN, ID>> extends BaseAspect {
    /**
     * 动态 IOC代理
     *
     * 多个需要使用Autowired
     */
    @Autowired
    protected S service;

    protected String getVisit(JoinPoint jp){
        Class cla = jp.getSignature().getDeclaringType();
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        if (!cla.isAnnotationPresent(Api.class) || !method.isAnnotationPresent(ApiOperation.class)) {
           throw new CloudException("无权查看");
        }
        Api api = (Api) cla.getAnnotation(Api.class);
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        String vis = api.tags() + "-" + apiOperation.value();
        log.info("访问接口:" + vis);
        return vis;
    }
}

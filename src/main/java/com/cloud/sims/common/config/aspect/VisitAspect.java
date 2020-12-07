package com.cloud.sims.common.config.aspect;

import com.cloud.sims.common.base.aspect.BaseAspect;
import com.cloud.sims.common.config.annotation.VisitController;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.config.result.Result;
import com.cloud.sims.common.config.visit.Visit;
import com.cloud.sims.common.utils.HttpRequestUtil;
import com.cloud.sims.common.utils.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



/**
 * @author Long
 */
@Aspect
@Slf4j
@Component
public class VisitAspect extends BaseAspect {

    boolean aspect = false;

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.cloud.sims.common.config.annotation.VisitController)")
    public void aspect() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    @Override
    @Before("aspect()")
    public void doBefore(JoinPoint jp) {
//        log.info("========================访问控制监控中========================");
        VisitController visitController = ServiceUtil.getAnnotation(jp, VisitController.class);
        if (!visitController.visit()){
            return;
        }

        Visit visit = new Visit(HttpRequestUtil.getRequest());
        Visit visitCatche = (Visit) catche.get(visit.key());
        if (visitCatche == null){
            catche.set(visit.key(), visit, visitController.timeout());
        }
        /**
         * 访问 控制
         */
        aspect = visit(visit, visitCatche, visitController);
    }

    private boolean visit(Visit var1, Visit var2, VisitController visitController){
        /*if (var1.timelag(var2, var3.wartime())){
            catche.set(var2.key(), var2, var3.timeout());
            if (var2.getCount() > var3.warcount()) {
                throw new CloudException(var3.desc());
            }
        }*/
        if (ServiceUtil.hasNull(var1, var2)) {
            return false;
        }
        if (var1.getTimestamp() - var2.getTimestamp() > visitController.wartime() * 1000) {
            return false;
        }
        if (var2.getCount() > visitController.warcount()) {
            throw new CloudException(visitController.desc());
        }

        catche.set(var2.key(), var2.add(var1), visitController.timeout());
        return true;
    }

    @Override
    @After("aspect()")
    public void doAfter(JoinPoint jp) {
        if (aspect) {
            log.warn("========================访问控制触发========================");
        }
    }


    @Override
    @AfterReturning(returning = "result",pointcut = "aspect()")
    public void doAfterRuturn(JoinPoint jp, Result<?> result) {

    }
}

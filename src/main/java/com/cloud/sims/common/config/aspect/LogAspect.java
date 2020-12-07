package com.cloud.sims.common.config.aspect;

import com.cloud.sims.common.base.aspect.BaseAspect;
import com.cloud.sims.common.config.annotation.ApiLog;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.config.result.Result;
import com.cloud.sims.common.utils.*;
import com.cloud.sims.system.syslog.pojo.entity.SysLog;
import com.cloud.sims.system.syslog.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author Long
 */

@Aspect
@Slf4j
@Component
public class LogAspect extends BaseAspect {
    @Resource
    private SysLogService service;

    boolean aspect = false;

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.cloud.sims.common.config.annotation.ApiLog)")
    public void aspect() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    @Override
    @Before("aspect()")
    public void doBefore(JoinPoint jp) {
//        HttpServletRequest request = HttpRequestUtil.getRequest();
//        String url = request.getRequestURL().toString();
    }

    @Override
    @After("aspect()")
    public void doAfter(JoinPoint jp) {
        if (aspect) {
            log.warn("========================一条日志写入成功========================");
        } else {
            log.error("========================一条日志写入异常========================");
        }
    }


    @Override
    @AfterReturning(returning = "result", pointcut = "aspect()")
    public void doAfterRuturn(JoinPoint jp, Result<?> result) {
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        ApiLog apiLog = method.getAnnotation(ApiLog.class);
        if (ServiceUtil.isNull(apiLog)) {
            return;
        }
        HttpServletRequest req = HttpRequestUtil.getRequest();
        SysLog sysLog = new SysLog();

        try {
            sysLog.setModel(apiLog.model())
                    .setLogType(apiLog.logType())
                    .setOperateType(apiLog.operateType())
                    .setValue(apiLog.value())
                    .setMessage(result.getMessage())
                    .setSuccess(result.isSuccess())
                    .setCode(result.getCode())
                    .setMethod(method.toString())
                    .setIp(IPUtil.getRealIp(req))
                    .setUrl(req.getRequestURL().toString())
                    .setDevice(AgentUtil.creat(req).getOs().getName())
                    .setUserId(ShiroUtil.getUserId());

        }catch (Exception e){
            CloudException.log(e, "日志信息组装异常");
        }
        aspect = service.save(sysLog);
    }
}




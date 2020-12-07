package com.cloud.sims.common.config.aspect;

import com.cloud.sims.common.base.aspect.BaseAspect;
import com.cloud.sims.common.config.annotation.Authority;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.config.shiro.AccountProfile;
import com.cloud.sims.common.constant.Constant;
import com.cloud.sims.common.utils.ServiceUtil;
import com.cloud.sims.common.utils.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.cloud.sims.common.config.exception.Assert;

/**
 * @author Long
 */
@Aspect
@Slf4j
@Component
public class AuthorityAspect extends BaseAspect {
    boolean aspect = false;

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.cloud.sims.common.config.annotation.Authority)")
    public void aspect() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    @Override
    @Before("aspect()")
    public void doBefore(JoinPoint jp) {
//        if (true) return;
        String msg = "权限不足";
        Authority authority = null;
        Authority authority2 = null;
        try {
            authority = jp.getThis().getClass().getAnnotation(Authority.class);
            if (ServiceUtil.isNull(authority)) {
                return;
            }
            authority2 = ServiceUtil.getAnnotation(jp, Authority.class);
        } catch (Exception e) {
            throw new CloudException(msg);
        }

        if (!authority.auth()) {
            return;
        }
        aspect = true;

        String root[];
        if (ServiceUtil.equal(authority.root(), authority2.root())) {
            root = authority.root();
        }else {
            root = authority2.root();
        }

        AccountProfile user = null;
        try {
            user = ShiroUtil.getProfile();
            if (!ServiceUtil.hasEqual(user.getType(), authority.root())) {
                throw new CloudException(msg);
            }
        } catch (Exception e) {
            throw new CloudException(msg);
        }
    }

    @Override
    @After("aspect()")
    public void doAfter(JoinPoint jp) {
        if (aspect) {
            log.warn("========================权限控制触发========================");
        }
    }
}

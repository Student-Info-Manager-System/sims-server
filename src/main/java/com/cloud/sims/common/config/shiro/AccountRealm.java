package com.cloud.sims.common.config.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.utils.JwtUtils;
import com.cloud.sims.common.utils.ServiceUtil;
import com.cloud.sims.system.sysuser.pojo.entity.SysUser;
import com.cloud.sims.system.sysuser.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    SysUserService service;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        try {
            JwtToken jwtToken = (JwtToken) token;

            String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

            SysUser user = service.getById(userId);

            if (user == null) {
                throw new CloudException("账户不存在");
            }

            if (ServiceUtil.isNull(user.getStatus()) || ServiceUtil.equal(user.getStatus(), "-1")) {
                throw new CloudException("账户已被锁定");
            }

            AccountProfile profile = new AccountProfile();
            BeanUtil.copyProperties(user, profile);

            return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
        }catch (Exception e){
            throw new CloudException("账户异常");
        }
    }
}

package com.cloud.sims.common.utils;


import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.config.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @author Long
 */

public class ShiroUtil {

    public static AccountProfile getProfile() {
        try {
            return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
        }catch (Exception e){
            CloudException.log("ShiroUtil.getProfile ERROR");
            return null;
        }
    }

    public static String getUserId() {
        try {
            return ((AccountProfile) SecurityUtils.getSubject().getPrincipal()).getId();
        }catch (Exception e){
            CloudException.log("ShiroUtil.getUserId ERROR");
            return "";
        }
    }
}

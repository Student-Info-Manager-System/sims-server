package com.cloud.sims.common.utils;


import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;

import javax.servlet.http.HttpServletRequest;

public class AgentUtil {
    public static String uaStr(HttpServletRequest req){
        return req.getHeader("User-Agent");
    }

    public static UserAgent creat(String uaStr){
        return UserAgentUtil.parse(uaStr);
    }

    public static UserAgent creat(HttpServletRequest req){
        return creat(uaStr(req));
    }

}

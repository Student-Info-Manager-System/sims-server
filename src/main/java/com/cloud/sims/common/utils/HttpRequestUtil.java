package com.cloud.sims.common.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Long
 */
public class HttpRequestUtil {
    public static HttpRequest get(String url){
        return HttpUtil.createGet(url);
    }

    public static HttpResponse execute(String url){
        return HttpRequest.post(url).execute();
    }

    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}

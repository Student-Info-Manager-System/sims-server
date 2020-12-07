package com.cloud.sims.common.utils;

import cn.hutool.http.HttpRequest;

public class HttpClientUtil {

    public static String doGet(String url){
        return HttpRequest.get(url).execute().body();
    }

    public static String doPost(String url){
        return HttpRequest.post(url).execute().body();
    }
}

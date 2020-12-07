package com.cloud.sims.common.config.visit;

import com.cloud.sims.common.utils.AgentUtil;
import com.cloud.sims.common.utils.IPUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class Visit implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ip
     */
    private String ip;
    /**
     * 路由
     */
    private String url;

    /**
     * 操作次数
     */
    private int count;
    /**
     * 访问信息
     */
    private String userAgent;
    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 上次限制时间
     */
    private long lasttime = 0;

    public Visit(){

    }

    public Visit(HttpServletRequest req) {
        this.ip = IPUtil.getRealIp(req);
        this.url = req.getRequestURL().toString();
        this.userAgent = AgentUtil.uaStr(req);
        this.count = 1;
    }


    public String key(){
        return ip + url + userAgent;
    }

    public Visit add(Visit var){
        this.count += 1;
        this.lasttime = var.timestamp;
        return this;
    }
}

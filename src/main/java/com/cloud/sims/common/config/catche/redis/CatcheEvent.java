package com.cloud.sims.common.config.catche.redis;


import com.cloud.sims.common.config.catche.Catche;
import com.cloud.sims.common.config.exception.CloudException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class CatcheEvent implements Catche {
    /**
     * 默认存储时长
     */
    private long timeout = 5;
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    @Resource
    private RedisTemplate<String, Object> redis;

    @Override
    public Object get(String key){
        return redis.opsForValue().get(key);
    }

    @Override
    public Boolean delete(String key) {
        return redis.delete(key);
    }

    @Override
    public void set(String key, Object o){
        set(key, o, timeout);
    }

    @Override
    public void set(String key, Object o, long timeout) {
        set(key, o, timeout <= 0 ? this.timeout : timeout, timeUnit);
    }

    @Override
    public void set(String key, Object o, long timeout, TimeUnit timeUnit) {
        if(StringUtils.isBlank(key) || !ObjectUtils.anyNotNull(o)){
            throw new CloudException("数据不能为空");
        }
        delete(key);
        redis.opsForValue().set(key, o, timeout, timeUnit);
        log.info("RedisTemplate插入数据>>" + o);
    }
}

package com.cloud.sims.common.config.catche;

import java.util.concurrent.TimeUnit;

public interface Catche {
    Object get(String key);

    void set(String key, Object o);

    void set(String key, Object o, long timeout);

    void set(String key, Object o, long timeout, TimeUnit timeUnit);

    Boolean delete(String key);
}

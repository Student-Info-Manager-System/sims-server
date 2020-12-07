package com.cloud.sims.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapConvert extends ServiceUtil {

    public static <T> T copy(Class<T> cla, Object... objs) {

        T obj = null;
        try {
            //反射实例化实体类
            obj = cla.newInstance();
        } catch (ReflectiveOperationException e) {
            // 打印异常日志
            log.error("" + e);
        }
        if (isNull(objs) || isNull(obj)) {
            return null;
        }

        Map<String, Object> result = toMap(obj);

        for (Object o : objs) {
            Field[] cops = o.getClass().getDeclaredFields();
            for (Field field : cops) {
                field.setAccessible(true);
                try {
                    //获得map的key值
                    String key = field.getName();

                    if (field.get(o) != null) {
                        result.put(key, field.get(o));
                    }

                } catch (IllegalAccessException e) {
                    // 打日志
                    log.error("" + e);
                }
            }
        }

        return toObject(result, cla);
    }

    /**
     * map转为实体类
     *
     * @param map
     * @param cla 需要被转的实体类的类型
     * @return 实体类
     */
    public static <T> T toObject(Map map, Class<T> cla) {
        T obj = null;
        try {
            //反射实例化实体类
            obj = cla.newInstance();
        } catch (ReflectiveOperationException e) {
            // 打印异常日志
            log.error("反射实例化实体类异常" + e);
        }
        //如果实例化失败，直接返回null
        //如果map是空的，直接返回空的实体类
        if (isAllNull(obj, map)) {
            return null;
        }

        //获得实体类的所有字段
        //遍历这些字段
        for (Field field : cla.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                //获得value值
                String key = field.getName();

                //获得map的value值
                Object v = map.get(key);
                //如果map中没有这个值，跳过
                if (isNull(v)) {
                    continue;
                }
                //获得实体类字段类型
                Class<?> type = field.getType();

                //判断map获得的value的类型是否和字段的类型一致或父子类关系
                if (v.getClass().isAssignableFrom(type)) {
                    field.set(obj, v);
                }
                //加上一些需要强转的基本数据类型，后面还有float、double等等需要加上
                else if (type == Integer.class || type == int.class) {
                    int value = 0;
                    try {
                        value = Integer.parseInt(String.valueOf(map.get(key)));
                    } catch (Exception e) {
                        log.error("基本数据类型强转失败" + e);
                    }
                    field.set(obj, value);
                }

            } catch (IllegalAccessException e) {
                log.error("转化失败" + e);
            }
        }
        return obj;
    }

    /**
     * 实体类转为map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> toMap(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        //直接使用HashMap
        return new HashMap<String, Object>() {{
            //遍历字段
            for (Field field : obj.getClass().getDeclaredFields()) {
                //判断有没有加上注解
                try {
                    field.setAccessible(true);
                    //赛值
                    this.put(field.getName(), field.get(obj));
                } catch (IllegalAccessException e) {
                    // 打日志
                    log.error("toMap转换失败" + e);
                }
            }
        }};
    }
}

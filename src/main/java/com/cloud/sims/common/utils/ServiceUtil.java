package com.cloud.sims.common.utils;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.alibaba.fastjson.JSON;
import com.cloud.sims.common.config.exception.CloudException;
import org.apache.commons.collections4.CollectionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Long
 */
public class ServiceUtil  {
    public static void main(String[] args) {
        System.out.println(DateUtil.parseDate("1979-02-03"));
        System.out.println(DateUtil.parseDate("2000/03/01"));
    }

    public static boolean isNull(Object var){
        return ObjectUtil.isEmpty(var);
    }

    public static boolean isNull(Collection<?> coll){
        return CollectionUtils.isEmpty(coll);
    }

    public static boolean hasNull(Object...vars){
        for (Object var : vars) {
            if (isNull(var)) {
                return true;
            }
        } return false;
    }

    public static boolean isAllNull(Object...var){
        return isNull(new ArrayList<Object>(){{this.add(Arrays.asList(var));}});
    }

    public static boolean isNotNull(Object var){
        return !isNull(var);
    }



    public static boolean isNotNull(Collection<?> coll){
        return !isNull(coll);
    }

    public static boolean isAllBlank(CharSequence... css){
        return org.apache.commons.lang3.StringUtils.isAllBlank(css);
    }

    public static String trimAll(String var){  return isNull(var) ? "" : var.replaceAll(" ", ""); }

    public static  <T> Set<T> set(List<T> list){
        return new HashSet<>(list);
    }

    public static <T> List<T> list(Page<T> page){
        return page.getContent();
    }

    public static <T> List<T> list(Set<T> sets) {
        return new ArrayList<>(sets);
    }

    public static <T> Set<T> set(Page<T> page) {
        return set(list(page));
    }

    public static  <T> Page<T> page(List<T> list) {
        return new PageImpl(list);
    }

    public static boolean isZero(Integer var){
        return !isNull(var) && var == 0;
    }

    public static String getStrByArr(String...var){
        StringBuilder sb = new StringBuilder();
        for (String ele : var) {
            sb.append(ele);
        }
        return sb.toString();
    }


    public static boolean equal(int...var){
        int s = var[0];
        for (int v : var){
            if (s != v) return false;
            s = v;
        }
        return true;
    }
    public static boolean equal(long...var){
        long s = var[0];
        for (long v : var){
            if (isNull(v) || s != v) return false;
            s = v;
        }
        return true;
    }


    public static boolean equal(String...var){
        String s = var[0];
        for (String v : var){
            if (isNull(v) || !v.equals(s)) return false;
            s = v;
        }
        return true;
    }
    public static boolean hasEqual(String var, String...vars){
        if (isNull(var)) return false;
        for (String v : vars){
            if (var.equals(v)) return true;
        }
        return false;
    }

    public static boolean equal(String [] var1, String [] var2){
        if (var1.length != var2.length) {
            return false;
        }
        for (String v : var1) {
            if (!hasEqual(v, var2)) return false;
        }
        return true;
    }

    public static boolean isEmail(String var) {
        if (isNull(var)) {
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(var);
        if (m.matches()) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmail(String var) {
        return !isEmail(var);
    }

    public static <T> String toStr(T obj){
        return isNull(obj) ? "" : JSON.toJSONString(obj);
    }

    public static  <T extends Annotation> T getFieldAnnotation(Field field, Class<T> clazz){
        return field.getAnnotation(clazz);
    }

    public static  <T extends Annotation> T getMethodAnnotation(JoinPoint jp, Class<T> clazz){
        return ((MethodSignature) jp.getSignature()).getMethod().getAnnotation(clazz);
    }

    public static  <T extends Annotation> T getClassAnnotation(JoinPoint jp, Class<T> clazz){
        return ((MethodSignature) jp.getSignature()).getClass().getAnnotation(clazz);
    }



    public static <T extends Annotation> T getAnnotation(JoinPoint jp, Class<T> clazz){
        T t = getClassAnnotation(jp, clazz);
        return isNull(t) ? getMethodAnnotation(jp, clazz) : t;
    }

    public static String getFieldType(Field field){
        String classType = field.getType().toString();
        int lastIndex = classType.lastIndexOf(".");
        return classType.substring(lastIndex + 1);
    }

    public static List<Field> getFieldList(Class<?> clazz){
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        if (fields.size() < 1){
            throw new CloudException("反射未读取到实体字段");
        }
        Class superClazz = clazz.getSuperclass();
        if (superClazz == null){
            return fields;
        }
        List<Field> superFields = new ArrayList<>(Arrays.asList(superClazz.getDeclaredFields()));
        if (superFields.size() >= 1) {
            fields.addAll(superFields);
        }
        return fields;
    }

    public static byte[] KEY = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

    public static String AesE(String decrypt){
        return AesE(decrypt, KEY);
    }

    public static String AesE(String decrypt, byte[] key){
        //构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        //加密为16进制表示
        return aes.encryptHex(decrypt) ;
    }

    public static String AesD(String encrypt){
        return AesD(encrypt, KEY);
    }

    public static String AesD(String encrypt, byte[] key){
        //构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        return aes.decryptStr(encrypt, CharsetUtil.CHARSET_UTF_8);
    }
}

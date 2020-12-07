package com.cloud.sims.common.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author Long
 */
public class StrUtil {


    /**
     *  正则：手机号（简单）, 1字头＋10位数字即可.
     * @param in
     * @return
     */
    public static boolean validateMobilePhone(String in) {
        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
        return pattern.matcher(in).matches();
    }

    public static boolean validateMobileEmial(String in) {
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return pattern.matcher(in).matches();
    }

    /**
     * 字符池
     */
    public static char[] serialNo = {'1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N','P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z' };
    /**
     * 判断字符串数组arr内是否包含字符串str
     * @param str
     * @param arr
     * @return
     */
    public static boolean strIsArray(String str, String [] arr){
        return Arrays.asList(arr).contains(str);
    }
    /**
     * 获取指定位数的随机字符串 - 从自定字符池中获取
     * @param size
     * @return
     */
    public static String getSerialNo(int size) {
        Random random = new Random();
        char[] cs = new char[size];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = serialNo[random.nextInt(serialNo.length)];
        }
        return new String(cs);
    }
}

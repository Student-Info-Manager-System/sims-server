package com.cloud.sims.common.utils;


import org.apache.commons.mail.HtmlEmail;

import java.util.Random;


/**
 * @author longxin
 * @title: CodeUtil
 * @projectName com.example.demo.util
 * @description: /
 * @date 2019/10/29 12:43
 */
public class CodeUtil {

    public static void main(String[] args) {
        sendEmail("1753047507@qq.com", wordCode());
//        sendPhone("17683905916", numCode());
    }


    //JXDALNDCTENIPZTJ
    //邮箱验证码
    public static boolean sendEmail(String emailaddress, String code) {
        final String emailName = "知猫";
        final String USER_MAIL = "longxin999999999@163.com";
        final String USER_NAME = "江浒一只猫";
        //发送方邮箱与授权码
        final String USE_EMAIL = "longxin999999999@163.com";
        final String USE_KEY = "JXDALNDCTENIPZTJ";

        try {
            HtmlEmail email = new HtmlEmail();//不用更改
            email.setHostName("smtp.163.com");  //需要修改，126邮箱为smtp.126.com,163邮箱为smtp.163.com，QQ为smtp.qq.com
            email.setCharset("UTF-8");
            email.addTo(emailaddress);// 收件地址
            email.setFrom(USER_MAIL, USER_NAME);//此处填邮箱地址和用户名,用户名可以任意填写

            email.setAuthentication(USE_EMAIL, USE_KEY);
            //此处填写邮箱地址和客户端授权码
            email.setSubject(emailName);//此处填写邮件名，邮件名可任意填写
            //此处填写邮件内容
            email.setMsg("尊敬的用户您好,欢迎使用"+ emailName  + ", " + "您本次操作的验证码是:【" + code + "】，如非本人操作，请忽略。" +
                                "<br/>提示：验证码5分钟内有效，请勿将验证码泄露给他人。");

            email.send();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean send(String emailaddress, String msg) {
        final String emailName = "知猫";
        final String USER_MAIL = "longxin999999999@163.com";
        final String USER_NAME = "江浒一只猫";
        //发送方邮箱与授权码
        final String USE_EMAIL = "longxin999999999@163.com";
        final String USE_KEY = "JXDALNDCTENIPZTJ";

        try {
            HtmlEmail email = new HtmlEmail();//不用更改
            email.setHostName("smtp.163.com");  //需要修改，126邮箱为smtp.126.com,163邮箱为smtp.163.com，QQ为smtp.qq.com
            email.setCharset("UTF-8");
            email.addTo(emailaddress);// 收件地址
            email.setFrom(USER_MAIL, USER_NAME);//此处填邮箱地址和用户名,用户名可以任意填写

            email.setAuthentication(USE_EMAIL, USE_KEY);
            //此处填写邮箱地址和客户端授权码
            email.setSubject(emailName);//此处填写邮件名，邮件名可任意填写
            //此处填写邮件内容
            email.setMsg(msg);

            email.send();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




    /**
     * 6位数字验证码
     * @return
     */
    public static String numCode(){
        return   "" + (int)((Math.random()*9+1)*100000);
    }

    /**
     * 英文加数字-4位字符验证码
     * @return
     */
    public static String wordCode(){
        Random r = new Random();
        String code = "";
        for(int i=0; i < 4; i ++) code = code + hexDigits[r.nextInt(hexDigits.length)];
        return code;
    }

    /**
     * 判断验证码是否相等
     * @param code1
     * @param code2
     * @return
     */
    public static boolean codeVerifi(String code1, String code2){
        if(code1.length() != code2.length()) return false;
        for(int i=0; i < code1.length(); i++)
            if(code1.charAt(i) != code2.charAt(i))
                return false;
        return true;
    }


    /**
     * 字符池
     */
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
    };

}

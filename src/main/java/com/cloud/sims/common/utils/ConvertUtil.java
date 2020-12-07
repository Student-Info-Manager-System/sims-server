package com.cloud.sims.common.utils;

/*做一个功能验证，要用到inputStream与outputStream的转换，本以为很简单的东东
搞了蛮久，从"程序员 闫帆"处取得一段代码*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ConvertUtil {
    //inputStream转outputStream
    public static ByteArrayOutputStream parse(InputStream in) throws Exception
    {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream;
    }
    //outputStream转inputStream
    public static ByteArrayInputStream parse(OutputStream out) {
        try {
            ByteArrayOutputStream   baos=new   ByteArrayOutputStream();
            baos=(ByteArrayOutputStream) out;
            ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
            return swapStream;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("转换失败");
            return null;
        }

    }
    //inputStream转String
    public static String parse_String(InputStream in) throws Exception
    {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream.toString();
    }
    //OutputStream 转String
    public static String parse_String(OutputStream out)throws Exception
    {
        ByteArrayOutputStream   baos=new   ByteArrayOutputStream();
        baos=(ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream.toString();
    }
    //String转inputStream
    public static ByteArrayInputStream parse_inputStream(String in)throws Exception
    {
        ByteArrayInputStream input=new ByteArrayInputStream(in.getBytes());
        return input;
    }
    //String 转outputStream
    public static ByteArrayOutputStream parse_outputStream(String in)throws Exception
    {
        return parse(parse_inputStream(in));
    }
}

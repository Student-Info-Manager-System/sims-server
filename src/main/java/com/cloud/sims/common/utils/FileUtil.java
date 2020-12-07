package com.cloud.sims.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

/**
 * @author longxin
 * @title: FileUtil
 * @projectName com.JavaUtils
 * @description: /
 * @date 2020/3/6 0006 10:22
 */
public class FileUtil {
    /**
     * 文件后缀属性池
     */
    private static final String [] files = {"docx", "doc", "wps", "txt",
            "jpg", "gif", "png", "jpeg", "svg", "psd",
            "exe", "apk",
            "zip", "rar", "7z", "jar",
            "css", "js", "java", "c", "cpp", "php", "py", "html",
            "mp3", "mp4"
    };
    /**
     * 文件后缀属性类别池
     */
    //文本类
    private static final String [] fileWord = {"docx", "doc", "wps", "txt"};
    //图片类
    private static final String [] fileImage = {"jpg", "gif", "png", "jpeg", "svg", "psd"};
    //软件类
    private static final String [] fileApp = {"exe", "apk"};
    //压缩包类
    private static final String [] filePress = {"zip", "rar", "7z", "jar"};
    //代码文件类
    private static final String [] fileCode = {"css", "js", "java", "c", "cpp", "php", "py", "html"};
    //音影类
    private static final String [] fileLip = {"mp3", "mp4"};
    //属性池类属性可根据需求自行增减，这里可能罗列补全

    /**
     * MultipartFile转File
     * @param file
     * @return
     */
    public static File getFile(MultipartFile file) throws Exception{
        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }
    /**
     * 获取流文件
     * @param ins
     * @param file
     */
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取当前项目文件的位置 - 适用大部分开发场景
     * @return
     */
    public static String getUplodFilePath() {
        String path = FileUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.substring(1, path.length());
        try {
            path = java.net.URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int lastIndex = path.lastIndexOf("/") + 1;
        path = path.substring(0, lastIndex);
        File file = new File("");
        return file.getAbsolutePath() + "/";
    }
    /**
     * 获取当前项目文件的位置 - 本地快速开发方便
     * @return
     */
    public static String getPorjectPath(){
        String nowpath = "";
        nowpath=System.getProperty("user.dir")+"/";
        return nowpath;
    }
    /**
     * 根据全文件名获取文件名的后缀
     * @param fileName
     * @return
     */
    public static String getFileExName(String fileName){
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    /**
     * 获取不带后缀的文件名
     * @param filename
     * @return
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }
    /**
     * 转换文件大小
     * @param file
     * @return
     */
    public static String parseSize(File file) {
        long size = file.length();
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            size = size * 100;
            return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "MB";
        } else {
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "GB";
        }
    }
    /**
     * 获取文件长和宽 (当文件为图片时)
     * @param file  file
     * @return String
     */
    public static String getImageWh(File file) {
        try {
            if(isAllowFile(file, fileImage)){
                BufferedImage image = ImageIO.read(new FileInputStream(file));
                return image.getWidth() + "x" + image.getHeight();
            }
            return "非图片文件";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    /**
     * 判断文件类型是否符合指定文件类型池的类型
     * @param file
     * @param allowFileType
     * @return
     */
    public static boolean isAllowFile(File file,  String[] allowFileType){
        String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        return StrUtil.strIsArray(suffix, allowFileType);
    }
    /**
     * 根据文件名生成更规范的文件名
     * @param name 文件名
     * @param prefix 文件组名（将会拼接到文件名前，便于文件分组）
     * @return
     */
    public static String getFileKey(String name, String prefix) {
        if(prefix == null || prefix.equals("")){
            prefix = "file";  //自定义前缀- 一般用于文件分组
        }
        Date date = new Date();
        String d = date.getTime() + "";

        if (!new File(getUplodFilePath() + prefix).exists()) {
            new File(getUplodFilePath()  + prefix).mkdirs();
        }

        name = StringUtils.trimToNull(name);
        if (name == null) { //文件名为空时，根据当前时间自动生成
            return prefix + "-" + d.substring(9) + "-" +  StrUtil.getSerialNo(2)  + "." + null;
        } else {
            name = formatFileName(name);
            String ext = getFileExName(name);
            return prefix + "-"+ ext + getFileNameNoEx(name) + "-" +  StrUtil.getSerialNo(2) + "." + (ext == null ? null : (ext));
        }
    }
    /**
     * 格式化文件名
     * @param fileName
     * @return
     */
    public static String formatFileName(String fileName){
        //如果文件名包含路径，去掉路径
        fileName = fileName.replace('\\', '/');
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        return fileName;
    }
}


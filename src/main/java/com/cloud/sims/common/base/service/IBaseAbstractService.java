package com.cloud.sims.common.base.service;

import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

public interface IBaseAbstractService {

    /**
     * 登录
     * @param res
     * @param dto
     * @return
     */
    void login(HttpServletResponse res, UserInfoDTO dto);

    /**
     * 创建响应文件流
     *
     * @param res
     * @return
     */
    OutputStream outputStream(HttpServletResponse res, String suffixName);

    /**
     * 导出数据模板
     *
     * @return
     */
    HSSFWorkbook exportTemplat();

    /**
     * 写出表格
     *
     * @param workbook
     * @param output
     */
    void writeWorkbook(HSSFWorkbook workbook, OutputStream output);

    /**
     * 导出数据
     *
     * @return
     */
    HSSFWorkbook exportData();

    /**
     * 批量导入
     *
     * @param file
     * @return
     */
    String  importExcel(MultipartFile file);

    /**
     * 加密验证链接密匙
     * @param encrypt
     */
    void checkEncrypt(String encrypt);

    /**
     * 全部删除
     *
     * @return
     */
    int removeAll();
}

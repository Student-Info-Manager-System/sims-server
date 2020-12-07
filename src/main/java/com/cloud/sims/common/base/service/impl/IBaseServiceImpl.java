package com.cloud.sims.common.base.service.impl;


import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.sims.business.manager.SimsManager;
import com.cloud.sims.common.base.service.IBaseService;
import com.cloud.sims.common.config.catche.Catche;
import com.cloud.sims.common.config.exception.Assert;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.constant.Constant;
import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.JwtUtils;
import com.cloud.sims.common.utils.ServiceUtil;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
//import com.sun.org.apache.regexp.internal.RE;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Long
 */
@Slf4j
public class IBaseServiceImpl<DOMAIN, ID extends Serializable, M extends BaseMapper<DOMAIN>> extends ServiceImpl<M, DOMAIN> implements IBaseService<DOMAIN, ID> {

    /**
     * 业务总管理
     */
    @Autowired
    protected SimsManager manager;

    @Value("${cloud.user.url}:${server.port}")
    protected String URL;


    static byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

    /**
     * 动态 IOC代理
     * <p>
     * 多个需要使用 Autowired
     */
    @Autowired
    protected M mapper;

    @Autowired
    protected JwtUtils jwtUtils;

    @Autowired
    protected Catche catche;

    /**
     * 当前泛型真实类型的Class
     */
    protected Class<DOMAIN> modelClass;

    private Class<?> baseEntityClass;

    public IBaseServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<DOMAIN>) pt.getActualTypeArguments()[0];
        baseEntityClass = modelClass.getSuperclass();
    }


    @Override
    public void login(HttpServletResponse res, UserInfoDTO dto) {
        Assert.notNull(dto.getVo());
        try {
            String jwt = jwtUtils.generateToken(dto.getVo().getId());
            res.setHeader("Authorization", jwt);
            res.setHeader("Access-Control-Expose-Headers", "Authorization");

            log.warn("==== TOKEN== " + jwt);
        }catch (Exception e){
            throw new CloudException(ErrorMsg.SYSTEM_ERROR);
        }
    }


    /**
     * 根据ID删除数据（逻辑删）
     *
     * @param ids
     * @return
     */
    @Override
    public Integer deleteById(ID[] ids) {
        Integer sum = 0;
        for (ID id : ids) {
            UpdateWrapper<DOMAIN> wrapper = new UpdateWrapper<>();
            wrapper.eq("id", id);
            wrapper.set("is_delete", true);
            sum += this.update(wrapper) ? 1 : 0;
        }
        return sum;
    }

    @Override
    public OutputStream outputStream(HttpServletResponse res, String suffixName) {
        try {
            OutputStream output = res.getOutputStream();
            res.reset();
            res.addHeader("Access-Control-Allow-Origin", "**");
            res.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            res.addHeader("Access-Control-Allow-Headers", "Content-Type");
            res.addHeader("Access-Control-Allow-Credentials", "true");
            res.setContentType("application/octet-stream; charset=UTF-8");
            res.setHeader("Content-disposition", "attachment; filename=" + modelClass.getSimpleName() + suffixName);

            return output;
        } catch (IOException e) {
            throw new CloudException(e, "IBaseServiceImpl内outputStream文件流异常");
        }
    }

    @SneakyThrows
    @Override
    public HSSFWorkbook exportTemplat() {
        List<Field> fields = ServiceUtil.getFieldList(modelClass);

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = workbook.createSheet(modelClass.getSimpleName());
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(3);

        //设置单元格内容
        cell.setCellValue(modelClass.getSimpleName() + "实体数据模板");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列

        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //在sheet里创建第三行
        HSSFRow row3 = sheet.createRow(2);
        //在sheet里创建第4行
        HSSFRow row4 = sheet.createRow(3);

        int count = 0;
        for (Field field : fields) {
            boolean isAnnotationPresent = field.isAnnotationPresent(Column.class);
            if (!isAnnotationPresent) {
                continue;
            }
            //数据类型
            row2.createCell(count).setCellValue(ServiceUtil.getFieldType(field));

            Column column = ServiceUtil.getFieldAnnotation(field, Column.class);
            String def = column.columnDefinition();
            //数据字段描述
            row3.createCell(count).setCellValue(def.substring(def.indexOf("\'") + 1, def.length() - 1));
            //数据字段名
            row4.createCell(count).setCellValue(column.name());
            count++;
        }
        return workbook;
    }

    @Override
    public void writeWorkbook(HSSFWorkbook workbook, OutputStream output) {
        try {
            workbook.write(output);
            output.close();
        }catch (Exception e){
            throw new CloudException(e, ErrorMsg.DATA_WRITE_OUT_ERROR);
        }
    }

    @Override
    public HSSFWorkbook exportData() {
        HSSFWorkbook workbook = this.exportTemplat();

        List<DOMAIN> entitys = super.list();

        List<Field> fields = ServiceUtil.getFieldList(modelClass);
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = workbook.getSheet(modelClass.getSimpleName());
        //从第四行开始
        int rowNum = 3;
        for (DOMAIN entity : entitys){
            try {
                HSSFRow row = sheet.createRow(++ rowNum);
                int count = 0;
                for (Field field : fields) {
                    boolean isAnnotationPresent = field.isAnnotationPresent(Column.class);
                    if (!isAnnotationPresent) {
                        continue;
                    }
                    field.setAccessible(true);

//                    field.getType()
                    row.createCell(count).setCellValue(String.valueOf(field.get(entity)));
                    count ++;
                }
            }catch (Exception e){
                CloudException.log(ErrorMsg.A_DATA_WRITE_BOOK_ERROR);
                rowNum --;
            }
        }
        return workbook;
    }


    /**
     * 通过excel导入数据
     *
     * @return
     */
    @Override
    public String importExcel(MultipartFile file) {
        /**
         * INSTER 使用哪种方法保存 1 为遍历保存
         */
        int count = 0, INSTER = 1;
        long time = 0;
        try {
            long start = System.currentTimeMillis();
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            List<DOMAIN> all = reader.read(3, 4, modelClass);
            //保存
            switch (INSTER) {
                case 0:
                default:
                    /**
                     * 批量保存
                     * TODO
                     * 请注意 ： 该批量保存接口测试失败  暂无法使用 原因未知
                     */
                    count = super.saveBatch(all, all.size()) ? all.size() : 0;
                    break;
                case 1:
                    /**
                     * 遍历保存 每次保存完后的到是否保存成功的状态 可以依此计数
                     */
                    for (DOMAIN domain : all) {
                        count += super.save(domain) ? 1 : 0;
                    }
            }

            time = System.currentTimeMillis() - start;
        } catch (Exception e) {
//            log.error("录入失败" + e);
            throw new CloudException("录入失败", e);
        } finally {
            try {
                file.getInputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (INSTER == 1) {
            return "录入统计: " + count + " 条数据，耗时 " + time + " ms";
        }
        return "录入统计: " + count + " 条数据，耗时 " + time + " ms" +
                "\n提示：Mp自身的批量保存并没有提供获取保存成功数量的方法，这里的成功数量实际为从数据源读取到的有效数据量";
    }


    /**
     * 加密验证链接密匙
     *
     * @param encrypt
     */
    @Override
    public void checkEncrypt(String encrypt) {
        Long timePractice;
        try {
            Long timestampOld = Long.valueOf(ServiceUtil.AesD(encrypt));

            timePractice = System.currentTimeMillis() - timestampOld;

        } catch (Exception e) {
            throw new CloudException(ErrorMsg.URL_INVALID);
        }
        //过期链接
        if (timePractice >= Constant.ENCRYPT_TIME_OUT_MAX_SECONDES * 1000L) {
            throw new CloudException(ErrorMsg.URL_INVALID);
        }
    }


    @Override
    public int removeAll() {
        int count = 0;
        try {
            Field field = modelClass.getDeclaredField("id");
            field.setAccessible(true);
            for (DOMAIN domain : super.list()) {
                count += super.removeById((Serializable) field.get(domain)) ? 1 : 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }


    @Override
    public String getExportTemplatUrl(Class<?> restClass) {
        String url = URL;
        String timestamp = String.valueOf(System.currentTimeMillis());
        try {
            RequestMapping anno = restClass.getAnnotation(RequestMapping.class);
            url += (ServiceUtil.getStrByArr(anno.value()) + Constant.MAPP_URL_SUPER_EXPORT_TEMPLAT);

            //加密为16进制表示
            url += ("?encrypt=" + ServiceUtil.AesE(timestamp));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CloudException(ErrorMsg.URL_MADE_ERROR);
        }

        return url;
    }

    @Override
    public String getExportDataUrl(Class<?> restClass) {
        String url = URL;
        String timestamp = String.valueOf(System.currentTimeMillis());
        try {
            RequestMapping anno = restClass.getAnnotation(RequestMapping.class);
            url += (ServiceUtil.getStrByArr(anno.value()) + Constant.MAPP_URL_SUPER_EXPORT_DATA);

            //加密为16进制表示
            url += ("?encrypt=" + ServiceUtil.AesE(timestamp));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CloudException(ErrorMsg.URL_MADE_ERROR);
        }

        return url;
    }

    @Override
    public DOMAIN fieldFilter(DOMAIN entity) {
        try {
            Field field = baseEntityClass.getDeclaredField("isDelete");
            field.setAccessible(true);
            Boolean isDelete = (Boolean) field.get(entity);
            if (isDelete) {
                return null;
            }
        } catch (Exception e) {
            CloudException.log(e, "信息过滤异常");
            return null;
        }
        return entity;
    }

    @Override
    public List<DOMAIN> fieldFilter(List<DOMAIN> entitys) {
        for (DOMAIN entity : entitys) {
            DOMAIN temp = this.fieldFilter(entity);
            if (ServiceUtil.isNull(temp)) {
                entitys.remove(entity);
            }
        }
        return entitys;
    }
}

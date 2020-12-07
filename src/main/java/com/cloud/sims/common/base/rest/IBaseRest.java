package com.cloud.sims.common.base.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.sims.common.base.service.IBaseService;
import com.cloud.sims.common.config.annotation.ApiLog;
import com.cloud.sims.common.config.annotation.Authority;
import com.cloud.sims.common.config.annotation.VisitController;
import com.cloud.sims.common.config.exception.Assert;
import com.cloud.sims.common.config.result.Result;
import com.cloud.sims.common.constant.Constant;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author longxin
 *
 * @param <DOMAIN>
 * @param <ID>
 * @param <S>
 */
@Slf4j
public class IBaseRest<DOMAIN, ID,  S extends IBaseService<DOMAIN, ID>, REST extends IBaseRest> {


    /**
     * 动态 IOC代理
     *
     * 多个需要使用Autowired
     */
    @Autowired
    protected S service;


    /**
     * 当前泛Controller真实类型的Class
     */
    protected Class<REST> restClass;

    public IBaseRest() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        //pt包含BaseController<DOMAIN, ID,  S extends IBaseService<DOMAIN, ID>, Control>中的各个参数类
        restClass = (Class<REST>) pt.getActualTypeArguments()[3];
    }



    /**
     * 分页列表
     * @param req
     * @param res
     * @param page
     * @return
     */
    @Authority
    @ApiLog(value = "分页查询", model = "#")
    @VisitController
    @ApiOperation(value = "#分页列表")
    @RequestMapping(value = "super-page-list", method = {RequestMethod.GET})
    public Result<?> superPageList(Page page) {
        log.info("=========>>>#分页列表");

        IPage<DOMAIN> entitys = service.page(page);
        Assert.notNull(entitys, "内容为空");
        return Result.ok(entitys);
    }

    /**
     *
     * @param req
     * @param res
     * @param file
     * @return
     */
    @Authority
    @ApiLog(value = "Excel批量导入", model = "#", operateType = Constant.OPERATE_TYPE_2)
    @VisitController
    @ApiOperation(value = "#Excel批量导入")
    @RequestMapping(value = "super-import-excel", method = {RequestMethod.POST})
    public Result<?> superImportExcel(MultipartFile file) {
        log.info("=========>>>#Excel批量导入");

        return Result.ok(service.importExcel(file));
    }

    /**
     * 导出数据模板
     * @param req
     * @param res
     * @param encrypt
     */
    @Authority
    @ApiLog(value = "导出数据模板", model = "#")
    @VisitController
    @SneakyThrows
    @RequestMapping(value = Constant.MAPP_URL_SUPER_EXPORT_TEMPLAT, method = {RequestMethod.GET})
    public void superExportTemplat(HttpServletResponse res, String encrypt) {
        log.info("=========>>>#导出数据模板");

        service.checkEncrypt(encrypt);
        service.writeWorkbook(service.exportTemplat(), service.outputStream(res, "-DataTemplat.xls"));
    }

    /**
     * 导出数据模板
     * @param req
     * @param res
     * @param encrypt
     */
    @Authority
    @ApiLog(value = "导出数据", model = "#")
    @VisitController
    @SneakyThrows
    @RequestMapping(value = Constant.MAPP_URL_SUPER_EXPORT_DATA, method = {RequestMethod.GET})
    public void superExportData(HttpServletResponse res, String encrypt) {
        log.info("=========>>>#导出数据");

        service.checkEncrypt(encrypt);
        service.writeWorkbook(service.exportData(), service.outputStream(res, "-DataData.xls"));
    }

    /**
     * 获取数据模板下载链接
     * @param req
     * @param res
     * @return
     */
    @Authority
    @ApiLog(value = "获取数据模板下载链接", model = "#")
    @VisitController
    @ApiOperation(value = "#获取数据模板下载链接")
    @RequestMapping(value = "super-export-templat-url", method = {RequestMethod.GET})
    public Result<?> superExportTemplatUrl() {
        log.info("=========>>>#获取数据模板下载链接");

        return Result.ok(Constant.ENCRYPT_TIME_OUT_MAX_SECONDES + "秒后链接失效", service.getExportTemplatUrl(restClass));
    }

    /**
     * 获取数据模板下载链接
     * @param req
     * @param res
     * @return
     */
    @Authority
    @ApiLog(value = "获取数据导出链接", model = "#")
    @VisitController
    @ApiOperation(value = "#获取数据导出链接")
    @RequestMapping(value = "super-export-data-url", method = {RequestMethod.GET})
    public Result<?> superExportDataUrl() {
        log.info("=========>>>#获取数据导出链接");

        return Result.ok(Constant.ENCRYPT_TIME_OUT_MAX_SECONDES + "秒后链接失效", service.getExportDataUrl(restClass));
    }


    /**
     * 新增/更新数据
     * @param req
     * @param res
     * @param entity
     * @return
     */
    @Authority
    @ApiLog(value = "新增/更新", model = "#", operateType = Constant.OPERATE_TYPE_3)
    @VisitController
    @ApiOperation(value = "#新增/更新")
    @RequestMapping(value = "super-edit", method = RequestMethod.PUT)
    public Result<?> superEdit(DOMAIN entity) {
        log.info("=========>>>#新增/更新");

        return Result.ok(service.saveOrUpdate(entity));
    }



    /**
     * 全部列表
     * @param req
     * @param res
     * @return
     */
    @Authority
    @ApiLog(value = "全部列表", model = "#")
    @VisitController
    @ApiOperation(value = "#全部列表")
    @RequestMapping(value = "super-list", method = RequestMethod.GET)
    public Result<?> superList(HttpServletRequest req, HttpServletResponse res) {
        log.info("=========>>>#全部列表");

        List<DOMAIN> entitys = service.list();
        Assert.notNull(entitys, "内容为空");
        return Result.ok(entitys);
    }

    /**
     * 根据ID删除(逻辑删)
     * @param req
     * @param res
     * @param ids
     * @return
     */
    @Authority
    @ApiLog(value = "根据ID删除(逻辑删)", model = "#", operateType = Constant.OPERATE_TYPE_4)
    @VisitController
    @ApiOperation(value = "#根据ID删除(逻辑删)")
    @RequestMapping(value = "super-delete", method = RequestMethod.DELETE)
    public Result<?> superDeleteByIds(ID []ids) {
        log.info("=========>>>#根据ID删除(逻辑删)");

        return Result.ok("共删除：" + service.deleteById(ids));
    }

    /**
     * 根据ID删除(逻辑删)
     * @param req
     * @param res
     * @param ids
     * @return
     */
    @Authority
    @ApiLog(value = "根据ID删除", model = "#", operateType = Constant.OPERATE_TYPE_4)
    @VisitController
    @ApiOperation(value = "#根据ID删除")
    @RequestMapping(value = "super-remove/{id}", method = RequestMethod.GET)
    public Result<?> superDeleteByIds(@PathVariable("id") ID id) {
        log.info("=========>>>#根据ID删除(逻辑删)");

        return Result.ok("共删除：" + service.removeById((Serializable) id));
    }

    /**
     * 根据ID获取 包含过滤
     * @param id
     * @return
     */
    @Authority
    @ApiLog(value = "根据ID获取(过滤内容)", model = "#")
    @VisitController
    @ApiOperation(value = "#根据ID获取(过滤内容)")
    @RequestMapping(value = "super-get/{id}", method = RequestMethod.GET)
    public Result<?> superGetById(@PathVariable("id") ID id) {
        log.info("=========>>>#根据ID获取(过滤内容)");

        DOMAIN entity = service.getById((Serializable) id);
        Assert.notNull(entity, "该内容不存在或已被删除");
        return Result.ok(service.fieldFilter(entity));
    }

    /**
     * 根据ID获取
     * @param id
     * @return
     */
    @Authority
    @ApiLog(value = "根据ID获取", model = "#")
    @VisitController
    @ApiOperation(value = "#根据ID获取")
    @RequestMapping(value = "super-get-no-filter/{id}", method = RequestMethod.GET)
    public Result<?> superGetByIdNoFilter(@PathVariable("id") ID id) {
        log.info("=========>>>#根据ID获取");

        DOMAIN entity = service.getById((Serializable) id);
        Assert.notNull(entity, "该内容不存在或已被删除");
        return Result.ok(entity);
    }
}

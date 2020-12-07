package com.cloud.sims.common.base.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IBaseService<DOMAIN, ID>  extends IService<DOMAIN>, IBaseAbstractService {


    /**
     * 根据ID删除数据（逻辑删）
     * @param ids
     * @return
     */
    Integer deleteById(ID []ids);

    /**
     * 获取导出数据模板的链接
     * @return
     */
    String getExportTemplatUrl(Class<?> restClass);


    /**
     * 获取导出数据下载的链接
     * @return
     */
    String getExportDataUrl(Class<?> restClass);

    /**
     * 过滤
     * @param entity
     * @return
     */
    DOMAIN fieldFilter(DOMAIN entity);

    /**
     * 过滤
     * @param entitys
     * @return
     */
    List<DOMAIN> fieldFilter(List<DOMAIN>  entitys);
}

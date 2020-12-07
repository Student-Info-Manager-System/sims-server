package com.cloud.sims.business.module.major.service;

import com.cloud.sims.business.module.major.pojo.entity.Major;
import com.cloud.sims.business.module.major.pojo.from.MajorFrom;
import com.cloud.sims.common.base.service.IBaseService;

import java.util.List;

/**
 * @author Long
 */
public interface MajorService extends IBaseService<Major, String> {
    /**
     * 增加专业
     * @param from
     * @return
     */
    Major addMajor(MajorFrom from);
}

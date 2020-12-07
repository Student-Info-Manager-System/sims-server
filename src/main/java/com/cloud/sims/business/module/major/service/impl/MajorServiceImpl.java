package com.cloud.sims.business.module.major.service.impl;

import com.cloud.sims.business.module.major.mapper.MajorMapper;
import com.cloud.sims.business.module.major.pojo.entity.Major;
import com.cloud.sims.business.module.major.pojo.from.MajorFrom;
import com.cloud.sims.business.module.major.service.MajorService;
import com.cloud.sims.common.base.service.impl.IBaseServiceImpl;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Long
 */
@Slf4j
@Service
public class MajorServiceImpl extends IBaseServiceImpl<Major, String, MajorMapper> implements MajorService {
    @Override
    public Major addMajor(MajorFrom from) {
        if (ServiceUtil.isNull(from.getCode())){
            throw new CloudException(ErrorMsg.MAJOR_CODE_NOT_NULL);
        }
        if (ServiceUtil.isNull(from.getName())) {
            throw new CloudException(ErrorMsg.MAJOR_NAME_NOT_NULL);
        }
        Major major = new Major(from.getName(), from.getCode());
        mapper.insert(major);
        return major;
    }
}

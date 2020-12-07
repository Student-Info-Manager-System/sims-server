package com.cloud.sims.system.syslog.service.impl;

import com.cloud.sims.common.base.service.impl.IBaseServiceImpl;
import com.cloud.sims.system.syslog.mapper.SysLogMapper;
import com.cloud.sims.system.syslog.pojo.entity.SysLog;
import com.cloud.sims.system.syslog.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * @author Long
 */
@Service
public class SysLogServiceImpl extends IBaseServiceImpl<SysLog, String, SysLogMapper> implements SysLogService {

}

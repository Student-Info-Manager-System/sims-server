package com.cloud.sims.system.syslog.rest;

import com.cloud.sims.common.base.rest.IBaseRest;
import com.cloud.sims.common.config.annotation.Authority;
import com.cloud.sims.system.syslog.pojo.entity.SysLog;
import com.cloud.sims.system.syslog.service.SysLogService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Long
 */
//@Authority
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/sims/log/v1")
@RequiredArgsConstructor
@Api(tags = "日志模块")
public class SysLogRest extends IBaseRest<SysLog, String, SysLogService, SysLogRest> {

}

package com.cloud.sims.business.module.leader.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cloud.sims.business.module.leader.mapper.LeaderMapper;
import com.cloud.sims.business.module.leader.pojo.dto.GradeLeaderInfoDTO;
import com.cloud.sims.business.module.leader.pojo.entity.Leader;
import com.cloud.sims.business.module.leader.pojo.vo.GradeLeaderInfoVO;
import com.cloud.sims.business.module.leader.service.LeaderService;
import com.cloud.sims.business.module.student.pojo.entity.Student;
import com.cloud.sims.common.base.service.impl.IBaseServiceImpl;
import com.cloud.sims.common.config.exception.Assert;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.config.shiro.AccountProfile;
import com.cloud.sims.common.constant.Constant;
import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.ServiceUtil;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import com.cloud.sims.system.sysuser.pojo.entity.SysUser;
import com.cloud.sims.system.sysuser.pojo.from.LoginFrom;
import com.cloud.sims.system.sysuser.pojo.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Long
 */
@Slf4j
@Service
public class LeaderServiceImpl extends IBaseServiceImpl<Leader, String, LeaderMapper> implements LeaderService {




    @Override
    public UserInfoDTO login(LoginFrom from) {
        if (!ServiceUtil.equal(from.getType(), Constant.USER_TYPE_TEACHER)){
            throw new CloudException(ErrorMsg.ACCOUNT_IDENTITY_ERROR);
        }
        String account = from.getAccount();
        String password = from.getPassword();
        Assert.isTrue(!ServiceUtil.hasNull(account, password), ErrorMsg.USER_INFO_MUST_NOT_NULL);

        Leader leader = this.findByNumber(account);
        SysUser user = null;
        if (ServiceUtil.isNotNull(leader)) {
            user = manager.sysUserService.getById(leader.getSysUserId());
        } else {
            user = manager.sysUserService.findByUserName(account);
            leader = this.getBySysUser(user);
        }
        Assert.notNull(user, ErrorMsg.ACCOUNT_NOT_FOUND);

        manager.sysUserService.login(user, password);

        return this.getDto(leader, user);
    }

    @Override
    public UserInfoDTO getDto(Leader leader, SysUser user) {
        UserInfoDTO dto = new UserInfoDTO();

        UserInfoVO vo = new UserInfoVO();
        BeanUtils.copyProperties(leader, vo);
        BeanUtils.copyProperties(user, vo);
        if (ServiceUtil.isNotNull(user.getBirth())) {
            vo.setBirthDay(DateUtil.format(user.getBirth(), "yyyy/MM/dd"));
        }
        Assert.notNull(vo);
        vo.setType(Constant.USER_TYPE_TEACHER);
        return dto.ok(vo);
    }



    @Override
    public AccountProfile login(UserInfoDTO dto) {
        return manager.sysUserService.login(dto);
    }

    @Override
    public UserInfoDTO getLogin() {
        SysUser user = manager.sysUserService.getLoginUser();
        Leader leader = this.getBySysUserId(user.getId());
        return this.getDto(leader, user);
    }

    @Override
    public UserInfoDTO getDtoByNumber(String number) {
        Leader leader = this.getByNumber(number);
        SysUser user = manager.sysUserService.getById(leader.getSysUserId());
        Assert.notNull(user);

        return this.getDto(leader, user);
    }

    @Override
    public Leader findByNumber(String number) {
        LambdaQueryWrapper<Leader> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Leader::getNumber, number);
        return mapper.selectOne(wrapper);
    }

    @Override
    public Leader getByNumber(String number) {
        Leader entity = this.findByNumber(number);
        Assert.notNull(entity);
        return entity;
    }

    @Override
    public Leader getBySysUser(SysUser user) {
        Assert.notNull(user, ErrorMsg.ACCOUNT_NOT_FOUND);
        return this.getBySysUserId(user.getId());
    }


    @Override
    public Leader getBySysUserId(String sysUserId) {
        LambdaQueryWrapper<Leader> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Leader::getSysUserId, sysUserId);
        Leader entity = mapper.selectOne(wrapper);
        Assert.notNull(entity);
        return entity;
    }

    @Override
    public GradeLeaderInfoDTO findDtoById(String id) {
        GradeLeaderInfoDTO dto = new GradeLeaderInfoDTO();

        Leader entity = mapper.selectById(id);

        if (ServiceUtil.isNull(entity)) {
            dto.setSuccess(false);
            return dto;
        }
        SysUser sysUser = manager.sysUserService.getById(entity.getSysUserId());
        if (ServiceUtil.isNull(sysUser)) {
            dto.setSuccess(false);
            return dto;
        }

        GradeLeaderInfoVO vo = new GradeLeaderInfoVO();
        BeanUtils.copyProperties(entity, vo);
        BeanUtils.copyProperties(sysUser, vo);

        return dto.ok(vo);
    }
}

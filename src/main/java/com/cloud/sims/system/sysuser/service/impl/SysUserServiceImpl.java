package com.cloud.sims.system.sysuser.service.impl;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cloud.sims.common.base.service.impl.IBaseServiceImpl;
import com.cloud.sims.common.config.exception.Assert;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.config.shiro.AccountProfile;
import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.ServiceUtil;
import com.cloud.sims.common.utils.ShiroUtil;
import com.cloud.sims.common.utils.StrUtil;
import com.cloud.sims.system.sysuser.mapper.SysUserMapper;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import com.cloud.sims.system.sysuser.pojo.entity.SysUser;
import com.cloud.sims.system.sysuser.pojo.from.EditPwdFrom;
import com.cloud.sims.system.sysuser.pojo.from.EditUserFrom;
import com.cloud.sims.system.sysuser.pojo.vo.UserInfoVO;
import com.cloud.sims.system.sysuser.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author Long
 */
@Slf4j
@Service
public class SysUserServiceImpl extends IBaseServiceImpl<SysUser, String, SysUserMapper> implements SysUserService {
    @Override
    public List<SysUser> search(String name) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(SysUser::getName, name);
        return mapper.selectList(wrapper);
    }

    @Override
    public boolean editName(String id, String name) {
        LambdaUpdateWrapper<SysUser> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SysUser::getId, id);
        wrapper.set(SysUser::getName, name);
        return super.update(wrapper);
    }

    @Override
    public void del(String id) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getId, id);
        mapper.delete(wrapper);
    }

    @Override
    public void editPwd(EditPwdFrom from) {
        if (ServiceUtil.hasNull(from.getNewPwd(), from.getNewTwoPwd(), from.getOldPwd(), from.getId())) {
            throw new CloudException(ErrorMsg.CHECK_DATA);
        }
        SysUser user = this.getById(from.getId());
        if (!ServiceUtil.equal(from.getNewPwd(), from.getNewTwoPwd())) {
            throw new CloudException(ErrorMsg.PWD_NOT_EQ);
        }
        if (!ServiceUtil.equal(user.getPassword(), from.getOldPwd())) {
            throw new CloudException(ErrorMsg.USER_INFO_NOT_SUCCESS);
        }
        user.setPassword(from.getNewPwd());
        LambdaUpdateWrapper<SysUser> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SysUser::getId, user.getId());
        wrapper.set(SysUser::getPassword, from.getNewPwd());
        super.update(wrapper);
    }

    @Override
    public AccountProfile login(UserInfoDTO dto) {
        UserInfoVO vo = dto.getVo();
        return new AccountProfile(vo.getId(), vo.getType());
    }

    @Override
    public SysUser add(SysUser user) {
        if (ServiceUtil.hasNull(user.getUsername(), user.getPassword(), user.getName())) {
            throw new CloudException(ErrorMsg.DATA_NOT_FOLL);
        }
        this.checkUsername(user.getUsername());
        user.setAvatar("http://qzapp.qlogo.cn/qzapp/101914038/5B0473076C3092B3AB5A4062D1132C04/100");
        mapper.insert(user);
        return this.findByUserName(user.getUsername());
    }

    @Override
    public void checkUsername(String username) {
        SysUser user1 = this.findByUserName(username);
        if (ServiceUtil.isNull(user1)){
            return;
        }
        SysUser user = this.getLoginUser();

        if (ServiceUtil.equal(user1.getId(), user.getId())) {
            return;
        }
        throw new CloudException(ErrorMsg.USERNAME_IS_EXISTENCE);
    }

    @Override
    public UserInfoDTO getDto(SysUser user) {
        UserInfoDTO dto = new UserInfoDTO();

        UserInfoVO vo = new UserInfoVO();
        BeanUtils.copyProperties(user, vo);
        if (ServiceUtil.isNotNull(user.getBirth())) {
            vo.setBirthDay(DateUtil.format(user.getBirth(), "yyyy/MM/dd"));
        }
        Assert.notNull(vo);
        return dto.ok(vo);
    }

    @Override
    public UserInfoDTO findByUserLogin() {
        return this.getDto(this.getLoginUser());
    }

    @Override
    public UserInfoDTO edit(EditUserFrom from) {
        UserInfoDTO dto = new UserInfoDTO();
        SysUser entity = this.getLoginUser();
        entity = this.edit(from, entity);
        UserInfoVO vo = new UserInfoVO();
        BeanUtils.copyProperties(entity, vo);
        return dto.ok(vo);
    }

    @Override
    public SysUser edit(EditUserFrom from, SysUser user) {
        LambdaUpdateWrapper<SysUser> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SysUser::getId, user.getId());
        if (ServiceUtil.isNotNull(from.getAddress())) {
            user.setAddress(from.getAddress());
        }
        if (ServiceUtil.isNotNull(from.getSex())) {
            user.setSex(from.getSex());
        }
        if (ServiceUtil.isNotNull(from.getUsername())) {
            this.checkUsername(from.getUsername());
            user.setUsername(from.getUsername());
        }
        if (ServiceUtil.isNotNull(from.getBirthDay())) {
            Date date = DateUtil.parseDate(from.getBirthDay());
            user.setBirth(date);
        }
        if (ServiceUtil.isNotNull(from.getPhone())) {
            if(!StrUtil.validateMobilePhone(from.getPhone())){
                throw new CloudException(ErrorMsg.PHONE_FORMAT_ERROR);
            }
            user.setPhone(from.getPhone());
        }
        if (ServiceUtil.isNotNull(from.getEmail())) {
            if(!StrUtil.validateMobileEmial(from.getEmail())){
                throw new CloudException(ErrorMsg.EMAIL_FORMAT_ERROR);
            }
            user.setEmail(from.getEmail());
        }
        mapper.update(user, wrapper);
        return user;
    }

    @Override
    public SysUser findByUserName(String username) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, username);
        return mapper.selectOne(wrapper);
    }


    @Override
    public void login(SysUser user, String password) {
        Assert.notNull(user, ErrorMsg.ACCOUNT_NOT_FOUND);
        if (ServiceUtil.equal(user.getPassword(), password)) {
            return;
        }
        throw new CloudException(ErrorMsg.USER_INFO_NOT_SUCCESS);
    }

    @Override
    public void logout() {
        SecurityUtils.getSubject().logout();
    }


    @Override
    public SysUser getLoginUser() {
        SysUser user = this.findLoginUser();
        if (ServiceUtil.isNull(user)) {
            throw new CloudException(ErrorMsg.LOGIN_USER_FIND_FAIL);
        }
        return user;
    }

    @Override
    public SysUser findLoginUser() {
        SysUser user = null;
        try {
            String id = ShiroUtil.getUserId();
            if (ServiceUtil.isNotNull(id)) {
                user = mapper.selectById(id);
            }
        } catch (Exception e) {
            CloudException.log(e, ErrorMsg.LOGIN_USER_FIND_FAIL);
        }
        return user;
    }
}

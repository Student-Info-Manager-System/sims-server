package com.cloud.sims.system.sysuser.service;


import com.cloud.sims.common.base.service.IBaseService;
import com.cloud.sims.common.config.shiro.AccountProfile;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import com.cloud.sims.system.sysuser.pojo.entity.SysUser;
import com.cloud.sims.system.sysuser.pojo.from.EditPwdFrom;
import com.cloud.sims.system.sysuser.pojo.from.EditUserFrom;

import java.util.List;

/**
 * @author Long
 */
public interface SysUserService extends IBaseService<SysUser, String> {
    /**
     * 搜索
     * @param name
     * @return
     */
    List<SysUser> search(String name);

    /**
     *
     * @param id
     * @param name
     * @return
     */
    boolean editName(String id,String name);

    /**
     *
     * @param id
     */
    void del(String id);

    /**
     * 修改米密码
     * @param from
     */
    void editPwd(EditPwdFrom from);

    /**
     * 登陆信息
     * @param dto
     * @return
     */
    AccountProfile login(UserInfoDTO dto);

    /**
     * 新增用户
     * @param user
     * @return
     */
    SysUser add(SysUser user);

    /**
     * 检查该用户是否存在
     * @param username
     */
    void checkUsername(String username);
    /**
     * 获取dto
     * @param user
     * @return
     */
    UserInfoDTO getDto(SysUser user);

    /**
     * 获取当前登录用户ID
     * @return
     */
    UserInfoDTO findByUserLogin();

    /**
     * 修改用户信息
     * @param from
     * @return
     */
    UserInfoDTO edit(EditUserFrom from);

    /**
     *
     * @param from
     * @param user
     * @return
     */
    SysUser edit(EditUserFrom from, SysUser user);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    SysUser findByUserName(String username);

    /**
     * 登录
     *
     * @param user
     * @param password
     * @return
     */
    void login(SysUser user, String password);

    /**
     * 注销登录
     */
    void logout();

    /**
     * 获取当前登录用户 没有会抛异常
     * @return
     */
    SysUser getLoginUser();

    /**
     * 查找当前到当前登录用户
     * @return
     */
    SysUser findLoginUser();
}

package com.cloud.sims.business.module.leader.service;

import com.cloud.sims.business.module.leader.pojo.dto.GradeLeaderInfoDTO;
import com.cloud.sims.business.module.leader.pojo.entity.Leader;
import com.cloud.sims.business.module.student.pojo.entity.Student;
import com.cloud.sims.common.base.service.IBaseService;
import com.cloud.sims.common.config.shiro.AccountProfile;
import com.cloud.sims.system.sysuser.pojo.dto.UserInfoDTO;
import com.cloud.sims.system.sysuser.pojo.entity.SysUser;
import com.cloud.sims.system.sysuser.pojo.from.LoginFrom;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Long
 */
public interface LeaderService extends IBaseService<Leader, String> {
    /**
     * 登陆信息
     * @param dto
     * @return
     */
    AccountProfile login(UserInfoDTO dto);
    /**
     * 获取当前登录
     * @return
     */
    UserInfoDTO getLogin();

    /**
     * 根据工号获取
     * @param number
     * @return
     */
    UserInfoDTO getDtoByNumber(String number);

    /**
     * 根据工号获取
     * @param number
     * @return
     */
    Leader findByNumber(String number);

    /**
     * 根据工号获取
     * @param number
     * @return
     */
    Leader getByNumber(String number);

    /**
     *
     * @param user
     * @return
     */
    Leader getBySysUser(SysUser user);


    /**
     * 账号登录
     * @param account
     * @param password
     * @return
     */
    UserInfoDTO login(LoginFrom from);

    /**
     * 组装教师信息
     * @param leader
     * @param user
     * @return
     */
    UserInfoDTO getDto(Leader leader, SysUser user);

    /**
     * 根据id获取
     * @param sysUserId
     * @return
     */
    Leader getBySysUserId(String sysUserId);

    /**
     * 根据id获取班级信息
     * @param id
     * @return
     */
    GradeLeaderInfoDTO findDtoById(String id);
}

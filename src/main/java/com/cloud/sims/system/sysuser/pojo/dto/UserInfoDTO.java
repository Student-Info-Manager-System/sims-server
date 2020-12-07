package com.cloud.sims.system.sysuser.pojo.dto;

import com.cloud.sims.system.sysuser.pojo.vo.UserInfoVO;
import com.cloud.sims.common.base.pojo.dto.IBaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Long
 */
@Getter
@Setter
@NoArgsConstructor
public class UserInfoDTO extends IBaseDTO<UserInfoVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    public UserInfoDTO ok(UserInfoVO vo){
        this.setVo(vo);
        return this;
    }
}

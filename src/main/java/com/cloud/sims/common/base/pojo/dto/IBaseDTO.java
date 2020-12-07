package com.cloud.sims.common.base.pojo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Long
 */
@Getter
@Setter
//@NoArgsConstructor
public class IBaseDTO<VO> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Boolean success;
    protected String message;
    protected VO vo;

    public IBaseDTO() {
        this.success = true;
        this.message = "Success";
    }

    public IBaseDTO(VO vo) {
        this();
        this.vo = vo;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
        this.message = "信息不存在";
    }
}

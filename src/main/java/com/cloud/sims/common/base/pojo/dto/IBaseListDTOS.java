package com.cloud.sims.common.base.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Long
 */
@Getter
@Setter
public class IBaseListDTOS<VO> extends IBaseDTO<List<VO>> implements Serializable {
    private static final long serialVersionUID = 1L;


}

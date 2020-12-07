package com.cloud.sims.business.module.grade.pojo.dto;

import com.cloud.sims.business.module.grade.pojo.vo.GradeInfoVO;
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
public class GradeInfoDTO extends IBaseDTO<GradeInfoVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    public GradeInfoDTO ok(GradeInfoVO vo) {
        this.vo = vo;
        return this;
    }
}

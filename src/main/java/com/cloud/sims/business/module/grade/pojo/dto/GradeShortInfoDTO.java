package com.cloud.sims.business.module.grade.pojo.dto;

import com.cloud.sims.business.module.grade.pojo.vo.GradeShortInfoVO;
import com.cloud.sims.common.base.pojo.dto.IBaseListDTOS;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Long
 */
@Getter
@Setter
@NoArgsConstructor
public class GradeShortInfoDTO extends IBaseListDTOS<GradeShortInfoVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    public GradeShortInfoDTO ok(List<GradeShortInfoVO> vo) {
        this.vo = vo;
        return this;
    }
}

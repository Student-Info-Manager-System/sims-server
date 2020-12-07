package com.cloud.sims.business.module.course.pojo.dto;

import com.cloud.sims.business.module.course.pojo.vo.GradeCourseInfoVO;
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
public class GradeCourseInfoDTO extends IBaseDTO<GradeCourseInfoVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    public GradeCourseInfoDTO ok(GradeCourseInfoVO vo) {
        this.setVo(vo);
        return this;
    }
}

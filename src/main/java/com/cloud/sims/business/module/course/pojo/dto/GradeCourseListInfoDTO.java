package com.cloud.sims.business.module.course.pojo.dto;

import com.cloud.sims.business.module.course.pojo.vo.GradeCourseInfoVO;
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
public class GradeCourseListInfoDTO extends IBaseListDTOS<GradeCourseInfoVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    public GradeCourseListInfoDTO ok(List<GradeCourseInfoVO> vos) {
        this.setVo(vos);
        return this;
    }
}
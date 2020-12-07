package com.cloud.sims.business.module.student.pojo.dto;


import com.cloud.sims.business.module.student.pojo.vo.GradeStudentInfoVO;
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
public class GradeStudentInfoDTO extends IBaseDTO<GradeStudentInfoVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    public GradeStudentInfoDTO ok(GradeStudentInfoVO vo){
        this.setVo(vo);
        return this;
    }
}

package com.cloud.sims.business.module.student.pojo.dto;

import com.cloud.sims.business.module.student.pojo.vo.GradeStudentInfoVO;
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
public class GradeStudentListInfoDTO extends IBaseListDTOS<GradeStudentInfoVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    public GradeStudentListInfoDTO ok(List<GradeStudentInfoVO> vos){
        this.setVo(vos);
        return this;
    }
}

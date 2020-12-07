package com.cloud.sims.business.module.leader.pojo.dto;

import com.cloud.sims.business.module.leader.pojo.vo.GradeLeaderInfoVO;
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
public class GradeLeaderInfoDTO extends IBaseDTO<GradeLeaderInfoVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    public GradeLeaderInfoDTO ok(GradeLeaderInfoVO vo) {
        this.setVo(vo);
        return this;
    }
}

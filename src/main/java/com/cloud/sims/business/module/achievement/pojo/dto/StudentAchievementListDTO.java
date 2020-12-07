package com.cloud.sims.business.module.achievement.pojo.dto;

import com.cloud.sims.business.module.achievement.pojo.vo.StudentAchievementVO;
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
public class StudentAchievementListDTO extends IBaseListDTOS<StudentAchievementVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    public StudentAchievementListDTO ok(List<StudentAchievementVO> vos){
        this.setVo(vos);
        return this;
    }
}

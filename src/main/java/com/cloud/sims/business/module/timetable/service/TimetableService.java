package com.cloud.sims.business.module.timetable.service;

import com.cloud.sims.business.module.timetable.pojo.entity.Timetable;
import com.cloud.sims.business.module.timetable.pojo.from.TimetableFrom;
import com.cloud.sims.business.module.timetable.pojo.vo.TimetableVO;
import com.cloud.sims.common.base.service.IBaseService;

import java.util.List;

/**
 * @author Long
 */
public interface TimetableService extends IBaseService<Timetable, String> {
    List<Timetable> findByCourseId(String courseId);

    List<TimetableVO> search(String gradeId, String search);

    List<Timetable> search(String search);

    List<Timetable> getByGradeId(String id);

    List<TimetableVO> getTimetableVO(String gradeId);

    Timetable add(TimetableFrom from);

    List<String> findCourseIdByGradeId(String gradeId);
}

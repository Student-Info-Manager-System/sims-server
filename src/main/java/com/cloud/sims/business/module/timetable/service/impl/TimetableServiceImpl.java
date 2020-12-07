package com.cloud.sims.business.module.timetable.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cloud.sims.business.module.course.pojo.entity.Course;
import com.cloud.sims.business.module.timetable.mapper.TimetableMapper;
import com.cloud.sims.business.module.timetable.pojo.entity.Timetable;
import com.cloud.sims.business.module.timetable.pojo.from.TimetableFrom;
import com.cloud.sims.business.module.timetable.pojo.vo.TimetableVO;
import com.cloud.sims.business.module.timetable.service.TimetableService;
import com.cloud.sims.common.base.service.impl.IBaseServiceImpl;
import com.cloud.sims.common.config.exception.Assert;
import com.cloud.sims.common.config.exception.CloudException;
import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.ServiceUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Long
 */
@Service
public class TimetableServiceImpl extends IBaseServiceImpl<Timetable, String, TimetableMapper> implements TimetableService {

    @Override
    public List<Timetable> findByCourseId(String courseId) {
        LambdaQueryWrapper<Timetable> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Timetable::getCourseId, courseId);
        return mapper.selectList(wrapper);
    }

    @Override
    public List<TimetableVO> search(String gradeId, String search) {
        Assert.notNull(gradeId, search);
        String courseName = search, teachTime = search;

        List<Timetable> timetables = this.search(teachTime);
        Set<Timetable> timetableSet = new HashSet<>();
        timetableSet.addAll(timetables);

        List<Course> courses = manager.courseService.search(courseName);
        for (Course course : courses){
            List<Timetable> ts = this.findByCourseId(course.getId());
            timetableSet.addAll(ts);
        }
        List<TimetableVO> vos = new ArrayList<>();

        for (Timetable timetable : timetableSet){
            Course course = manager.courseService.getById(timetable.getCourseId());
            TimetableVO vo = new TimetableVO();
            BeanUtils.copyProperties(timetable, vo);
            vo.setName(course.getName());
            vos.add(vo);
        }
        if (vos.size() < 1) {
            throw new CloudException("搜不到哦");
        }
        return vos;
    }

    @Override
    public List<Timetable> search(String search) {
        LambdaQueryWrapper<Timetable> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Timetable::getTeachTime, search);
        return mapper.selectList(wrapper);
    }

    @Override
    public List<Timetable> getByGradeId(String id) {
        LambdaQueryWrapper<Timetable> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Timetable::getGradeId, id);
        List<Timetable> entitys = mapper.selectList(wrapper);
        Assert.notNull(entitys);
        return entitys;
    }

    @Override
    public List<TimetableVO> getTimetableVO(String gradeId) {
        List<Timetable> timetables = this.getByGradeId(gradeId);
        List<TimetableVO> vos = new ArrayList<>();
        for (Timetable timetable : timetables){
            Course course = manager.courseService.getById(timetable.getCourseId());
            TimetableVO vo = new TimetableVO();
            BeanUtils.copyProperties(timetable, vo);
            vo.setName(course.getName());
            vos.add(vo);
        }

        return vos;
    }

    @Override
    public Timetable add(TimetableFrom from) {
        if(ServiceUtil.hasNull(from.getCourseId(), from.getTeachPosition(), from.getTeachTime(), from.getTeachTime(), from.getGradeId())) {
            throw new CloudException(ErrorMsg.CHECK_DATA);
        }

        Timetable timetable = new Timetable();
        BeanUtils.copyProperties(from, timetable);
        mapper.insert(timetable);
        return timetable;
    }

    @Override
    public List<String> findCourseIdByGradeId(String gradeId) {
        LambdaQueryWrapper<Timetable> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Timetable::getGradeId, gradeId);
        List<Timetable> entitys = mapper.selectList(wrapper);
        if (ServiceUtil.isNull(entitys)) {
            CloudException.log(ErrorMsg.NOT_FOUNT);
            return null;
        }
        List<String> courseIds = new ArrayList<>();
        for (Timetable entity : entitys) {
            courseIds.add(entity.getCourseId());
        }
        return courseIds;
    }
}

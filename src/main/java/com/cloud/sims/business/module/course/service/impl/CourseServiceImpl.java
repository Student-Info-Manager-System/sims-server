package com.cloud.sims.business.module.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cloud.sims.business.module.course.mapper.CourseMapper;
import com.cloud.sims.business.module.course.pojo.dto.GradeCourseListInfoDTO;
import com.cloud.sims.business.module.course.pojo.entity.Course;
import com.cloud.sims.business.module.course.pojo.from.CourseFrom;
import com.cloud.sims.business.module.course.pojo.from.EditFrom;
import com.cloud.sims.business.module.course.pojo.vo.GradeCourseInfoVO;
import com.cloud.sims.business.module.course.service.CourseService;
import com.cloud.sims.common.base.service.impl.IBaseServiceImpl;
import com.cloud.sims.common.config.exception.Assert;
import com.cloud.sims.common.constant.ErrorMsg;
import com.cloud.sims.common.utils.ServiceUtil;
import com.cloud.sims.system.sysuser.pojo.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Long
 */
@Slf4j
@Service
public class   CourseServiceImpl extends IBaseServiceImpl<Course, String, CourseMapper> implements CourseService {


    @Override
    public List<Course> search(String search) {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Course::getName, search).or().like(Course::getNumber, search);
        return mapper.selectList(wrapper);
    }

    @Override
    public void edit(EditFrom from) {
        Assert.notNull(from.getName(),from.getId());
        LambdaUpdateWrapper<Course> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Course::getId, from.getId());
        wrapper.set(Course::getName, from.getName()).set(Course::getCredit, from.getCredit())
                .set(Course::getLearnTime, from.getLearnTime());
        super.update(wrapper);
    }

    @Override
    public Course add(CourseFrom from) {
        Assert.notNull(from, ErrorMsg.CHECK_DATA);
        Course course = new Course();
        BeanUtils.copyProperties(from, course);
        mapper.insert(course);
        return course;
    }

    @Override
    public String getCourseNameById(String id) {
        Course entity = mapper.selectById(id);
        if (ServiceUtil.isNotNull(entity)) {
            return entity.getName();
        }
        return "";
    }



    @Override
    public List<String> findCourseIdByName(String name) {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Course::getName, name);
        List<Course> entitys = mapper.selectList(wrapper);
        Assert.notNull(entitys);
        return new ArrayList<String>(){{
            entitys.forEach((entity) ->{
                this.add(entity.getId());
            });
        }};
    }


    @Override
    public GradeCourseListInfoDTO findDtoByGradeId(String gradeId) {
        GradeCourseListInfoDTO dto = new GradeCourseListInfoDTO();

        List<String> courseIds = manager.timetableService.findCourseIdByGradeId(gradeId);
        if (ServiceUtil.isNull(courseIds)) {
            dto.setSuccess(false);
            return dto;
        }
        List<GradeCourseInfoVO> vos = new ArrayList<>();

        for (String id : courseIds){
            Course entity = mapper.selectById(id);
            if (ServiceUtil.isNull(entity)) {
                continue;
            }
            GradeCourseInfoVO vo = new GradeCourseInfoVO();
            BeanUtils.copyProperties(entity, vo);
            vos.add(vo);
        }

        if (ServiceUtil.isNull(vos)) {
            dto.setSuccess(false);
            return dto;
        }

        return dto.ok(vos);
    }
}

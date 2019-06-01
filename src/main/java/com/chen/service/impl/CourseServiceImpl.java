package com.chen.service.impl;

import com.chen.dao.course.CourseMapper;
import com.chen.entity.course.Course;
import com.chen.service.CourseService;
import com.chen.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseDao;

    @Override
    public List<CourseVO> listByCondition(int tid,int min,int max) {
        return courseDao.listByCondition(tid, min, max);
    }

    @Override
    public List<CourseVO> listInfo() {
        return courseDao.listInfo();
    }

    @Override
    public List<CourseVO> findAllCourse(int page, int limit) {

        return courseDao.findAllByPage(page,limit);
    }

    @Override
    public int update(Course course) {
        return courseDao.updateByPrimaryKeySelective(course);
    }

    @Override
    public int deleteById(int id) {
        return courseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int add(Course course) {
        return courseDao.insertSelective(course);
    }
}

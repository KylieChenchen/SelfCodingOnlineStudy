package com.chen.service;

import com.chen.entity.course.Course;
import com.chen.vo.CourseVO;

import java.util.List;

public interface CourseService {

    public List<CourseVO> listByCondition(int tid,int min,int max);

    public List<CourseVO> listInfo();

    public List<CourseVO> findAllCourse(int page, int limit);

//    public List<cou>

    int update(Course course);

    int deleteById(int id);

    int add(Course course);
}

package com.chen.dao.course;


import com.chen.entity.course.CoursePoint;

public interface CoursePointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoursePoint record);

    int insertSelective(CoursePoint record);

    CoursePoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoursePoint record);

    int updateByPrimaryKey(CoursePoint record);
}
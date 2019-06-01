package com.chen.dao.course;


import com.chen.entity.course.CourseType;

import java.util.List;

public interface CourseTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseType record);

    int insertSelective(CourseType record);

    CourseType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseType record);

    int updateByPrimaryKey(CourseType record);

    List<CourseType> findAll();
}
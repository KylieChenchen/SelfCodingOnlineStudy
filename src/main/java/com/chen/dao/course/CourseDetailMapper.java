package com.chen.dao.course;


import com.chen.entity.course.CourseDetail;

public interface CourseDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseDetail record);

    int insertSelective(CourseDetail record);

    CourseDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseDetail record);

    int updateByPrimaryKeyWithBLOBs(CourseDetail record);

    int updateByPrimaryKey(CourseDetail record);
}
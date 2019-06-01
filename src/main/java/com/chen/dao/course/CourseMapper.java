package com.chen.dao.course;


import com.chen.entity.course.Course;
import com.chen.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    public List<CourseVO> listByCondition(@Param("tid") int tid, @Param("min") int min, @Param("max") int max);


    public List<CourseVO> listInfo();

    // 后台课程
    public  List<CourseVO> findAllByPage(@Param("page") int page, @Param("limit") int limit);

    // 后台课程
//    public  List<CourseVO> findAll();

//    int addSelective(Course course);
}
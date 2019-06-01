package com.chen.dao.user;


import com.chen.entity.user.UserCourse;

public interface UserCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);
}
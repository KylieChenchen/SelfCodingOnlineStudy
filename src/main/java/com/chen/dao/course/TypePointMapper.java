package com.chen.dao.course;


import com.chen.entity.course.TypePoint;

public interface TypePointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypePoint record);

    int insertSelective(TypePoint record);

    TypePoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypePoint record);

    int updateByPrimaryKey(TypePoint record);
}
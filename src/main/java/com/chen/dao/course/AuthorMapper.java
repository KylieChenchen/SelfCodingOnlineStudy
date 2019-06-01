package com.chen.dao.course;


import com.chen.entity.course.Author;

import java.util.List;

public interface AuthorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);

    List<Author> findAll();

    String getLastId();


}
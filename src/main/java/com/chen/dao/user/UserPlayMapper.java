package com.chen.dao.user;


import com.chen.entity.user.UserPlay;

public interface UserPlayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPlay record);

    int insertSelective(UserPlay record);

    UserPlay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPlay record);

    int updateByPrimaryKey(UserPlay record);
}
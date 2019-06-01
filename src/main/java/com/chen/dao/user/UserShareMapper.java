package com.chen.dao.user;


import com.chen.entity.user.UserShare;

public interface UserShareMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserShare record);

    int insertSelective(UserShare record);

    UserShare selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserShare record);

    int updateByPrimaryKey(UserShare record);
}
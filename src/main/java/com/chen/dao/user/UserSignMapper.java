package com.chen.dao.user;


import com.chen.entity.user.UserSign;

public interface UserSignMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserSign record);

    int insertSelective(UserSign record);

    UserSign selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserSign record);

    int updateByPrimaryKey(UserSign record);
}
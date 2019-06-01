package com.chen.dao.user;


import com.chen.entity.user.UserLog;

public interface UserLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    UserLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKey(UserLog record);
}
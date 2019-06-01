package com.chen.dao.user;


import com.chen.entity.user.UserStream;

public interface UserStreamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserStream record);

    int insertSelective(UserStream record);

    UserStream selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserStream record);

    int updateByPrimaryKey(UserStream record);
}
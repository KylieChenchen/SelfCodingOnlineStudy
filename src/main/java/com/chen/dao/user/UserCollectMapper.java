package com.chen.dao.user;


import com.chen.entity.user.UserCollect;

public interface UserCollectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCollect record);

    int insertSelective(UserCollect record);

    UserCollect selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCollect record);

    int updateByPrimaryKey(UserCollect record);
}
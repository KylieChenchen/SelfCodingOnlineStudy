package com.chen.dao.user;


import com.chen.entity.user.UserAppraise;

public interface UserAppraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAppraise record);

    int insertSelective(UserAppraise record);

    UserAppraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAppraise record);

    int updateByPrimaryKey(UserAppraise record);
}
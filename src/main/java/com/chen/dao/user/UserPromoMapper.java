package com.chen.dao.user;


import com.chen.entity.user.UserPromo;

public interface UserPromoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPromo record);

    int insertSelective(UserPromo record);

    UserPromo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPromo record);

    int updateByPrimaryKey(UserPromo record);
}
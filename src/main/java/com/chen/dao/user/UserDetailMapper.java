package com.chen.dao.user;


import com.chen.entity.user.UserDetail;

import java.util.List;

public interface UserDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);


    public int addBatch(List<UserDetail> list);
}
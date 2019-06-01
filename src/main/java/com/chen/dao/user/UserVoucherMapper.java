package com.chen.dao.user;


import com.chen.entity.user.UserVoucher;

public interface UserVoucherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVoucher record);

    int insertSelective(UserVoucher record);

    UserVoucher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVoucher record);

    int updateByPrimaryKey(UserVoucher record);
}
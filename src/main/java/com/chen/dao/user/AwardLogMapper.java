package com.chen.dao.user;


import com.chen.entity.user.AwardLog;

public interface AwardLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AwardLog record);

    int insertSelective(AwardLog record);

    AwardLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AwardLog record);

    int updateByPrimaryKey(AwardLog record);
}
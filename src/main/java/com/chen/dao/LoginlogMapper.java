package com.chen.dao;


import com.chen.entity.Loginlog;

import java.util.List;

public interface LoginlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Loginlog record);

    int insertSelective(Loginlog record);

    Loginlog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Loginlog record);

    int updateByPrimaryKey(Loginlog record);

    public List<Loginlog> selectAll();
}
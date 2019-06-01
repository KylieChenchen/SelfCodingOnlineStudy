package com.chen.dao;

import com.chen.entity.Menu;
import com.chen.vo.VMenuInfo;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    public List<VMenuInfo> findMenu();
}
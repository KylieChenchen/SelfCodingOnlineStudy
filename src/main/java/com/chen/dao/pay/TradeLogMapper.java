package com.chen.dao.pay;


import com.chen.entity.pay.TradeLog;

public interface TradeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TradeLog record);

    int insertSelective(TradeLog record);

    TradeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TradeLog record);

    int updateByPrimaryKey(TradeLog record);
}
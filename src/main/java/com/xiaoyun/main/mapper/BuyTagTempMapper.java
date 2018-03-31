package com.xiaoyun.main.mapper;

import java.util.List;

import com.xiaoyun.main.model.BuyTagTemp;

public interface BuyTagTempMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BuyTagTemp record);

    int insertSelective(BuyTagTemp record);

    BuyTagTemp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BuyTagTemp record);

    int updateByPrimaryKey(BuyTagTemp record);
    
    int addBuyTagTemp(List<BuyTagTemp> list);
}
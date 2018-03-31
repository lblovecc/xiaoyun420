package com.xiaoyun.main.mapper;

import java.util.List;

import com.xiaoyun.main.model.SupplyTagTemp;

public interface SupplyTagTempMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SupplyTagTemp record);

    int insertSelective(SupplyTagTemp record);

    SupplyTagTemp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SupplyTagTemp record);

    int updateByPrimaryKey(SupplyTagTemp record);
    
    int addSupplyTagTemp(List<SupplyTagTemp> list);
}
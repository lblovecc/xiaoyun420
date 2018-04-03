package com.xiaoyun.main.mapper;

import com.xiaoyun.main.model.ViewChance;

public interface ViewChanceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ViewChance record);

    int insertSelective(ViewChance record);

    ViewChance selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ViewChance record);

    int updateByPrimaryKey(ViewChance record);
    
    int updateViewChanceForFreeCount();
    
    int updateViewChanceForForwardCount();
    
    ViewChance selectOne(ViewChance viewChance);
}
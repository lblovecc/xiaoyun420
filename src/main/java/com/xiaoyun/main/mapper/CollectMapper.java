package com.xiaoyun.main.mapper;

import java.util.List;

import com.xiaoyun.main.model.Collect;

public interface CollectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
    
    List<Collect> getCollectList();
}
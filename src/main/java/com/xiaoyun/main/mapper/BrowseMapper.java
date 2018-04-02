package com.xiaoyun.main.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Browse;

public interface BrowseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Browse record);

    int insertSelective(Browse record);

    Browse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Browse record);

    int updateByPrimaryKey(Browse record);
    
    List<Browse> getBrowseList(Map<String,Object> qryMap);
}
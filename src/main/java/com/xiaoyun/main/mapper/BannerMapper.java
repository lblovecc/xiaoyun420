package com.xiaoyun.main.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Banner;

public interface BannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
    
    List<Banner> getBannerList(Map<String,Object> qryMap);
    
}
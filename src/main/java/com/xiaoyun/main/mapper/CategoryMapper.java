package com.xiaoyun.main.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    List<Category> getCategoryList(Map<String,Object> qryMap);
}
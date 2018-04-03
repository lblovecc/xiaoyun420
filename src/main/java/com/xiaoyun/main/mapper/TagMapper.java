package com.xiaoyun.main.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Tag;

import tk.mybatis.mapper.common.base.select.SelectOneMapper;

public interface TagMapper extends SelectOneMapper<Tag>{
    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
    
    List<Tag> getTagList(Map<String,Object> qryMap);
}
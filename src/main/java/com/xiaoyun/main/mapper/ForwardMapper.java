package com.xiaoyun.main.mapper;

import com.xiaoyun.main.model.Forward;

public interface ForwardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Forward record);

    int insertSelective(Forward record);

    Forward selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Forward record);

    int updateByPrimaryKey(Forward record);
}
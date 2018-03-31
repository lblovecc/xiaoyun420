package com.xiaoyun.main.mapper;

import com.xiaoyun.main.model.View;

public interface ViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(View record);

    int insertSelective(View record);

    View selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(View record);

    int updateByPrimaryKey(View record);
}
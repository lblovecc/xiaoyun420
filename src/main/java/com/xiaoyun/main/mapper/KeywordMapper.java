package com.xiaoyun.main.mapper;

import com.xiaoyun.main.model.Keyword;

public interface KeywordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    Keyword selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);
}
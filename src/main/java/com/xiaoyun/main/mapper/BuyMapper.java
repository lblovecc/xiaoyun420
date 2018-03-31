package com.xiaoyun.main.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Buy;
import com.xiaoyun.main.model.vo.BuyVO;

public interface BuyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Buy record);

    int insertSelective(Buy record);

    Buy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKey(Buy record);
    
    List<BuyVO> getBuyList(Map<String,Object> qryMap);
}
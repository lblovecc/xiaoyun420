package com.xiaoyun.main.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Supply;
import com.xiaoyun.main.model.vo.BrowseCountVO;
import com.xiaoyun.main.model.vo.SupplyVO;

public interface SupplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Supply record);

    int insertSelective(Supply record);

    Supply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Supply record);

    int updateByPrimaryKey(Supply record);
    
    List<SupplyVO> getSupplyList(Map<String,Object> qryMap);
    
    List<BrowseCountVO> getBrowseCountForSupply(List<SupplyVO> list);
    
    List<BrowseCountVO> getBrowseCountForBuy(List<SupplyVO> list);
}
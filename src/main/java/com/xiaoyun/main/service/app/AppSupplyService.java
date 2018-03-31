package com.xiaoyun.main.service.app;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.model.Supply;
import com.xiaoyun.main.model.vo.SupplyVO;
import com.xiaoyun.main.service.base.BaseService;

public interface AppSupplyService extends BaseService<Supply>{

	public List<SupplyVO> getSupplyList(Map<String,Object> qryMap,EasyUIPaginator paginator);
	
	public List<SupplyVO> getSupplyList(Map<String,Object> qryMap);
	
	public int addClickAndBrowse(Long supplyId,Long userId);
	
	public int addSupply(Supply supply,String[] tagIdArr);
	
	public int updateSupply(Supply supply,String[] tagIdArr);
	
}

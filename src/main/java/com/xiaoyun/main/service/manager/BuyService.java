package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.model.Buy;
import com.xiaoyun.main.model.vo.BuyVO;
import com.xiaoyun.main.service.base.BaseService;

public interface BuyService extends BaseService<Buy>{
	
	public List<BuyVO> getList(Map<String ,Object> qryMap,Paginator paginator);
	
	public int delete(long id);

}

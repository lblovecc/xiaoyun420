package com.xiaoyun.main.service.app;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.model.Buy;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.model.ViewChance;
import com.xiaoyun.main.model.vo.BuyVO;
import com.xiaoyun.main.service.base.BaseService;

public interface AppBuyService extends BaseService<Buy> {
	
	public List<BuyVO> getBuyList(Map<String,Object> qryMap,EasyUIPaginator paginator);
	
	public List<BuyVO> getBuyList(Map<String,Object> qryMap);
	
	public boolean checkCanView(Buy buy,User user,ViewChance selectViewChance);
	
	public int addBuy(Buy buy,String[] tagIdArr);
	
	public int updateBuy(Buy buy,String[] tagIdArr);

}

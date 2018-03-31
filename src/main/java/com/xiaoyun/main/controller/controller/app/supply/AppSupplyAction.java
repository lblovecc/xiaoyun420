package com.xiaoyun.main.controller.controller.app.supply;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Collect;
import com.xiaoyun.main.model.Supply;
import com.xiaoyun.main.model.vo.SupplyVO;
import com.xiaoyun.main.service.app.AppCollectService;
import com.xiaoyun.main.service.app.AppSupplyService;

/**
 * 
 * @author Mr.LB
 * 
 * 获取供应帖子的信息
 *
 */

@Controller
@RequestMapping({"/xiaochengxu"})
public class AppSupplyAction extends AbstractBaseController{
	
	@Autowired
	private AppSupplyService supplyService;
	
	@Autowired
	private AppCollectService collectionService;
	
	/**
	 * 获取供应帖子列表
	 * @param request
	 * @param response
	 * @param paginator
	 * @return
	 */
	@ResponseBody
	@RequestMapping({"/get_supply_list.do"})
	public JSONObject getGoodsInfo(HttpServletRequest request, HttpServletResponse response,EasyUIPaginator paginator){
		
		String keyword = request.getParameter("keyword");			//搜索框中的关键词
		Map<String,Object> qryMap = new HashMap<>();
		
		qryMap.put("keyword", keyword);
		
		List<SupplyVO> supplyList = supplyService.getSupplyList(qryMap, paginator);
		
		return queryListToAppJSONObject(supplyList);
	}
	
	/**
	 * 获取供应帖子详细信息
	 * @param supplyId
	 * @return
	 */
	@RequestMapping({"/get_supply_detail.do"})
	public JSONObject getSupplyDetailInfo(Long supplyId,Long userId){
		
		Map<String,Object> qryMap = new HashMap<>();
		
		qryMap.put("supplyId", supplyId);
		
		int m = supplyService.addClickAndBrowse(supplyId, userId);
		
		if(m==0){
			return getAppErrorJsonResult("1", "网络错误!");
		}else{
			List<SupplyVO> supplyList = supplyService.getSupplyList(qryMap);
			
			return getAppJsonResult(supplyList.get(0));
		}
	}
	
	/**
	 * 收藏供应帖子
	 * @param supplyId
	 * @param userId
	 * @return
	 */
	@RequestMapping({"/collect_supply.do"})
	public JSONObject collectSupply(Long supplyId,Long userId){
		
		Collect collection = new Collect();
		
		collection.setSupplyid(supplyId);
		collection.setUserid(userId);
		collection.setCollecttype("supply");
		
		Collect selectCollection = collectionService.selectOne(collection);
		
		if(null != selectCollection){
			
			return getAppErrorJsonResult("1", "您已收藏该帖子,不可重复收藏!");
			
		}else{
			
			Date now = new Date();
			collection.setCreatetime(now);
			collection.setUpdatetime(now);
			
			collectionService.save(collection);
		}
		
		return getAppJsonResult();
	}
	
	/**
	 * 转发供应帖子
	 * @param supplyId
	 * @param userId
	 * @return
	 */
	@RequestMapping({"/forward_supply.do"})
	public JSONObject forwardSupply(Long supplyId,Long userId){
		
		return getAppJsonResult();
	}
	
	/**
	 * 添加供应的帖子
	 * @param supply
	 * @return
	 */
	@RequestMapping({"/add_supply.do"})
	public JSONObject addSupply(Supply supply){
		
		if(null == supply.getCategoryid1()){
			return getAppErrorJsonResult("1", "一级类目未选择");
		}
		
		if(null == supply.getCategoryid2()){
			return getAppErrorJsonResult("1", "二级类目未选择");
		}
		
		String title = supply.getTitle();
		if(null == title || title.equals("")){
			return getAppErrorJsonResult("1", "帖子标题未填写");
		}
		
		String detile = supply.getDetile();
		if(null == detile || detile.equals("")){
			return getAppErrorJsonResult("1", "帖子详细说明未填写");
		}
		
		Integer price= supply.getPrice();
		if(null == price){
			return getAppErrorJsonResult("1", "价格未填写");
		}
		
		String pictureUrls = supply.getPictureurls();
		if(null == pictureUrls || pictureUrls.equals("")){
			return getAppErrorJsonResult("1", "未添加图片");
		}
		
		Long userId = supply.getUserid();
		if(null == userId){
			return getAppErrorJsonResult("1", "帖子发布人未知");
		}
		
		String tagIds = supply.getTagids();
		if(null == tagIds || tagIds.equals("")){
			return getAppErrorJsonResult("1", "未选择标签");
		}
		
		String[] tagIdArr = tagIds.split(",");
		
		int m = supplyService.addSupply(supply, tagIdArr);
		
		if(m==0){
			return getAppErrorJsonResult("1", "帖子发布失败");
		}else{
			return getAppJsonResult("帖子发布成功!");
		}
	}

}

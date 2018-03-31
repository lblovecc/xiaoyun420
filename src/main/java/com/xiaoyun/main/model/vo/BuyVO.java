package com.xiaoyun.main.model.vo;

import java.util.Date;

/**
 * 
 * @author Mr.LB
 *
 */
public class BuyVO {
	
	private Long buyId;		//姹傝喘鐨勫笘瀛恑d
	
	private Long categoryId1;	//涓�绾х被鐩甶d
	
	private Long categoryId2;	//浜岀骇绫荤洰id
	
	private String categoryName1;//涓�绾х被鐩悕绉�
	
	private String categoryName2;//浜岀骇绫荤洰鍚嶇О
	
	private Integer browseCount;  //娴忚娆℃暟
	
	private String title;		
	
	private String detile;
	
	private String unit;		//瑙勬牸
	
	private Integer count;		//姹傝喘鏁伴噺
	
	private Long userId;		//
	
	private String tagIds;		//鏍囩id鐨勯泦鍚�
	
	private String status;		//甯栧瓙鐨勭姸鎬�
	
	private Integer clicks;		//甯栧瓙鐐瑰嚮閲�
	
	private Date createTime;	//
	
	private Date updateTime;
	
	private Long managerId;		
	
	private String userName;	//鍙戝竷浜哄鍚�
	
	private String phone;		//鍙戝竷浜烘墜鏈哄彿鐮�
	
	private String headImgUrl;	//鍙戝竷浜哄ご鍍�
	
	private String isUpLoad;	//甯栧瓙鏄惁浼樺厛		1:鏄剧ず浼樺厛  0:涓嶆樉绀轰紭鍏�
	
	public String getIsUrgency() {
		return isUrgency;
	}

	public void setIsUrgency(String isUrgency) {
		this.isUrgency = isUrgency;
	}

	private String isUrgency;	//鏄惁绱ф��   show:鏄剧ず绱ф��    none:涓嶆樉绀虹揣鎬�
	
	private String isHot;		//鏄惁鐑棬   show:鏄剧ず鐑棬     none:涓嶆樉绀虹儹闂�
	
	public String getIsHot() {
		return isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public Long getBuyId() {
		return buyId;
	}

	public void setBuyId(Long buyId) {
		this.buyId = buyId;
	}

	public Long getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(Long categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public Long getCategoryId2() {
		return categoryId2;
	}

	public void setCategoryId2(Long categoryId2) {
		this.categoryId2 = categoryId2;
	}

	public String getCategoryName1() {
		return categoryName1;
	}

	public void setCategoryName1(String categoryName1) {
		this.categoryName1 = categoryName1;
	}

	public String getCategoryName2() {
		return categoryName2;
	}

	public void setCategoryName2(String categoryName2) {
		this.categoryName2 = categoryName2;
	}

	public Integer getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetile() {
		return detile;
	}

	public void setDetile(String detile) {
		this.detile = detile;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getIsUpLoad() {
		return isUpLoad;
	}

	public void setIsUpLoad(String isUpLoad) {
		this.isUpLoad = isUpLoad;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTagNames() {
		return tagNames;
	}

	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	private String province;	//鐪�
	
	private String city;		//甯�
	
	private String area;		//鍖�
	
	private String tagNames;	//鏍囩鐨勫悕绉伴泦鍚�
	
	private Date endTime;		//鎴鏃堕棿

}

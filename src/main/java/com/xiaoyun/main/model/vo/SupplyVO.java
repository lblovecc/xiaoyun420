package com.xiaoyun.main.model.vo;

import java.util.Date;

/**
 * 
 * @author Mr.LB
 *
 */
public class SupplyVO {

	private Long supplyId;		//id
	
	private Long categoryId1;	//一级类目id
	
	private Long categoryId2;	//2级类目id
	
	private String categoryName1;//一级类目名称
	
	private String categoryName2;//2级类目名称
	
	private Integer browseCount;  //浏览次数
	
	private String type;		//类型   默认为supply
	
	public Integer getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
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

	private String title;		
	
	private String detile;
	
	private Integer price;		//价格
	
	private String pictureUrls;	//甯栧瓙鍥剧墖闆嗗悎,涓棿鐢ㄩ�楀彿闅斿紑
	
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
	
	private String province;	//鐪�
	
	private String city;		//甯�
	
	private String area;		//鍖�
	
	private String tagNames;	//鏍囩鐨勫悕绉伴泦鍚�
	
	public String getTagNames() {
		return tagNames;
	}

	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}

	public Long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPictureUrls() {
		return pictureUrls;
	}

	public void setPictureUrls(String pictureUrls) {
		this.pictureUrls = pictureUrls;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	private String detail;		//璇︾粏鍦板潃

}

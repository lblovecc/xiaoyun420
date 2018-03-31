package com.xiaoyun.main.model;

import java.util.Date;

public class User {
    private Long id;

    private String name;

    private String openid;

    private String phone;

    private Long addressid;

    private String status;
    
    private String businessLicense;			//钀ヤ笟鎵х収鍥剧墖璺緞
    
    private String isUpLoad;				//鏄惁涓婁紶浜嗚惀涓氭墽鐓�         1:宸蹭笂浼�(甯栧瓙浼樺厛鏄剧ず)   0:鏈笂浼�
    
    private String iscomplete;				//鐢ㄦ埛淇℃伅鏄惁瀹屽杽   1:宸插畬鍠�   0:鏈畬鍠�
    
    private String companyname;				//鍏徃鍚嶇О

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getIscomplete() {
		return iscomplete;
	}

	public void setIscomplete(String iscomplete) {
		this.iscomplete = iscomplete;
	}

	public String getIsUpLoad() {
		return isUpLoad;
	}

	public void setIsUpLoad(String isUpLoad) {
		this.isUpLoad = isUpLoad;
	}

	private String unionid;

    private String nickname;

    private String sex;

    private String province;

    private String city;

    private String country;

    private String detail;

    private String language;

    private String headimgurl;

    private Date createtime;

    private Date updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getAddressid() {
        return addressid;
    }

    public void setAddressid(Long addressid) {
        this.addressid = addressid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
    
    public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
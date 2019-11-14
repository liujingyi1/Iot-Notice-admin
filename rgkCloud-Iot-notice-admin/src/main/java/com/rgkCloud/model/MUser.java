package com.rgkCloud.model;

/**
 * 系统登录账号
 *
 */
public class MUser{

	private String id;

	// 用户名
	private String username;
	
	private Integer sex=0;
	
//	private String idCard;

	private String password;

	// 公司名称
	private String company;
	
	//园区
	private String vId;

	// 邮件
	private String email;
	
	private Integer age;

	// 电话
	private String phone;

//	private List<MRole> mRoles;

	// 状态： 0：禁用   1：启用
//	private Integer status = 1;
	
	
//	private String picUrl;
//
//	public Date createdDate;
//
//	public Date modifiedDate;
//
//	public String modifiedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public Date getModifiedDate() {
//		return modifiedDate;
//	}
//
//	public void setModifiedDate(Date modifiedDate) {
//		this.modifiedDate = modifiedDate;
//	}
//
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}

//	public List<MRole> getmRoles() {
//		return mRoles;
//	}
//
//	public void setmRoles(List<MRole> mRoles) {
//		this.mRoles = mRoles;
//	}
//
//	public Integer getStatus() {
//		return status;
//	}
//
//	public void setStatus(Integer status) {
//		this.status = status;
//	}


	public String getvId() {
		return vId;
	}
	public void setvId(String vId) {
		this.vId = vId;
	}
	

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

//	public String getIdCard() {
//		return idCard;
//	}
//
//	public void setIdCard(String idCard) {
//		this.idCard = idCard;
//	}
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
//	public String getPicUrl() {
//		return picUrl;
//	}
//
//	public void setPicUrl(String picUrl) {
//		this.picUrl = picUrl;
//	}

}

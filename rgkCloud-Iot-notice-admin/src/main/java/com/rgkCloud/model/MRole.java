package com.rgkCloud.model;


import java.io.Serializable;
import java.util.List;


/**
 * 	角色
 *
 */
public class MRole implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	// 角色名称
	private String name;
	// 父级ID
//	private String parentId;
	// 描述
	private String descInfo;
	// 权限标识
	private String permission;
	// 状态：0：停用 1：启用
	private Integer status = 1;
	
	private List<MRight> right;

	
//	public Date createdDate;
//
//	public String createdBy;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

//	public Date getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
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



	public String getDescInfo() {
		return descInfo;
	}

	public void setDescInfo(String descInfo) {
		this.descInfo = descInfo;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<MRight> getRight() {
		return right;
	}

	public void setRight(List<MRight> right) {
		this.right = right;
	}

	

}

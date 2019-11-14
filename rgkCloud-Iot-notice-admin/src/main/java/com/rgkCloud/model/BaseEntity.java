package com.rgkCloud.model;

import java.io.Serializable;


public abstract class BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	private String createdBy;
	
	private String createdDate ;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	
	
	

}

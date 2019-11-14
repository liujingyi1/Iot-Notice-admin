package com.rgkCloud.model;

import java.io.Serializable;


/**
 * 维修等级
 *
 */
public class RLevel extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	// 等级名
	private String lvName;
	// 等级值
	private Integer lvValue;

	// 描述
	private String descInfo;
	
	private String villageId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLvName() {
		return lvName;
	}

	public void setLvName(String lvName) {
		this.lvName = lvName;
	}

	public Integer getLvValue() {
		return lvValue;
	}

	public void setLvValue(Integer lvValue) {
		this.lvValue = lvValue;
	}

	public String getDescInfo() {
		return descInfo;
	}

	public void setDescInfo(String descInfo) {
		this.descInfo = descInfo;
	}

	public String getVillageId() {
		return villageId;
	}

	public void setVillageId(String villageId) {
		this.villageId = villageId;
	}

	
	

}

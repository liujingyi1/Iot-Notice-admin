package com.rgkCloud.model;


public class Notice{
	
	private String id;
	
	//标题
	private String title;
	
	// 公告类型 1:图片 2：文字  3:url
	private Integer type;

	// 2类:文字内容  1类:图片URL，以英文逗号相隔  
	private String content;
	
	// 状态 1：上线 0：下线
	private Integer state;
	
	private String vId;
	//	开始时间
	private String startTime;
	//	结束时间
	private String endTime;
	

	private String createdDate;
	
	private String createdBy;
	

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(String vId) {
		super();
		this.vId = vId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	
	

}

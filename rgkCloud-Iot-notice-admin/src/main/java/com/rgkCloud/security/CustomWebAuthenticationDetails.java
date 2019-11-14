package com.rgkCloud.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
/**
 *  WebAuthenticationDetails:该类提供了获取用户登录时携带的额外信息的功能，默认提供了 remoteAddress 与 sessionId 信息。
 *
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
	private static final long serialVersionUID = 1L;
	
	private String villageId;
	
	// 将form 表单中的 verifyCode 获取到，并通过 get 方法方便被调用
	public CustomWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
	}
	
	public String getVillageId() {
		return villageId;
	}

	public void setVillageId(String villageId) {
		this.villageId = villageId;
	}


	

	
}

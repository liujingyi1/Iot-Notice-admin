package com.rgkCloud.security;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
/**
   *   该接口用于在Spring Security登录过程中对用户的登录信息的详细信息进行填充
 *
 */
@Component
public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest request) {
		return new CustomWebAuthenticationDetails(request);
	}

}

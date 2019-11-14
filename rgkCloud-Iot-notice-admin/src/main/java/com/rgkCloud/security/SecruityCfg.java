package com.rgkCloud.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.rgkCloud.utils.EnvironmentUtils;

@EnableOAuth2Sso
@Configuration
public class SecruityCfg extends WebSecurityConfigurerAdapter{
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private EnvironmentUtils environmentUtils;
	
	@Value("${login.url}")
	private String loginUrl;
	
	@Value("${logout.url}")
	private String logoutUrl;
	
	protected void configure(HttpSecurity http) throws Exception {
		log.info("------security configure-----");
		String profile = environmentUtils.getActiveProfile();
		log.info("profile : "+profile);
		
		if ("local".equals(profile)) {
			http.authorizeRequests().anyRequest().permitAll();
		}
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/", "/login","/resources/**","/actuator/**","/css/**", "/js/**", "/tjs/**", "/fonts/**", "/img/**", "/i/**","/webfonts/**").permitAll()
		    //其他地址的访问均需要登录认证
			.anyRequest().authenticated()
//			.and().formLogin().loginPage(loginUrl)
			.and().logout().logoutSuccessUrl(logoutUrl);
	}
	
	
}

package com.rgkCloud.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
	private static final long serialVersionUID = 1L;
	
	private String vId;

	public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String vId) {
		super(username, password, authorities);
		this.vId = vId;
	}

	

}

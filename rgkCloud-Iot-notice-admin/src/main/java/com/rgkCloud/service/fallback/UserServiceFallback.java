package com.rgkCloud.service.fallback;

import org.springframework.stereotype.Component;

import com.rgkCloud.model.MUser;
import com.rgkCloud.service.IUserService;
@Component
public class UserServiceFallback implements IUserService{

	@Override
	public MUser getUserByName(String userName) {
		
		return null;
	}

}

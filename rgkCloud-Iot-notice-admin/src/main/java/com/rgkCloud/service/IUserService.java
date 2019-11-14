package com.rgkCloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgkCloud.model.MUser;
import com.rgkCloud.service.fallback.UserServiceFallback;

@FeignClient(value="rgkCloud-Iot-admin",fallback=UserServiceFallback.class)
public interface IUserService {
	
	@GetMapping("/user/name")
	MUser getUserByName(@RequestParam("userName")String userName);

}

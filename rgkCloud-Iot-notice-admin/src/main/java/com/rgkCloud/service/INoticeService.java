package com.rgkCloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgkCloud.model.Notice;
import com.rgkCloud.service.fallback.NoticeServiceFallback;
import com.rgkCloud.vo.JGridPage;
import com.rgkCloud.vo.ReturnObject;

@FeignClient(name = "rgkCloud-Iot-notice-service", fallback = NoticeServiceFallback.class)
public interface INoticeService {

	@PostMapping("/notice/save")
	ReturnObject save(@RequestBody Notice notice, @RequestParam("phones") String phones);

	@DeleteMapping("/notice/delete")
	ReturnObject delete(@RequestParam("id") String id);

	@GetMapping("/notice/list")
	JGridPage<Notice> findByPage(@RequestParam(value = "page") Integer page, 
								@RequestParam(value = "rows") Integer rows,
								@RequestParam(value = "sidx") String sidx, 
								@RequestParam(value = "sord") String sord,
								@RequestParam(value = "villageId") String villageId);

	@DeleteMapping("/notice/deleteBatch")
	ReturnObject deleteBatch(@RequestParam("ids") String ids);

	@PostMapping(value = "/notice/save")
	ReturnObject save(@RequestBody Notice notice, 
					@RequestParam(value = "targetType") Integer targetType,
					@RequestParam(value = "acceptorType", required = false, defaultValue="1") Integer acceptorType,
					@RequestParam(value = "target[]", required = false) String[] target);

	@GetMapping("/notice/target")
	ReturnObject loadTarget(@RequestParam("targetType") Integer targetType,
							@RequestParam("villageId") String villageId);

}

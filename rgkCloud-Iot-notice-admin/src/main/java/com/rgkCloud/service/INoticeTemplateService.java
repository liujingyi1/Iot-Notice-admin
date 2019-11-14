package com.rgkCloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgkCloud.model.NoticeTemplate;
import com.rgkCloud.service.fallback.NoticeTemplateServiceFallback;
import com.rgkCloud.vo.JGridPage;
import com.rgkCloud.vo.ReturnObject;

@FeignClient(name = "rgkCloud-Iot-notice-service", fallback = NoticeTemplateServiceFallback.class)
public interface INoticeTemplateService {

	@PostMapping("/nt/save")
	ReturnObject save(NoticeTemplate noticeTemplate);

	@DeleteMapping("/nt/deleteBatch")
	ReturnObject deleteBatch(@RequestParam("ids") String ids);

	@DeleteMapping("/nt/delete")
	ReturnObject delete(@RequestParam("id") String id);

	@GetMapping("/nt/list")
	JGridPage<NoticeTemplate> findByPage(@RequestParam("page") Integer page, 
										@RequestParam("rows") Integer rows,
										@RequestParam("sidx") String sidx, 
										@RequestParam("sord") String sord,
										@RequestParam("villageId") String villageId);

	@GetMapping("/nt/all")
	ReturnObject findAll(@RequestParam("villageId") String villageId);

}

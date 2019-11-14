package com.rgkCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgkCloud.model.NoticeTemplate;
import com.rgkCloud.service.INoticeTemplateService;
import com.rgkCloud.vo.JGridPage;
import com.rgkCloud.vo.ReturnObject;

@RestController
@RequestMapping("/nt")
public class NoticeTemplateController extends BaseController {
	@Autowired
	private INoticeTemplateService noticeTemplateService; 
	
	@RequestMapping("/save")
	public ReturnObject save(NoticeTemplate noticeTemplate) {
		String vId = villageId();
		noticeTemplate.setvId(vId);
		return noticeTemplateService.save(noticeTemplate);
	}
	
	@RequestMapping("/delete")
	public ReturnObject delete(String id) {
		return noticeTemplateService.delete(id);
	}
	
	@RequestMapping("/deleteBatch")
	public ReturnObject deleteBatch(String ids) {
		return noticeTemplateService.deleteBatch(ids);
	}
	
	@RequestMapping("/list")
	public JGridPage<NoticeTemplate> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "createdDate") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
		String vId = villageId();
		return noticeTemplateService.findByPage(page, rows, sidx, sord, vId);
	}
	
	@RequestMapping("/all")
	public ReturnObject findAll() {
		String vId = villageId();
		return noticeTemplateService.findAll(vId);
	}

}

package com.rgkCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgkCloud.model.RLevel;
import com.rgkCloud.service.ILevelService;
import com.rgkCloud.vo.JGridPage;
import com.rgkCloud.vo.ReturnObject;
/**
 * 维修等级
 *
 */
@RestController
@RequestMapping("/level")
public class LevelController extends BaseController {
	@Autowired
	private ILevelService levelService;
	
	@RequestMapping("/save")
	public ReturnObject save(RLevel level) {
		String vId = villageId();
		level.setVillageId(vId);
		return levelService.save(level);
	}
	
	@RequestMapping("/delete")
	public ReturnObject delete(String id) {
		return levelService.delete(id);
	}
	@RequestMapping("/deleteBatch")
	public ReturnObject deleteBatch(String id) {
		return levelService.deleteBatch(id);
	}
	
	@RequestMapping("/list")
	public JGridPage<RLevel> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "createdDate") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
    	String vId = villageId();
		return levelService.findByPage(page, rows, sidx, sord, vId);
	}
	
	@RequestMapping("/all")
	public ReturnObject findAll() {
		String vId = villageId();
		return levelService.findAll(vId);
	}

}

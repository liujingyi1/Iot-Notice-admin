package com.rgkCloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgkCloud.model.RLevel;
import com.rgkCloud.service.fallback.LevelServiceFallback;
import com.rgkCloud.vo.JGridPage;
import com.rgkCloud.vo.ReturnObject;

@FeignClient(name = "rgkCloud-Iot-notice-service", fallback = LevelServiceFallback.class)
public interface ILevelService {
	/**
	 * 创建
	 * 
	 * @param level
	 * @return
	 */
	@PostMapping("/nlevel/save")
	ReturnObject save(@RequestBody RLevel level);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/nlevel/delete")
	ReturnObject delete(@RequestParam("id") String id);

	/**
	 * 分页查询
	 * 
	 * @param i
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @return
	 */
	@GetMapping("/nlevel/list")
	JGridPage<RLevel> findByPage(@RequestParam("page") int page, 
			                     @RequestParam("rows") Integer rows,
			                     @RequestParam("sidx") String sidx, 
			                     @RequestParam("sord") String sord, 
			                     @RequestParam("villageId")String villageId);

	/**
	 * @return
	 */
	@GetMapping("/nlevel/all")
	ReturnObject findAll(String villageId);

	/**
	 * 批量删除
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/nlevel/deleteBatch")
	ReturnObject deleteBatch(String id);

}

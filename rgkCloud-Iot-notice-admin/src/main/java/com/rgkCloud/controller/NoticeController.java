package com.rgkCloud.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.rgkCloud.model.Notice;
import com.rgkCloud.service.IFileService;
import com.rgkCloud.service.INoticeService;
import com.rgkCloud.vo.JGridPage;
import com.rgkCloud.vo.ReturnObject;

@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController {
	@Autowired
	private INoticeService noticeService;
	
	@Autowired
	private IFileService fileService;
	
	/**
	 * 发布公告
	 * @param notice		公告
	 * @param targetType	目标范围：园区、楼栋
	 * @param target		指定最终目标唯一识别号，如手机号、设备识别码等
	 * @param acceptorType	目标种类
	 * @param files			图片等文件
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	public ReturnObject createNotice(Notice notice,
									Integer targetType,
									@RequestParam(value="target[]",required=false)String[] target,
									@RequestParam(value = "acceptorType", required = false, defaultValue="1") Integer acceptorType,
									@RequestPart(value = "files", required = false) MultipartFile[] files,
									HttpServletRequest request) {
    	String vId = villageId();
		notice.setvId(vId);
		if (notice.getType()== 1 && files != null && files.length > 0) {
			String picUrl = fileService.uploadFile(files, request);
			notice.setContent(picUrl);
		}
		log.info(JSON.toJSONString(notice));
		return noticeService.save(notice, targetType, acceptorType, target);
	}
	
	/**
	 * Delete
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public ReturnObject delete(String id) {
		return noticeService.delete(id);
	}
	
	@RequestMapping("/deleteBatch")
	public ReturnObject deleteBatch(String ids) {
		return noticeService.deleteBatch(ids);
	}
	
	/**
	 * 	分页查询
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @param session
	 * @return
	 */
	@RequestMapping("/list")
	public JGridPage<Notice> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "createdDate") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
		String vId = villageId();
		return noticeService.findByPage(page, rows, sidx, sord, vId);
	}
	
	/**
	 * 	加载目标信息:楼栋/手机
	 * @param targetType
	 * @param session
	 * @return
	 */
	@RequestMapping("/target")
	public ReturnObject loadTarget(@RequestParam(defaultValue="1")Integer targetType) {
		String vId = villageId();
		return noticeService.loadTarget(targetType, vId);
	}
	

}

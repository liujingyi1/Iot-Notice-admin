package com.rgkCloud.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;



public interface IFileService {
	/**
	 * 文件上传
	 * @param files
	 * @return
	 */
	public String uploadFile(MultipartFile[] files, HttpServletRequest request);

}

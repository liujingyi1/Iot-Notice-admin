package com.rgkCloud.service.impl;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rgkCloud.service.IFileService;

@Service
public class FileServiceImpl implements IFileService {
	private Log log = LogFactory.getLog(getClass());
	
	@Value("${file.pic.path}")
	private String picPath;
	
	
	@Override
	public String uploadFile(MultipartFile[] files, HttpServletRequest request) {
		return uploadPics(files, request);
	}
	
	private String uploadPics(MultipartFile[] files, HttpServletRequest request) {
		// 文件存放路径
		StringBuffer sBuffer = new StringBuffer();
		String dirPath = request.getServletContext().getRealPath(picPath);
		log.info("dirPath : "+dirPath);
		
		for (MultipartFile cmf : files) {
			log.info(cmf.getOriginalFilename());
			File picDir = new File(dirPath);
			if (!picDir.exists()) {
				picDir.mkdirs();
			}

			try {
				String fileName = cmf.getOriginalFilename();
				File file = new File(dirPath + fileName);
				FileUtils.copyInputStreamToFile(cmf.getInputStream(), file);
				sBuffer.append(picPath).append(fileName).append(",");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return StringUtils.substringBeforeLast(sBuffer.toString(),",");
	}

}

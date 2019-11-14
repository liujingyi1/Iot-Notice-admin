package com.rgkCloud.service.fallback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.rgkCloud.model.NoticeTemplate;
import com.rgkCloud.service.INoticeTemplateService;
import com.rgkCloud.vo.JGridPage;
import com.rgkCloud.vo.ReturnObject;
@Component
public class NoticeTemplateServiceFallback implements INoticeTemplateService {

	@Override
	public ReturnObject save(NoticeTemplate noticeTemplate) {
		// TODO Auto-generated method stub
		return new ReturnObject(0,null,"fail");
	}

	@Override
	public ReturnObject deleteBatch(String ids) {
		// TODO Auto-generated method stub
		return new ReturnObject(0,null,"fail");
	}

	@Override
	public ReturnObject delete(String id) {
		// TODO Auto-generated method stub
		return new ReturnObject(0,null,"fail");
	}

	@Override
	public JGridPage<NoticeTemplate> findByPage(Integer page, Integer rows, String sidx, String sord, String vId) {
		Page<NoticeTemplate> nts = new PageImpl<NoticeTemplate>(null);
		return new JGridPage<NoticeTemplate>(nts);
	}

	@Override
	public ReturnObject findAll(String vId) {
		// TODO Auto-generated method stub
		return new ReturnObject(1, null, null);
	}

}

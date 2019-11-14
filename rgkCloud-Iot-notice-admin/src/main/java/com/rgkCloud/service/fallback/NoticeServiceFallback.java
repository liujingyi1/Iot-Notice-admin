package com.rgkCloud.service.fallback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.rgkCloud.model.Notice;
import com.rgkCloud.service.INoticeService;
import com.rgkCloud.vo.JGridPage;
import com.rgkCloud.vo.ReturnObject;
@Component
public class NoticeServiceFallback implements INoticeService {

	@Override
	public ReturnObject save(Notice notice, String phones) {
		// TODO Auto-generated method stub
		return new ReturnObject(0,null,"fail");
	}

	@Override
	public ReturnObject delete(String id) {
		// TODO Auto-generated method stub
		return new ReturnObject(0,null,"fail");
	}

	@Override
	public JGridPage<Notice> findByPage(Integer page, Integer rows, String sidx, String sord, String vId) {
		Page<Notice> notice = new PageImpl<Notice>(null);
		return new JGridPage<Notice>(notice);
	}

	@Override
	public ReturnObject deleteBatch(String ids) {
		// TODO Auto-generated method stub
		return new ReturnObject(0,null,"fail");
	}

	@Override
	public ReturnObject save(Notice notice, Integer targetType, Integer acceptorType, String[] target) {
		// TODO Auto-generated method stub
		return new ReturnObject(0,null,"fail");
	}

	@Override
	public ReturnObject loadTarget(Integer targetType, String vId) {
		// TODO Auto-generated method stub
		return new ReturnObject(1,null,null);
	}

}

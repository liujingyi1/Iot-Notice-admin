package com.rgkCloud.service.fallback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.rgkCloud.model.RLevel;
import com.rgkCloud.service.ILevelService;
import com.rgkCloud.vo.JGridPage;
import com.rgkCloud.vo.ReturnObject;
@Component
public class LevelServiceFallback implements ILevelService {

	@Override
	public ReturnObject save(RLevel level) {
		return new ReturnObject(0,null,"fail");
	}

	@Override
	public ReturnObject delete(String id) {
		return new ReturnObject(0,null,"fail");
	}

	@Override
	public JGridPage<RLevel> findByPage(int page, Integer rows, String sidx, String sord, String villageId) {
		Page<RLevel> levels = new PageImpl<RLevel>(null);
		return new JGridPage<>(levels);
	}

	@Override
	public ReturnObject findAll(String villageId) {
		// TODO Auto-generated method stub
		return new ReturnObject(1, null, null);
	}

	@Override
	public ReturnObject deleteBatch(String id) {
		// TODO Auto-generated method stub
		return new ReturnObject(0,null,"fail");
	}

}

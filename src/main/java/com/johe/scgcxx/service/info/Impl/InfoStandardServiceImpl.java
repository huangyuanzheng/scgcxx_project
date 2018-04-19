package com.johe.scgcxx.service.info.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.info.InfoStandardDao;
import com.johe.scgcxx.dto.StandardDto;
import com.johe.scgcxx.model.Standard;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.info.InfoStandardService;

@Service
public class InfoStandardServiceImpl implements InfoStandardService{
	
	private InfoStandardDao infoStandardDao;
	@Autowired
	public void setInfoStandardDao(InfoStandardDao infoStandardDao){
		this.infoStandardDao = infoStandardDao;
	}

	@Override
	public Page toGetList(StandardDto dto) {
		return EngineValue.squsel(infoStandardDao, dto);
	}

	@Override
	public void toAdd(StandardDto dto) {
		infoStandardDao.insertStandard(dto);
	}

	@Override
	public Standard toGet(StandardDto dto) {
		return infoStandardDao.getStandard(dto);
	}

	@Override
	public boolean toAlter(StandardDto dto) {
		if(infoStandardDao.alterStandard(dto) != 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void toDelete(StandardDto dto) {
		infoStandardDao.deleteStandard(dto);
	}

	@Override
	public Standard toGetId() {
		return infoStandardDao.getId();
	}


}

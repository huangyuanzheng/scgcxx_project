package com.johe.scgcxx.service.info.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.info.InfoColorDao;
import com.johe.scgcxx.dto.ColorDto;
import com.johe.scgcxx.model.Color;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.info.InfoColorService;

@Service
public class InfoColorServiceImpl implements InfoColorService{
	
	private InfoColorDao infoColorDao;
	
	@Autowired
	public void setInfoColorDao(InfoColorDao infoColorDao){
		this.infoColorDao = infoColorDao;
	}
	
	@Override
	public Page toGetList(ColorDto dto) {
		return EngineValue.squsel(infoColorDao, dto);
	}

	@Override
	public void toAdd(ColorDto dto) {
		infoColorDao.insertColor(dto);
	}

	@Override
	public Color toGet(ColorDto dto) {
		return infoColorDao.getColor(dto);
	}

	@Override
	public boolean toAlter(ColorDto dto) {
		if(infoColorDao.alterColor(dto) != 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void toDelete(ColorDto dto) {
		infoColorDao.deleteColor(dto);
	}

	@Override
	public Color toGetId() {
		return infoColorDao.GetId();
	}
	
}

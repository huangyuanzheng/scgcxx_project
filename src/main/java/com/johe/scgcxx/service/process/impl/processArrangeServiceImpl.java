package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessArrangeDao;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessArrangeService;

@Service
public class processArrangeServiceImpl implements ProcessArrangeService{

	private ProcessArrangeDao processArrangeDao;
	
	@Autowired
	public void setProcessArrangeDao(ProcessArrangeDao processArrangeDao){
		this.processArrangeDao = processArrangeDao;
	}
	
	@Override
	public Page toGetArrangeList(ProcessDto dto) {
		return EngineValue.squsel(processArrangeDao, dto);
	}

	@Override
	public Process toGetArrange(ProcessDto dto) {
		return processArrangeDao.getArrange(dto);
	}

	@Override
	public boolean doArrange(ProcessDto dto) {
		if(processArrangeDao.doArrange(dto) > 0){
			return true;
		}else{
			return false;
		}
	}

}

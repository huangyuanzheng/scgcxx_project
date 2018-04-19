package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessRanseDao;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessRanseService;

@Service
public class ProcessRanseServiceImpl implements ProcessRanseService{

	private ProcessRanseDao processRanseDao;
	
	@Autowired
	public void setProcessRanseDao(ProcessRanseDao processRanseDao){
		this.processRanseDao = processRanseDao;
	}
	
	@Override
	public Page toGetRanseList(ProcessDto dto) {
		return EngineValue.squsel(processRanseDao, dto);
	}

	@Override
	public Process toGetRanse(ProcessDto dto) {
		return processRanseDao.getRanse(dto);
	}

	@Override
	public boolean doRanse(ProcessDto dto) {
		if(processRanseDao.doRanse(dto) > 0){
			return true;
		}else{
			return false;
		}
	}

}

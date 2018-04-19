package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessPrintdyeDao;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessPrintdyeService;

@Service
public class ProcessPrintdyeServiceImpl implements ProcessPrintdyeService{
	
	private ProcessPrintdyeDao processPrintdyeDao;
	
	@Autowired
	public void setProcessPrintdyeDao(ProcessPrintdyeDao processPrintdyeDao){
		this.processPrintdyeDao = processPrintdyeDao;
	}

	@Override
	public Page toGetPrintdyeList(ProcessDto dto) {
		return EngineValue.squsel(processPrintdyeDao, dto);
	}

	@Override
	public Process toGetPrintdye(ProcessDto dto) {
		return processPrintdyeDao.getPrintdye(dto);
	}

	@Override
	public boolean doPrintdye(ProcessDto dto) {
		if(processPrintdyeDao.doPrintdye(dto) > 0){
			return true;
		}else{
			return false;
		}
	}

}

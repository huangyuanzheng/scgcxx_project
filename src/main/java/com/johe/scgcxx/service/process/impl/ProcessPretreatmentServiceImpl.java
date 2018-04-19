package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessPretreatmentDao;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessPretreatmentService;
import com.johe.scgcxx.model.Process;

@Service
public class ProcessPretreatmentServiceImpl implements ProcessPretreatmentService{
	
	private ProcessPretreatmentDao processPretreatmentDao;
	
	@Autowired
	public void setProcessPretreatmentDao(ProcessPretreatmentDao processPretreatmentDao){
		this.processPretreatmentDao = processPretreatmentDao;
	}
	
	@Override
	public Page toGetPretreatmentList(ProcessDto dto) {
		return EngineValue.squsel(processPretreatmentDao, dto);
	}

	@Override
	public Process toGetPretreatment(ProcessDto dto) {
		return processPretreatmentDao.getPretreatment(dto);
	}

	@Override
	public Boolean tofinishPretreatment(ProcessDto dto) {
		if(processPretreatmentDao.finishPretreatment(dto) > 0){
			return true;
		}else{
			return false;
		}
	}

}

package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessGetPlansDao;
import com.johe.scgcxx.dto.PlanDto;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessGetPlansService;
@Service
public class ProcessGetPlansServiceImpl implements ProcessGetPlansService{

	private ProcessGetPlansDao processGetPlansDao;
	
	@Autowired
	public void setProcessGetPlansDao(ProcessGetPlansDao processGetPlansDao){
		this.processGetPlansDao = processGetPlansDao;
	}
	
	@Override
	public Page toGetPlanList(PlanDto dto) {
		return EngineValue.squsel(processGetPlansDao, dto);
	}

	@Override
	public Plan toGetPlan(PlanDto dto) {
		return processGetPlansDao.getPlan(dto);
	}

	@Override
	public Process toGetProcessGroupId() {
		return processGetPlansDao.getProcessGroupId();
	}

}

package com.johe.scgcxx.service.process.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessRawclothDao;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessRawclothService;
import com.johe.scgcxx.model.Process;
@Service
public class ProcessRawclothServiceImpl implements ProcessRawclothService{

	private ProcessRawclothDao processRawclothDao;
	
	@Autowired
	public void setProcessRawclothDao(ProcessRawclothDao processRawclothDao){
		this.processRawclothDao = processRawclothDao;
	}

	@Override
	public Page toGetProcessList(ProcessDto dto) {
		return EngineValue.squsel(processRawclothDao, dto);
	}

	@Override
	public List<Plan> toGetPlanList() {
		return processRawclothDao.getAllPlans();
	}

	@Override
	public void toGroupPlan(ProcessDto dto) {
		processRawclothDao.GroupPlan(dto);
	}

	@Override
	public boolean toAssignProcess(ProcessDto dto) {
		if(processRawclothDao.AssignProcess(dto) > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Process toGetProcess(ProcessDto dto) {
		return processRawclothDao.GetProcess(dto);
	}

	@Override
	public boolean toAlterProcess(ProcessDto dto) {
		if(processRawclothDao.AlterProcess(dto) > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void toDeleteProcess(ProcessDto dto) {
		processRawclothDao.DeleteProcess(dto);
	}


}

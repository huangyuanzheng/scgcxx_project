package com.johe.scgcxx.service.plan.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.plan.PlanManageDao;
import com.johe.scgcxx.dto.PlanDto;
import com.johe.scgcxx.model.Color;
import com.johe.scgcxx.model.Customer;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.model.PlanQuery;
import com.johe.scgcxx.model.Standard;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.plan.PlanManageService;

@Service
public class PlanManageServiceImpl implements PlanManageService{
	
	private PlanManageDao planManageDao;

	@Autowired
	public void setPlanManageDao(PlanManageDao planManageDao){
		this.planManageDao = planManageDao;
	}
	
	@Override
	public Page toGetPlanList(PlanDto dto) {
		return EngineValue.squsel(planManageDao, dto);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return planManageDao.toGetAllCustomer();
	}

	@Override
	public List<Color> getAllColor() {
		return planManageDao.toGetAllColor();
	}

	@Override
	public List<Standard> getAllStandard() {
		return planManageDao.toGetAllStandard();
	}

	@Override
	public void toAddPlan(PlanDto dto) {
		planManageDao.insertPlan(dto);
	}

	@Override
	public boolean toAssignPlan(PlanDto dto) {
		if(planManageDao.updatePlan(dto) > 0){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public void toDeletePlan(PlanDto dto) {
		planManageDao.deletePlan(dto);
	}

	@Override
	public PlanQuery toGetPlan(PlanDto dto) {
		return planManageDao.getPlan(dto);
	}

	@Override
	public boolean toAlterPlan(PlanDto dto) {
		if(planManageDao.updatePlan(dto) > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Plan toGetIdAndXh() {
		return planManageDao.getIdandXh();
	}


}

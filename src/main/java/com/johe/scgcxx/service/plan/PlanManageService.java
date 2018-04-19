package com.johe.scgcxx.service.plan;

import java.util.List;

import com.johe.scgcxx.dto.PlanDto;
import com.johe.scgcxx.model.Color;
import com.johe.scgcxx.model.Customer;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.model.PlanQuery;
import com.johe.scgcxx.model.Standard;
import com.johe.scgcxx.page.Page;

public interface PlanManageService {

	Page toGetPlanList(PlanDto dto);

	List<Customer> getAllCustomer();

	List<Color> getAllColor();

	List<Standard> getAllStandard();

	void toAddPlan(PlanDto dto);

	boolean toAssignPlan(PlanDto dto);

	void toDeletePlan(PlanDto dto);

	PlanQuery toGetPlan(PlanDto dto);

	boolean toAlterPlan(PlanDto dto);

	Plan toGetIdAndXh();

}

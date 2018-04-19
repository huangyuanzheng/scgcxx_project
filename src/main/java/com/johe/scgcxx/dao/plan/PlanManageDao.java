package com.johe.scgcxx.dao.plan;

import java.util.List;

import com.johe.scgcxx.dto.PlanDto;
import com.johe.scgcxx.model.Color;
import com.johe.scgcxx.model.Customer;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.model.PlanQuery;
import com.johe.scgcxx.model.Standard;
import com.johe.scgcxx.page.PageDao;

public interface PlanManageDao extends PageDao{

	List<Customer> toGetAllCustomer();

	List<Color> toGetAllColor();

	List<Standard> toGetAllStandard();

	void insertPlan(PlanDto dto);

	int updatePlan(PlanDto dto);

	void deletePlan(PlanDto dto);

	PlanQuery getPlan(PlanDto dto);

	Plan getIdandXh();
}

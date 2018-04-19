package com.johe.scgcxx.service.process;

import com.johe.scgcxx.dto.PlanDto;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.model.Process;

public interface ProcessGetPlansService {

	Page toGetPlanList(PlanDto dto);

	Plan toGetPlan(PlanDto dto);

	Process toGetProcessGroupId();

}

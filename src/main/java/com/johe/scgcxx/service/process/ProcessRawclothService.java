package com.johe.scgcxx.service.process;

import java.util.List;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.model.Process;
public interface ProcessRawclothService {

	List<Plan> toGetPlanList();

	Page toGetProcessList(ProcessDto dto);

	void toGroupPlan(ProcessDto dto);

	boolean toAssignProcess(ProcessDto dto);

	Process toGetProcess(ProcessDto dto);

	boolean toAlterProcess(ProcessDto dto);

	void toDeleteProcess(ProcessDto dto);

}

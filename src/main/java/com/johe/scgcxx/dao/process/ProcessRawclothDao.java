package com.johe.scgcxx.dao.process;

import java.util.List;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.page.PageDao;
import com.johe.scgcxx.model.Process;
public interface ProcessRawclothDao extends PageDao{

	List<Plan> getAllPlans();

	void GroupPlan(ProcessDto dto);

	int AssignProcess(ProcessDto dto);

	Process GetProcess(ProcessDto dto);

	int AlterProcess(ProcessDto dto);

	void DeleteProcess(ProcessDto dto);

}

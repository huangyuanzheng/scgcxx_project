package com.johe.scgcxx.dao.process;

import com.johe.scgcxx.dto.PlanDto;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.PageDao;

public interface ProcessGetPlansDao extends PageDao{

	Plan getPlan(PlanDto dto);

	Process getProcessGroupId();

}

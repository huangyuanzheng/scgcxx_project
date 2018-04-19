package com.johe.scgcxx.dao.process;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.page.PageDao;
import com.johe.scgcxx.model.Process;

public interface ProcessPretreatmentDao extends PageDao{

	Process getPretreatment(ProcessDto dto);

	int finishPretreatment(ProcessDto dto);

}

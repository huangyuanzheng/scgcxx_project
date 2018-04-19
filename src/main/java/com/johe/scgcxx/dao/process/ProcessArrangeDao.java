package com.johe.scgcxx.dao.process;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.PageDao;

public interface ProcessArrangeDao extends PageDao{

	Process getArrange(ProcessDto dto);

	int doArrange(ProcessDto dto);
	
}

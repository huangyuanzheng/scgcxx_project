package com.johe.scgcxx.dao.process;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.PageDao;

public interface ProcessRanseDao extends PageDao{

	Process getRanse(ProcessDto dto);

	int doRanse(ProcessDto dto);

}

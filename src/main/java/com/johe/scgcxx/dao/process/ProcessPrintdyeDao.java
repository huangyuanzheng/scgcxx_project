package com.johe.scgcxx.dao.process;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.PageDao;

public interface ProcessPrintdyeDao extends PageDao{

	int doPrintdye(ProcessDto dto);

	Process getPrintdye(ProcessDto dto);
}

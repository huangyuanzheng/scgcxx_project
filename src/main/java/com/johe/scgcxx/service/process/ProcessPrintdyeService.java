package com.johe.scgcxx.service.process;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.Page;

public interface ProcessPrintdyeService {

	Page toGetPrintdyeList(ProcessDto dto);

	Process toGetPrintdye(ProcessDto dto);

	boolean doPrintdye(ProcessDto dto);

}

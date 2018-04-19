package com.johe.scgcxx.service.process;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.Page;

public interface ProcessArrangeService {

	Page toGetArrangeList(ProcessDto dto);

	Process toGetArrange(ProcessDto dto);

	boolean doArrange(ProcessDto dto);

}

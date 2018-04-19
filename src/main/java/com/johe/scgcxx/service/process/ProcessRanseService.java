package com.johe.scgcxx.service.process;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.Page;

public interface ProcessRanseService {

	Page toGetRanseList(ProcessDto dto);

	Process toGetRanse(ProcessDto dto);

	boolean doRanse(ProcessDto dto);

}

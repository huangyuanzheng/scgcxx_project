package com.johe.scgcxx.service.process;

import com.johe.scgcxx.dto.CheckDto;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.Page;

public interface ProcessCheckService {

	Page toGetCheckList(ProcessDto dto);

	Process toGetCheck(CheckDto dto);

	void doCheck(CheckDto dto);

}

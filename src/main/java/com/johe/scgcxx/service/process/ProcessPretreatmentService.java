package com.johe.scgcxx.service.process;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.model.Process;

public interface ProcessPretreatmentService {

	Page toGetPretreatmentList(ProcessDto dto);

    Process toGetPretreatment(ProcessDto dto);

	Boolean tofinishPretreatment(ProcessDto dto);

}

package com.johe.scgcxx.service.process;

import com.johe.scgcxx.dto.StoreDto;
import com.johe.scgcxx.page.Page;

public interface ProcessOutService {

	Page toGetOutList(StoreDto dto);

	void doOut(StoreDto dto);

}

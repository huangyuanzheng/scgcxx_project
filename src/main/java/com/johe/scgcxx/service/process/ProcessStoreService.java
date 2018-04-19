package com.johe.scgcxx.service.process;

import com.johe.scgcxx.dto.ProductDto;
import com.johe.scgcxx.dto.StoreDto;
import com.johe.scgcxx.page.Page;

public interface ProcessStoreService {

	Page toGetStoreList(StoreDto dto);

	void doStore(StoreDto dto);

}

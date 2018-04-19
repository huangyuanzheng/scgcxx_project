package com.johe.scgcxx.service.info;

import com.johe.scgcxx.dto.StandardDto;
import com.johe.scgcxx.model.Standard;
import com.johe.scgcxx.page.Page;

public interface InfoStandardService {

	Page toGetList(StandardDto dto);

	void toAdd(StandardDto dto);

	Standard toGet(StandardDto dto);

	boolean toAlter(StandardDto dto);

	void toDelete(StandardDto dto);

	Standard toGetId();

}

package com.johe.scgcxx.service.info;

import com.johe.scgcxx.dto.ColorDto;
import com.johe.scgcxx.model.Color;
import com.johe.scgcxx.page.Page;

public interface InfoColorService {

	Page toGetList(ColorDto dto);

	void toAdd(ColorDto dto);

	Color toGet(ColorDto dto);

	boolean toAlter(ColorDto dto);

	void toDelete(ColorDto dto);

	Color toGetId();
}

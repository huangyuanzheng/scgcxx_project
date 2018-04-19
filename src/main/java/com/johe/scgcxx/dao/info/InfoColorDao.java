package com.johe.scgcxx.dao.info;

import com.johe.scgcxx.dto.ColorDto;
import com.johe.scgcxx.model.Color;
import com.johe.scgcxx.page.PageDao;

public interface InfoColorDao extends PageDao{

	void insertColor(ColorDto dto);

	Color getColor(ColorDto dto);

	int alterColor(ColorDto dto);

	void deleteColor(ColorDto dto);

	Color GetId();

}

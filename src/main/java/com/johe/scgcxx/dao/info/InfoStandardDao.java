package com.johe.scgcxx.dao.info;

import com.johe.scgcxx.dto.StandardDto;
import com.johe.scgcxx.model.Standard;
import com.johe.scgcxx.page.PageDao;

public interface InfoStandardDao extends PageDao{

	void insertStandard(StandardDto dto);

	Standard getStandard(StandardDto dto);

	int alterStandard(StandardDto dto);

	void deleteStandard(StandardDto dto);

	Standard getId();

}

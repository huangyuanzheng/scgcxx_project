package com.johe.scgcxx.service.info;

import com.johe.scgcxx.dto.CustomerDto;
import com.johe.scgcxx.model.Customer;
import com.johe.scgcxx.page.Page;

public interface InfoCustomerService {

	Page toGetList(CustomerDto dto);

	void toAdd(CustomerDto dto);

	Customer toGet(CustomerDto dto);

	boolean toAlter(CustomerDto dto);

	void toDelete(CustomerDto dto);

	Customer toGetId();
	
}

package com.johe.scgcxx.dao.info;

import com.johe.scgcxx.dto.CustomerDto;
import com.johe.scgcxx.model.Customer;
import com.johe.scgcxx.page.PageDao;

public interface InfoCustomerDao extends PageDao{

	void insertCustomer(CustomerDto dto);

	Customer getCustomer(CustomerDto dto);

	int alterCustomer(CustomerDto dto);

	void deleteCustomer(CustomerDto dto);

	Customer getId();

}

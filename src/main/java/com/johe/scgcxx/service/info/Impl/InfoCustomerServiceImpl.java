package com.johe.scgcxx.service.info.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.info.InfoCustomerDao;
import com.johe.scgcxx.dto.CustomerDto;
import com.johe.scgcxx.model.Customer;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.info.InfoCustomerService;

@Service
public class InfoCustomerServiceImpl implements InfoCustomerService{
	private InfoCustomerDao infoCustomerDao;
	
	@Autowired
	public void setInfoCustomerDao(InfoCustomerDao infoCustomerDao){
		this.infoCustomerDao = infoCustomerDao;
	}
	
	@Override
	public Page toGetList(CustomerDto dto) {
		return EngineValue.squsel(infoCustomerDao, dto);
	}

	@Override
	public void toAdd(CustomerDto dto) {
		infoCustomerDao.insertCustomer(dto);
	}

	@Override
	public Customer toGet(CustomerDto dto) {
		return infoCustomerDao.getCustomer(dto);
	}

	@Override
	public boolean toAlter(CustomerDto dto) {
		if(infoCustomerDao.alterCustomer(dto) != 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void toDelete(CustomerDto dto) {
		infoCustomerDao.deleteCustomer(dto);
	}

	@Override
	public Customer toGetId() {
		return infoCustomerDao.getId();
	}



}

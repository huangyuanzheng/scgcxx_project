package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessGetStoreDao;
import com.johe.scgcxx.dto.StoreDto;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessGetStoreService;

@Service
public class ProcessGetStoreServiceImpl implements ProcessGetStoreService{
	private ProcessGetStoreDao processGetStoreDao;
	
	@Autowired
	public void setProcessPackageDao(ProcessGetStoreDao processGetStoreDao){
		this.processGetStoreDao = processGetStoreDao;
	}
		
	@Override
	public Page toGetStoreList(StoreDto dto) {
		return EngineValue.squsel(processGetStoreDao, dto);
	}
}

package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessStoreDao;
import com.johe.scgcxx.dto.ProductDto;
import com.johe.scgcxx.dto.StoreDto;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessStoreService;
@Service
public class ProcessStoreServiceImpl implements ProcessStoreService{

	private ProcessStoreDao processStoreDao;
	
	@Autowired
	public void setProcessStoreDao(ProcessStoreDao processStoreDao){
		this.processStoreDao = processStoreDao;
	}
		
	@Override
	public Page toGetStoreList(StoreDto dto) {
		return EngineValue.squsel(processStoreDao, dto);
	}

	@Override
	public void doStore(StoreDto dto) {
		processStoreDao.updateStore(dto);
		if(processStoreDao.getProductStatus(dto.getProduct_id()).equals("50") || processStoreDao.getProductStatus(dto.getProduct_id()).equals("55")){
			if(Double.compare(processStoreDao.getStoreSum(dto.getProduct_id()), processStoreDao.getProductnum(dto.getProduct_id())) == 0){
				processStoreDao.updatedProduct(dto.getProduct_id());
			}else{
				processStoreDao.updateProduct(dto.getProduct_id());
			}
		}
	}
}

package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessOutDao;
import com.johe.scgcxx.dto.StoreDto;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessOutService;

@Service
public class ProcessOutServiceImpl implements ProcessOutService{
	
	private ProcessOutDao processOutDao;
	
	@Autowired
	public void setProcessOutDao(ProcessOutDao processOutDao){
		this.processOutDao = processOutDao;
	}
	
	@Override
	public Page toGetOutList(StoreDto dto) {
		return EngineValue.squsel(processOutDao, dto);
	}

	@Override
	public void doOut(StoreDto dto) {
		processOutDao.updateStore(dto);
		if(processOutDao.getProductStatus(dto.getProduct_id()).equals("60") || processOutDao.getProductStatus(dto.getProduct_id()).equals("65")){
			if(Double.compare(processOutDao.getOutSum(dto.getProduct_id()), processOutDao.getProductnum(dto.getProduct_id())) == 0){
				processOutDao.updatedProduct(dto.getProduct_id());
			}else{
				processOutDao.updateProduct(dto.getProduct_id());
			}
		}
	}

}

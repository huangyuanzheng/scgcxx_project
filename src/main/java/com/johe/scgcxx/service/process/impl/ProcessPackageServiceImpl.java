package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessPackageDao;
import com.johe.scgcxx.dto.ProductDto;
import com.johe.scgcxx.model.Product;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessPackageService;

@Service
public class ProcessPackageServiceImpl implements ProcessPackageService{
	
	private ProcessPackageDao processPackageDao;
	
	@Autowired
	public void setProcessPackageDao(ProcessPackageDao processPackageDao){
		this.processPackageDao = processPackageDao;
	}
		
	@Override
	public Page toGetPackageList(ProductDto dto) {
		return EngineValue.squsel(processPackageDao, dto);
	}

	@Override
	public Product toGetProduct(ProductDto dto) {
		return processPackageDao.getPackage(dto);
	}

	@Override
	public void doPackage(ProductDto dto) {
		/*是否为第一次包装*/
		if(Double.compare(dto.getProduct_num(), dto.getProduct_nopkg()) == 0){
			/*第一次是否包装完*/
			if(Double.compare(dto.getProduct_pkg(), dto.getProduct_nopkg()) == 0){
				processPackageDao.createPackage(dto);
				processPackageDao.finishProduct(dto);
				if(processPackageDao.checkProcess(dto.getProcess_id()) == 0){
					processPackageDao.packagedProcess(dto.getProcess_id());
				}else{
					processPackageDao.packageProcess(dto.getProcess_id());
				}
			}else{
				processPackageDao.createPackage(dto);
				processPackageDao.updateProduct(dto);
				processPackageDao.packageProcess(dto.getProcess_id());
			}
		}else{
				/*是否包装完*/
			if(Double.compare(dto.getProduct_pkg(), dto.getProduct_nopkg()) == 0){
				processPackageDao.createPackage(dto);
				processPackageDao.finishProduct(dto);
				if(processPackageDao.checkProcess(dto.getProcess_id()) == 0){
					processPackageDao.packagedProcess(dto.getProcess_id());
				}
			}else{
				processPackageDao.createPackage(dto);
			}
		}
	}
}


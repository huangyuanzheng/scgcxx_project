package com.johe.scgcxx.service.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.process.ProcessCheckDao;
import com.johe.scgcxx.dto.CheckDto;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.process.ProcessCheckService;

@Service
public class processCheckServiceImpl implements ProcessCheckService{

	private ProcessCheckDao processCheckDao;
	
	@Autowired
	public void setProcessArrangeDao(ProcessCheckDao processCheckDao){
		this.processCheckDao = processCheckDao;
	}
	
	@Override
	public Page toGetCheckList(ProcessDto dto) {
		return EngineValue.squsel(processCheckDao, dto);
	}

	@Override
	public Process toGetCheck(CheckDto dto) {
		return processCheckDao.getCheck(dto);
	}

	@Override
	public void doCheck(CheckDto dto) {
		Process process = processCheckDao.getCheck(dto);
		dto.setProcess_color(process.getProcess_color());
		dto.setProduct_cus(process.getProcess_cus());
		dto.setProduct_std(process.getProcess_std());
		System.out.println(dto.getProduct_cus()+"===========================");
		Double product_check_num = dto.getProduct_first()+dto.getProduct_second()+dto.getProduct_third()+dto.getProduct_subStandard();
		/*≈–∂œ «∑Ò÷ ºÏÕÍ*/
		if(Double.compare(dto.getProduct_noCheck(), dto.getArrange_num()) == 0){
			if(Double.compare(product_check_num, dto.getProduct_noCheck()) == 0){
				processCheckDao.createFinishFirst(dto);
				processCheckDao.createFinishSecond(dto);
				processCheckDao.createFinishThird(dto);
				processCheckDao.createFinishSub(dto);
				processCheckDao.CompleteCheck(dto);
			}else{
				processCheckDao.createFirst(dto);
				processCheckDao.createSecond(dto);
				processCheckDao.createThird(dto);
				processCheckDao.createSub(dto);
				processCheckDao.processCheck(dto);
			}
		}else{
			if(Double.compare(product_check_num, dto.getProduct_noCheck()) == 0){
				processCheckDao.upFinishFirst(dto);
				processCheckDao.upFinishSecond(dto);
				processCheckDao.upFinishThird(dto);
				processCheckDao.upFinishSub(dto);
				processCheckDao.CompleteCheck(dto);
			}else{
				processCheckDao.upFirst(dto);
				processCheckDao.upSecond(dto);
				processCheckDao.upThird(dto);
				processCheckDao.upSub(dto);
				processCheckDao.processCheck(dto);
			}
		}

	}
}

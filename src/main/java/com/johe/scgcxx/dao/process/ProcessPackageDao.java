package com.johe.scgcxx.dao.process;

import com.johe.scgcxx.dto.ProductDto;
import com.johe.scgcxx.model.Product;
import com.johe.scgcxx.page.PageDao;

public interface ProcessPackageDao extends PageDao{

	Product getPackage(ProductDto dto);

	void createPackage(ProductDto dto);

	void finishProduct(ProductDto dto);

	void packagedProcess(Integer process_id);

	void packageProcess(Integer process_id);

	void updateProduct(ProductDto dto);

	int checkProcess(Integer process_id);

}

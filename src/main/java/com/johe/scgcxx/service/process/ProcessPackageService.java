package com.johe.scgcxx.service.process;

import com.johe.scgcxx.dto.ProductDto;
import com.johe.scgcxx.model.Product;
import com.johe.scgcxx.page.Page;

public interface ProcessPackageService {

	Page toGetPackageList(ProductDto dto);

	Product toGetProduct(ProductDto dto);

	void doPackage(ProductDto dto);

}

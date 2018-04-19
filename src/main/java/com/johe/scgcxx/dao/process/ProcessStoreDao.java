package com.johe.scgcxx.dao.process;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.johe.scgcxx.dto.StoreDto;
import com.johe.scgcxx.page.PageDao;

public interface ProcessStoreDao extends PageDao{

	@Update("update bus_store set store_status = '60', store_date= #{store_date}, store_person=#{store_person} where store_id = #{store_id}")
	void updateStore(StoreDto dto);
	@Update("update bus_product set product_status = '60' where product_id=#{product_id}")
	void updatedProduct(Integer product_id);
	@Update("update bus_product set product_status = '55' where product_id=#{product_id}")
	void updateProduct(Integer product_id);
	@Select("select product_status from bus_product where product_id = #{product_id}")
	String getProductStatus(Integer product_id);

	@Select("select sum(store_num) from bus_store where product_id = #{product_id} and (store_status = '60' or store_status = '70')")
	double getStoreSum(Integer product_id);

	@Select("select product_num from bus_product where product_id = #{product_id}")
	double getProductnum(Integer product_id);
	
}

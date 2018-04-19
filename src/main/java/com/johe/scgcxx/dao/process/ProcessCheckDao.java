package com.johe.scgcxx.dao.process;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.johe.scgcxx.dto.CheckDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.page.PageDao;

public interface ProcessCheckDao extends PageDao{

	Process getCheck(CheckDto dto);
	
	@Insert("insert into bus_product values(nvl((select max(product_id) from bus_product), 0)+1, #{process_id}, #{product_cus}, #{product_std}, #{process_color}, "
			+ "'01', #{product_first}, '35')")
	void createFinishFirst(CheckDto dto);
	
	@Insert("insert into bus_product values(nvl((select max(product_id) from bus_product), 0)+1, #{process_id}, #{product_cus}, #{product_std}, #{process_color}, "
			+ "'02', #{product_second}, '35')")
	void createFinishSecond(CheckDto dto);

	@Insert("insert into bus_product values(nvl((select max(product_id) from bus_product), 0)+1, #{process_id}, #{product_cus}, #{product_std}, #{process_color}, "
			+ "'03', #{product_third}, '35')")
	void createFinishThird(CheckDto dto);

	@Insert("insert into bus_product values(nvl((select max(product_id) from bus_product), 0)+1, #{process_id}, #{product_cus}, #{product_std}, #{process_color}, "
			+ "'04', #{product_subStandard}, '35')")
	void createFinishSub(CheckDto dto);

	void createFirst(CheckDto dto);
	
	@Insert("insert into bus_product values(nvl((select max(product_id) from bus_product), 0)+1, #{process_id}, #{product_cus}, #{product_std}, #{process_color}, "
			+ "'02', #{product_second}, '30')")
	void createSecond(CheckDto dto);

	@Insert("insert into bus_product values(nvl((select max(product_id) from bus_product), 0)+1, #{process_id}, #{product_cus}, #{product_std}, #{process_color}, "
			+ "'03', #{product_third}, '30')")
	void createThird(CheckDto dto);

	@Insert("insert into bus_product values(nvl((select max(product_id) from bus_product), 0)+1, #{process_id}, #{product_cus}, #{product_std}, #{process_color}, "
			+ "'04', #{product_subStandard}, '30')")
	void createSub(CheckDto dto);

	@Update("update bus_product set product_num=product_num+#{product_first}, product_status='35' "
			+ "where process_id=#{process_id} and product_level = '01'")
	void upFinishFirst(CheckDto dto);

	@Update("update bus_product set product_num=product_num+#{product_second}, product_status='35' "
			+ "where process_id=#{process_id} and product_level = '02'")
	void upFinishSecond(CheckDto dto);

	@Update("update bus_product set product_num=product_num+#{product_third}, product_status='35' "
			+ "where process_id=#{process_id} and product_level = '03'")
	void upFinishThird(CheckDto dto);

	@Update("update bus_product set product_num=product_num+#{product_subStandard}, product_status='35' "
			+ "where process_id=#{process_id} and product_level = '04'")
	void upFinishSub(CheckDto dto);
	
	@Update("update bus_product set product_num=product_num+#{product_first}, product_status='30' "
			+ "where process_id=#{process_id} and product_level = '01'")
	void upFirst(CheckDto dto);

	@Update("update bus_product set product_num=product_num+#{product_second}, product_status='30' "
			+ "where process_id=#{process_id} and product_level = '02'")
	void upSecond(CheckDto dto);

	@Update("update bus_product set product_num=product_num+#{product_third}, product_status='30' "
			+ "where process_id=#{process_id} and product_level = '03'")
	void upThird(CheckDto dto);

	@Update("update bus_product set product_num=product_num+#{product_subStandard}, product_status='30' "
			+ "where process_id=#{process_id} and product_level = '04'")
	void upSub(CheckDto dto);

	@Update("update bus_process set check_num=#{arrange_num}, check_date=#{check_date}, check_person=#{check_person}, process_status='35' where process_id=#{process_id}")
	void CompleteCheck(CheckDto dto);

	@Update("update bus_process set process_status='30' where process_id=#{process_id}")
	void processCheck(CheckDto dto);



}

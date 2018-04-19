package com.johe.scgcxx.util;


import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.record.formula.functions.Today;

import com.johe.scgcxx.model.Company;

public class CompanySum extends ArrayList<Company>{
	private static DecimalFormat fmt = new DecimalFormat("#.00%");
	
	

	public static ArrayList<Company> sum(ArrayList<Company> list) {
		for(Company company : list){
			company.setQulifed_rate(fmt.format(company.getYd_product()/company.getNum_group()));
		}
		return list;
	}
	
	public static Company totalLast(ArrayList<Company> list){
		Company total=new Company();
		if(total.getNum_group() == null){
			total.setNum_group(0.0);
		}
		if(total.getNum_check() == null){
			total.setNum_check(0.0);
		}
		if(total.getYd_product() == null){
			total.setYd_product(0.0);
		}
		if(total.getDw_product() == null){
			total.setDw_product(0.0);
		}
		if(total.getEd_product() == null){
			total.setEd_product(0.0);
		}
		if(total.getSd_product() == null){
			total.setSd_product(0.0);
		}
		if(total.getQulifed() == null){
			total.setQulifed(0.0);
		}
		for (Company company : list) {
			total.setNum_check(company.getNum_check()+total.getNum_check());
			total.setNum_group(company.getNum_group()+total.getNum_group());
			total.setYd_product(company.getYd_product()+total.getYd_product());
			total.setDw_product(company.getDw_product()+total.getDw_product());
			total.setEd_product(company.getEd_product()+total.getEd_product());
			total.setSd_product(company.getSd_product()+total.getSd_product());
			total.setQulifed((company.getYd_product()/company.getNum_group()+total.getQulifed())/2);
		}
		System.out.println(total.getQulifed());
		total.setQulifed_rate(fmt.format(total.getQulifed()));
		return total;
	}
	
}

package com.johe.scgcxx.dto;

import com.johe.scgcxx.page.PageParam;

public class ProductDto extends PageParam{
	private Integer product_id;
	private Integer process_id;
	private String product_cus;
	private String product_std;
	private String process_color;
	private String product_level;
	private Double product_num;
	private String product_status;
	private Double product_pkg;
	private String pkg_person;
	private String pkg_date;
	private Double product_nopkg;
	
	public Double getProduct_nopkg() {
		return product_nopkg;
	}
	public void setProduct_nopkg(Double product_nopkg) {
		this.product_nopkg = product_nopkg;
	}
	public String getPkg_person() {
		return pkg_person;
	}
	public void setPkg_person(String pkg_person) {
		this.pkg_person = pkg_person;
	}
	public String getPkg_date() {
		return pkg_date;
	}
	public void setPkg_date(String pkg_date) {
		this.pkg_date = pkg_date;
	}
	public Double getProduct_pkg() {
		return product_pkg;
	}
	public void setProduct_pkg(Double product_pkg) {
		this.product_pkg = product_pkg;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getProcess_id() {
		return process_id;
	}
	public void setProcess_id(Integer process_id) {
		this.process_id = process_id;
	}
	public String getProduct_cus() {
		return product_cus;
	}
	public void setProduct_cus(String product_cus) {
		this.product_cus = product_cus;
	}
	public String getProduct_std() {
		return product_std;
	}
	public void setProduct_std(String product_std) {
		this.product_std = product_std;
	}
	public String getProcess_color() {
		return process_color;
	}
	public void setProcess_color(String process_color) {
		this.process_color = process_color;
	}
	public String getProduct_level() {
		return product_level;
	}
	public void setProduct_level(String product_level) {
		this.product_level = product_level;
	}
	public Double getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Double product_num) {
		this.product_num = product_num;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	
	
	
}

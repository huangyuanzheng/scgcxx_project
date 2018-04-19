package com.johe.scgcxx.dto;

import com.johe.scgcxx.page.PageParam;

public class StoreDto extends PageParam{
	private Integer store_id;
	private Integer product_id;
	private String store_cus;
	private String store_std;
	private String store_color;
	private Double store_num;
	private String store_date;
	private String store_person;
	private String store_status;
	private Double out_num;
	private String out_date;
	private String out_person;
	
	public Double getOut_num() {
		return out_num;
	}
	public void setOut_num(Double out_num) {
		this.out_num = out_num;
	}
	public String getOut_date() {
		return out_date;
	}
	public void setOut_date(String out_date) {
		this.out_date = out_date;
	}
	public String getOut_person() {
		return out_person;
	}
	public void setOut_person(String out_person) {
		this.out_person = out_person;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getStore_cus() {
		return store_cus;
	}
	public void setStore_cus(String store_cus) {
		this.store_cus = store_cus;
	}
	public String getStore_std() {
		return store_std;
	}
	public void setStore_std(String store_std) {
		this.store_std = store_std;
	}
	public String getStore_color() {
		return store_color;
	}
	public void setStore_color(String store_color) {
		this.store_color = store_color;
	}
	public Double getStore_num() {
		return store_num;
	}
	public void setStore_num(Double store_num) {
		this.store_num = store_num;
	}
	public String getStore_date() {
		return store_date;
	}
	public void setStore_date(String store_date) {
		this.store_date = store_date;
	}
	public String getStore_person() {
		return store_person;
	}
	public void setStore_person(String store_person) {
		this.store_person = store_person;
	}
	public String getStore_status() {
		return store_status;
	}
	public void setStore_status(String store_status) {
		this.store_status = store_status;
	}
	
	
}

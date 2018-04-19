package com.johe.scgcxx.dto;

import com.johe.scgcxx.page.PageParam;

public class CustomerDto extends PageParam{
	private Integer cus_id;
	private String cus_name;
	private String cus_remark;
	public Integer getCus_id() {
		return cus_id;
	}
	public void setCus_id(Integer cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCus_remark() {
		return cus_remark;
	}
	public void setCus_remark(String cus_remark) {
		this.cus_remark = cus_remark;
	}
}

package com.johe.scgcxx.dto;

import com.johe.scgcxx.page.PageParam;

public class RoleDto extends PageParam {
	private String ro_id;
	private String ro_name;
	private String ro_remark;
	
	public String getRo_id() {
		return ro_id;
	}
	public void setRo_id(String ro_id) {
		this.ro_id = ro_id;
	}
	public String getRo_name() {
		return ro_name;
	}
	public void setRo_name(String ro_name) {
		this.ro_name = ro_name;
	}
	public String getRo_remark() {
		return ro_remark;
	}
	public void setRo_remark(String ro_remark) {
		this.ro_remark = ro_remark;
	}
}	

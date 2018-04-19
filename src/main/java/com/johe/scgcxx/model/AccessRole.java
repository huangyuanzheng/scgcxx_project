package com.johe.scgcxx.model;

public class AccessRole {
	private int ro_id;
	private String ro_name;
	private String ro_remark;
	private Boolean has;
	
	public int getRo_id() {
		return ro_id;
	}
	public void setRo_id(int ro_id) {
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
	public Boolean getHas() {
		return has;
	}
	public void setHas(Boolean has) {
		this.has = has;
	}
	
}

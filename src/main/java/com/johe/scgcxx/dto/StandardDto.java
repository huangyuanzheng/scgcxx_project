package com.johe.scgcxx.dto;

import com.johe.scgcxx.page.PageParam;

public class StandardDto extends PageParam{
	private int standard_id;
	private String standard_name;
	public int getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(int standard_id) {
		this.standard_id = standard_id;
	}
	public String getStandard_name() {
		return standard_name;
	}
	public void setStandard_name(String standard_name) {
		this.standard_name = standard_name;
	}
}

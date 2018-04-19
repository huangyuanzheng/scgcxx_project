package com.johe.scgcxx.dto;

import java.util.Date;

import com.johe.scgcxx.page.PageParam;

public class addPlanDto extends PageParam{
	private Integer plan_id;
	private Integer cus_id;
	private Integer co_id;
	private Integer standard_id;
	private Integer plan_xh;
	private String plan_month;
	private float plan_num;
	private Integer plan_type;
	private Date plan_date;
	private String plan_person;
	private Integer plan_status;
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public Integer getCus_id() {
		return cus_id;
	}
	public void setCus_id(Integer cus_id) {
		this.cus_id = cus_id;
	}
	public Integer getCo_id() {
		return co_id;
	}
	public void setCo_id(Integer co_id) {
		this.co_id = co_id;
	}
	public Integer getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(Integer standard_id) {
		this.standard_id = standard_id;
	}
	public Integer getPlan_xh() {
		return plan_xh;
	}
	public void setPlan_xh(Integer plan_xh) {
		this.plan_xh = plan_xh;
	}
	public String getPlan_month() {
		return plan_month;
	}
	public void setPlan_month(String plan_month) {
		this.plan_month = plan_month;
	}
	public float getPlan_num() {
		return plan_num;
	}
	public void setPlan_num(float plan_num) {
		this.plan_num = plan_num;
	}
	public Integer getPlan_type() {
		return plan_type;
	}
	public void setPlan_type(Integer plan_type) {
		this.plan_type = plan_type;
	}
	public Date getPlan_date() {
		return plan_date;
	}
	public void setPlan_date(Date plan_date) {
		this.plan_date = plan_date;
	}
	public String getPlan_person() {
		return plan_person;
	}
	public void setPlan_person(String plan_person) {
		this.plan_person = plan_person;
	}
	public Integer getPlan_status() {
		return plan_status;
	}
	public void setPlan_status(Integer plan_status) {
		this.plan_status = plan_status;
	}
	
	
}

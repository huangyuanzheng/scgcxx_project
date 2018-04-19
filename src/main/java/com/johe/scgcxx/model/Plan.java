package com.johe.scgcxx.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Plan {
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
	private String cus_name;
	private String co_name;
	private String standard_name;
	private String plan_type_name;
	private String plan_status_name;
	private float plan_nums;
	
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	public String getPlan_dateStr(){
		return fmt.format(plan_date);
	}
	
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
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCo_name() {
		return co_name;
	}
	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}
	public String getStandard_name() {
		return standard_name;
	}
	public void setStandard_name(String standard_name) {
		this.standard_name = standard_name;
	}
	public String getPlan_type_name() {
		return plan_type_name;
	}
	public void setPlan_type_name(String plan_type_name) {
		this.plan_type_name = plan_type_name;
	}
	public String getPlan_status_name() {
		return plan_status_name;
	}
	public void setPlan_status_name(String plan_status_name) {
		this.plan_status_name = plan_status_name;
	}
	public float getPlan_nums() {
		return plan_nums;
	}
	public void setPlan_nums(float plan_nums) {
		this.plan_nums = plan_nums;
	}
	
	
}

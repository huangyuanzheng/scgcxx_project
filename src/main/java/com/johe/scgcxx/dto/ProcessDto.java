package com.johe.scgcxx.dto;

import java.util.Date;

import com.johe.scgcxx.page.PageParam;

public class ProcessDto extends PageParam{
	private Integer process_id;
	private Integer plan_id;
	private String process_cus;
	private String process_std;
	private String process_color;
	private Double group_num;
	private String group_date;
	private String group_person;
	private Double pretreat_num;
	private String pretreat_date;
	private String pretreat_person;
	private Double dye_num;
	private String dye_date;
	private String dye_person;
	private Double print_num;
	private String print_date; 
	private String print_person;
	private Double arrange_num;
	private String arrange_date;
	private String arrange_person;
	private Double check_num;
	private String check_date;
	private String check_person;
	private String process_status;
	private String userName;
	private String process_status_check;
	
	public String getProcess_status_check() {
		return process_status_check;
	}
	public void setProcess_status_check(String process_status_check) {
		this.process_status_check = process_status_check;
	}
	public Integer getProcess_id() {
		return process_id;
	}
	public void setProcess_id(Integer process_id) {
		this.process_id = process_id;
	}
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public String getProcess_cus() {
		return process_cus;
	}
	public void setProcess_cus(String process_cus) {
		this.process_cus = process_cus;
	}
	public String getProcess_std() {
		return process_std;
	}
	public void setProcess_std(String process_std) {
		this.process_std = process_std;
	}
	public String getProcess_color() {
		return process_color;
	}
	public void setProcess_color(String process_color) {
		this.process_color = process_color;
	}
	public Double getGroup_num() {
		return group_num;
	}
	public void setGroup_num(Double group_num) {
		this.group_num = group_num;
	}
	public String getGroup_date() {
		return group_date;
	}
	public void setGroup_date(String group_date) {
		this.group_date = group_date;
	}
	public String getGroup_person() {
		return group_person;
	}
	public void setGroup_person(String group_person) {
		this.group_person = group_person;
	}
	public Double getPretreat_num() {
		return pretreat_num;
	}
	public void setPretreat_num(Double pretreat_num) {
		this.pretreat_num = pretreat_num;
	}
	public String getPretreat_date() {
		return pretreat_date;
	}
	public void setPretreat_date(String pretreat_date) {
		this.pretreat_date = pretreat_date;
	}
	public String getPretreat_person() {
		return pretreat_person;
	}
	public void setPretreat_person(String pretreat_person) {
		this.pretreat_person = pretreat_person;
	}
	public Double getDye_num() {
		return dye_num;
	}
	public void setDye_num(Double dye_num) {
		this.dye_num = dye_num;
	}
	public String getDye_date() {
		return dye_date;
	}
	public void setDye_date(String dye_date) {
		this.dye_date = dye_date;
	}
	public String getDye_person() {
		return dye_person;
	}
	public void setDye_person(String dye_person) {
		this.dye_person = dye_person;
	}
	public Double getPrint_num() {
		return print_num;
	}
	public void setPrint_num(Double print_num) {
		this.print_num = print_num;
	}
	public String getPrint_date() {
		return print_date;
	}
	public void setPrint_date(String print_date) {
		this.print_date = print_date;
	}
	public String getPrint_person() {
		return print_person;
	}
	public void setPrint_person(String print_person) {
		this.print_person = print_person;
	}
	public Double getArrange_num() {
		return arrange_num;
	}
	public void setArrange_num(Double arrange_num) {
		this.arrange_num = arrange_num;
	}
	public String getArrange_date() {
		return arrange_date;
	}
	public void setArrange_date(String arrange_date) {
		this.arrange_date = arrange_date;
	}
	public String getArrange_person() {
		return arrange_person;
	}
	public void setArrange_person(String arrange_person) {
		this.arrange_person = arrange_person;
	}
	public Double getCheck_num() {
		return check_num;
	}
	public void setCheck_num(Double check_num) {
		this.check_num = check_num;
	}
	public String getCheck_date() {
		return check_date;
	}
	public void setCheck_date(String check_date) {
		this.check_date = check_date;
	}
	public String getCheck_person() {
		return check_person;
	}
	public void setCheck_person(String check_person) {
		this.check_person = check_person;
	}
	public String getProcess_status() {
		return process_status;
	}
	public void setProcess_status(String process_status) {
		this.process_status = process_status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}	

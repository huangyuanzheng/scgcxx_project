package com.johe.scgcxx.dto;

public class ResultDto {
	private Boolean success;
	private String msg;
	private Object data;
	
	public static ResultDto result(Boolean success){
		return new ResultDto(success);
	}
	
	public static ResultDto result(Boolean success, String msg){
		return new ResultDto(success, msg);
	}
	
	public static ResultDto result(Boolean success, String msg, Object data){
		return new ResultDto(success, msg, data);
	}
	
	public ResultDto(Boolean success){
		this.success = success;
	}
	
	public ResultDto(Boolean success, String msg){
		this.msg = msg;
		this.success = success;
	}
	
	public ResultDto(Boolean success, String msg, Object data){
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}
	
	
	
	
	
}

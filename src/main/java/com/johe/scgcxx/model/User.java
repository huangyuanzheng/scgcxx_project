package com.johe.scgcxx.model;

import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{
	private String u_id;
	private String u_name;
	private String u_pwd;
	public static HashMap<String, HttpSession> Users = new HashMap<>();
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public boolean existUser(String u_id){
		Set<String> ids= Users.keySet();
		for(String id : ids){
			if(id.equals(u_id)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		Users.put(this.getU_id(), event.getSession());
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		Users.remove(this.getU_id());
	}
	
	
}

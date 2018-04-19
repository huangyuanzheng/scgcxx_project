package com.johe.scgcxx.model;

public class Permission {
	private Integer m_id;
	private Integer m_pid;
	private String m_name;
	private String m_url;
	private Integer m_ismenu;
	
	private Boolean has;
	
	/***
	 * 
	* @Title: getM_id 
	* @Description: 
	* @return 
	* @return Integer    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:58:21
	 */
	public Integer getM_id() {
		return m_id;
	}
	
	/***
	 * 
	* @Title: setM_id 
	* @Description: 
	* @param m_id 
	* @return void    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:58:09
	 */
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	
	/***
	 * 
	* @Title: getM_pid 
	* @Description: 
	* @return 
	* @return Integer    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:57:09
	 */
	public Integer getM_pid() {
		return m_pid;
	}
	/**
	 * 
	* @Title: setM_pid 
	* @Description: 
	* @param m_pid 
	* @return void    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:58:28
	 */
	public void setM_pid(Integer m_pid) {
		this.m_pid = m_pid;
	}
	/**
	 * 
	* @Title: getM_name 
	* @Description: 
	* @return 
	* @return String    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:58:42
	 */
	public String getM_name() {
		return m_name;
	}
	/**
	 * 
	* @Title: setM_name 
	* @Description: 
	* @param m_name 
	* @return void    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:58:53
	 */
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	/**
	 * 
	* @Title: getM_url 
	* @Description: 
	* @return 
	* @return String    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:58:58
	 */
	public String getM_url() {
		return m_url;
	}
	/**
	 * 
	* @Title: setM_url 
	* @Description: 
	* @param m_url 
	* @return void    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:59:02
	 */
	public void setM_url(String m_url) {
		this.m_url = m_url;
	}
	/**
	 * 
	* @Title: getM_ismenu 
	* @Description: 
	* @return 
	* @return Integer    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:59:08
	 */
	public Integer getM_ismenu() {
		return m_ismenu;
	}
	/**
	 * 
	* @Title: setM_ismenu 
	* @Description: 
	* @param m_ismenu 
	* @return void    返回类型 
	* @throws 
	* @author:黄渊磊
	* @date 2018年1月31日 下午5:59:13
	 */
	public void setM_ismenu(Integer m_ismenu) {
		this.m_ismenu = m_ismenu;
	}

	public Boolean getHas() {
		return has;
	}

	public void setHas(Boolean has) {
		this.has = has;
	}
	
}

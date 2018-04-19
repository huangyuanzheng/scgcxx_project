package com.johe.scgcxx.page;

public class PageParam {
	
	private int start;
	private int end;
	private String page;
	private String rows;
	private String limit;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	//每页限制的行数
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	/**
	 * 页数
	 * @return
	 */
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	/**
	 * 行数
	 * @return
	 */
	public String getRows() {
		return getLimit();
	}
}

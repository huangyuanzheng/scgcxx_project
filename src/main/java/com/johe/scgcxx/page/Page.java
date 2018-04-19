package com.johe.scgcxx.page;

import java.util.List;

import com.johe.scgcxx.util.Layui;
public interface Page {
	/**
	 * 第一页码
	 * @return
	 */
	public int getFirst();
	
	
	public int getPrior();
	public int getNext();
	public int getLast();
	
	public int getCurr();
	
	/**
	 * 总记录数
	 * @return
	 */
	public int getTotal();
	
	/**
	 * 总页数
	 * @return
	 */
	public int getPgTotal();
	
	/**
	 * 每页最大允许记录数
	 * @return
	 */
	public int getRows();
	
	/**
	 * 当前页实际记录数
	 * @return
	 */
	public int getCurrRows();
	
	/**
	 * 当前页数据记录
	 * @return
	 */
	public List<?> getRecList();
	
	public Layui data();

}

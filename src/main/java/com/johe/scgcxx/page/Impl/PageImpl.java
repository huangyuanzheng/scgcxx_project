package com.johe.scgcxx.page.Impl;

import java.util.List;

import com.johe.scgcxx.page.Engine;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.util.Layui;

public class PageImpl implements Page{
	private int first = 1;
	private int curr;
	private int total;
	private int pgTotal;
	private int rows;
	private List<?> recList;
	public PageImpl(String rows, String page, Engine engineValue) {
		//第一次登陆时默认为10
		if(rows == null){
			rows = "10";
		}
		//每页记录数据的行数
		this.rows = new Integer(rows);
		
		//获取数据总记录数
		try {
			this.total = new Integer(engineValue.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//计算总页数
		if(this.total < 1){
			this.pgTotal = 1;
		}
		else{
			if(this.total % this.rows == 0){
				this.pgTotal = this.total / this.rows;
			}
			else{
				pgTotal = this.total / this.rows + 1;
			}
		}
		//计算当前页码
		try {
			this.curr = new Integer(page);
		} catch (NumberFormatException e) {
			this.curr = getFirst();
		}
		if(this.curr < getFirst()){
			this.curr = getFirst();
		}
		else if(this.curr > pgTotal){
			this.curr = pgTotal;
		}
		//获取本页数据
		try {
			recList = engineValue.getRecList((this.curr-1)*this.rows, this.curr*this.rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 第一页码
	 * @return
	 */
	public int getFirst() {
		return this.first;
	}

	/**
	 * 总页数
	 * @return
	 */
	public int getPgTotal() {
		return this.pgTotal;
	}
	
	@Override
	public int getPrior() {
		return this.curr-1<getFirst() ? getFirst() : (this.curr - 1);
	}
	
	@Override
	public int getNext() {
		return this.curr+1>getLast() ? getLast() : (this.curr + 1);
	}
	
	@Override
	public int getLast() {
		return pgTotal;
	}
	
	@Override
	public int getCurr() {
		return this.curr;
	}

	/**
	 * 总记录数
	 * @return
	 */
	public int getTotal() {
		return this.total;
	}
	

	/**
	 * 每页最大允许记录数
	 * @return
	 */
	public int getRows() {
		return this.rows;
	}
	
	/**
	 * 当前页实际记录数
	 * @return
	 */
	public int getCurrRows() {
		return recList.size();
	}
	/**
	 * 当前页数据记录
	 * @return
	 */
	public List<?> getRecList() {
		return recList;
	}

	@Override
	public Layui data() {
		Layui r = new Layui();
		r.put("code", 0);
		r.put("msg", "");
		r.put("count", total);
		r.put("data", recList);
		return r;
	}	
}

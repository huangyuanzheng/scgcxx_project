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
		//��һ�ε�½ʱĬ��Ϊ10
		if(rows == null){
			rows = "10";
		}
		//ÿҳ��¼���ݵ�����
		this.rows = new Integer(rows);
		
		//��ȡ�����ܼ�¼��
		try {
			this.total = new Integer(engineValue.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//������ҳ��
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
		//���㵱ǰҳ��
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
		//��ȡ��ҳ����
		try {
			recList = engineValue.getRecList((this.curr-1)*this.rows, this.curr*this.rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��һҳ��
	 * @return
	 */
	public int getFirst() {
		return this.first;
	}

	/**
	 * ��ҳ��
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
	 * �ܼ�¼��
	 * @return
	 */
	public int getTotal() {
		return this.total;
	}
	

	/**
	 * ÿҳ��������¼��
	 * @return
	 */
	public int getRows() {
		return this.rows;
	}
	
	/**
	 * ��ǰҳʵ�ʼ�¼��
	 * @return
	 */
	public int getCurrRows() {
		return recList.size();
	}
	/**
	 * ��ǰҳ���ݼ�¼
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

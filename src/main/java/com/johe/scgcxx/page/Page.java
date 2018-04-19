package com.johe.scgcxx.page;

import java.util.List;

import com.johe.scgcxx.util.Layui;
public interface Page {
	/**
	 * ��һҳ��
	 * @return
	 */
	public int getFirst();
	
	
	public int getPrior();
	public int getNext();
	public int getLast();
	
	public int getCurr();
	
	/**
	 * �ܼ�¼��
	 * @return
	 */
	public int getTotal();
	
	/**
	 * ��ҳ��
	 * @return
	 */
	public int getPgTotal();
	
	/**
	 * ÿҳ��������¼��
	 * @return
	 */
	public int getRows();
	
	/**
	 * ��ǰҳʵ�ʼ�¼��
	 * @return
	 */
	public int getCurrRows();
	
	/**
	 * ��ǰҳ���ݼ�¼
	 * @return
	 */
	public List<?> getRecList();
	
	public Layui data();

}

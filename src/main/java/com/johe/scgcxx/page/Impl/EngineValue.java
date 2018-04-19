package com.johe.scgcxx.page.Impl;

import java.util.List;

import com.johe.scgcxx.page.Engine;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.PageDao;
import com.johe.scgcxx.page.PageParam;


public class EngineValue implements Engine{
	
	private PageDao pageMaper; 
	private PageParam param;

	
	
	public EngineValue(PageDao pageMaper, PageParam param) {
		super();
		this.pageMaper = pageMaper;
		this.param = param;
	}
	/**
	 * ��ȡ�ܼ�¼��
	 * @return
	 * @throws Exception
	 */
	@Override
	public int getTotal() throws Exception {
		return pageMaper.findTotal(param);
	}
	/**
	 * ��ȡָ���к����������
	 * @param start ��ʼ�У�������
	 * @param end �����У�����
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<?> getRecList(int start, int end) throws Exception {
		param.setStart(start);
		param.setEnd(end);
		return pageMaper.findData(param);
	}

	public static Page squsel( PageDao pageMaper, PageParam para) {
		return new PageImpl(para.getRows(),para.getPage(),new EngineValue(pageMaper,para));
		
	}

}

package com.johe.scgcxx.page;

import java.util.List;

public interface Engine {
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @return
	 * @throws Exception
	 */
	public int getTotal() throws Exception;
	
	/**
	 * ��ȡָ���к����������
	 * @param start ��ʼ�У�������
	 * @param end �����У�����
	 * @return
	 * @throws Exception
	 */
	public List<?> getRecList(int start,int end) throws Exception;

}

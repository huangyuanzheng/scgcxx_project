package com.johe.scgcxx.page;

import java.util.List;

public interface Engine {
	
	/**
	 * 获取总记录数
	 * @return
	 * @throws Exception
	 */
	public int getTotal() throws Exception;
	
	/**
	 * 获取指定行号区间的数据
	 * @param start 起始行（不含）
	 * @param end 结束行（含）
	 * @return
	 * @throws Exception
	 */
	public List<?> getRecList(int start,int end) throws Exception;

}

package com.johe.scgcxx.page;

import java.util.List;

import com.johe.scgcxx.page.PageParam;


public interface PageDao {
	
	public List findData(PageParam param);
	
	public int findTotal(PageParam param);

}

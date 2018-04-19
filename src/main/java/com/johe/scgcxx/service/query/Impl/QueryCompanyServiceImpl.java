package com.johe.scgcxx.service.query.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.query.QueryCompanyDao;
import com.johe.scgcxx.model.Company;
import com.johe.scgcxx.service.query.QueryCompanyService;

@Service
public class QueryCompanyServiceImpl implements QueryCompanyService{
	
	private QueryCompanyDao queryCompanyDao;
	
	@Autowired
	public void setQueryCompanyDao(QueryCompanyDao queryCompanyDao){
		this.queryCompanyDao = queryCompanyDao;
	}

	@Override
	public ArrayList<Company> getAllCompany(String check_date) {
		return queryCompanyDao.getAllCompany(check_date);
	}

}

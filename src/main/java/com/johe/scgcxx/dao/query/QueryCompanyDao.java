package com.johe.scgcxx.dao.query;

import java.util.ArrayList;
import java.util.List;

import com.johe.scgcxx.model.Company;

public interface QueryCompanyDao{

	ArrayList<Company> getAllCompany(String check_date);
	
}

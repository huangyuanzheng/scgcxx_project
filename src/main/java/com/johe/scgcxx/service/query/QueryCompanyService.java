package com.johe.scgcxx.service.query;

import java.util.ArrayList;
import java.util.List;
import com.johe.scgcxx.model.Company;

public interface QueryCompanyService {

	ArrayList<Company> getAllCompany(String check_date);

}

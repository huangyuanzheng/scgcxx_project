package com.johe.scgcxx.controller.query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johe.scgcxx.model.Company;
import com.johe.scgcxx.service.query.QueryCompanyService;
import com.johe.scgcxx.util.CompanySum;

@Controller
@RequestMapping("query/company")
public class QueryCompanyController {

	private QueryCompanyService queryCompanyService;
	
	@Autowired
	public void setQueryCompanyService(QueryCompanyService queryCompanyService){
		this.queryCompanyService = queryCompanyService;
	}
	@RequestMapping("/toList.do")
	public String toList(Model model,String check_date, HttpSession session){
		ArrayList<Company> companys=queryCompanyService.getAllCompany(check_date);
		ArrayList<Company> companys1 = CompanySum.sum(companys);
		Company total = CompanySum.totalLast(companys);
		model.addAttribute("check_person", session.getAttribute("userId"));
		model.addAttribute("companys", companys1);
		model.addAttribute("companyLast", total);
		model.addAttribute("check_date", check_date);
		return "/WEB-INF/jsp/query/company/company.jsp";
	}
	
	@RequestMapping("/toListXls.do")
	public String toListXls(Model model,String check_date, HttpSession session){
		ArrayList<Company> companys=queryCompanyService.getAllCompany(check_date);
		ArrayList<Company> companys1 = CompanySum.sum(companys);
		Company total = CompanySum.totalLast(companys);
		model.addAttribute("check_person", session.getAttribute("userId"));
		model.addAttribute("companys", companys1);
		model.addAttribute("companyLast", total);
		model.addAttribute("check_date", check_date);
		return "/WEB-INF/jsp/query/company/company2.jsp";
	}
	
	
}

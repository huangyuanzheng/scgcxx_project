package com.johe.scgcxx.controller.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.CustomerDto;
import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.model.Customer;
import com.johe.scgcxx.service.info.InfoCustomerService;
import com.johe.scgcxx.util.Layui;
@Controller
@RequestMapping("/info/customer")
public class InfoCustomerController {
	private InfoCustomerService infoCustomerService;
	@Autowired
	public void setInfoCustomerService(InfoCustomerService infoCustomerService){
		this.infoCustomerService = infoCustomerService;
	}
	
	@RequestMapping("/toList.do")
	public String toCustomerList(){
		return "/WEB-INF/jsp/info/customer/customer.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doList.do", produces="application/json; charset=UTF-8")
	public Layui doCustomerList(CustomerDto dto){
		return infoCustomerService.toGetList(dto).data();
	}
	
	@RequestMapping("toAdd.do")
	public String toAddCustomer(CustomerDto dto, Model model){
		Customer customer = infoCustomerService.toGetId();
		if(customer != null){
			model.addAttribute("customer_id", customer.getCus_id()+1);
		}else{
			model.addAttribute("customer_id", 1);
		}
		return "/WEB-INF/jsp/info/customer/addCustomer.jsp";
	}
	@ResponseBody
	@RequestMapping(value="doAdd.do", produces="application/json; charset=UTF-8")
	public ResultDto doAddCustomer(CustomerDto dto){
		try {
			infoCustomerService.toAdd(dto);
			return ResultDto.result(true, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "新增失败");
		}
	}
	
	@RequestMapping("toAlter.do")
	public String toAlterCustomer(CustomerDto dto, Model model){
		Customer customer = infoCustomerService.toGet(dto);
		model.addAttribute("CheckCustomer", customer);
		return "/WEB-INF/jsp/info/customer/alterCustomer.jsp";
	}
	@ResponseBody
	@RequestMapping(value="doAlter.do", produces="application/json; charset=UTF-8")
	public ResultDto doAlterCustomer(CustomerDto dto){
		if(infoCustomerService.toAlter(dto)){
			return ResultDto.result(true, "修改成功");
		}else{
			return ResultDto.result(false, "修改失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="toDelete.do", produces="application/json; charset=UTF-8")
	public ResultDto doDeleteCustomer(CustomerDto dto){
		try {
			infoCustomerService.toDelete(dto);
			return ResultDto.result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "删除失败");
		}
	}
}

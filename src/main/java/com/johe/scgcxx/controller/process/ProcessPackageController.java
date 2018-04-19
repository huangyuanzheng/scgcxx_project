package com.johe.scgcxx.controller.process;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.CheckDto;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.dto.ProductDto;
import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.dto.StoreDto;
import com.johe.scgcxx.model.Product;
import com.johe.scgcxx.service.process.ProcessGetStoreService;
import com.johe.scgcxx.service.process.ProcessPackageService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/process/package")
public class ProcessPackageController {
	private ProcessPackageService processPackageService;
	private ProcessGetStoreService processGetStoreService;
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	public void setProcessPackageService(ProcessPackageService processPackageService, ProcessGetStoreService processGetStoreService){
		this.processPackageService = processPackageService;
		this.processGetStoreService = processGetStoreService;
	}
	
	@RequestMapping("/toList.do")
	public String toPackageList(){
		return "/WEB-INF/jsp/process/package/package.jsp";
	}
	
	@RequestMapping("/doList.do")
	@ResponseBody
	public Layui doPrintdyeList(ProductDto dto){
		return processPackageService.toGetPackageList(dto).data();
	}
	
	@RequestMapping("/toPackage.do")
	public String toRanse(ProductDto dto, Model model){
		Product product = processPackageService.toGetProduct(dto);
		model.addAttribute("product", product);
		if(product.getStore_num() == null){
			product.setStore_num(0.0);
		}
		model.addAttribute("no_pkg", product.getProduct_num() - product.getStore_num());
		return "/WEB-INF/jsp/process/package/toPackage.jsp";
	}
	
	@RequestMapping(value="/doPackage.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doRanse(ProductDto dto, HttpSession session){
		try {
			processPackageService.doPackage(dto);
			return ResultDto.result(true, "包装保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "包装保存失败");
		}	
	}
	@RequestMapping("/getStoreById.do")
	public String getStoreById(Integer product_id, Model model){
		model.addAttribute("product_id", product_id);
		return "/WEB-INF/jsp/process/package/toStore.jsp";
	}
	
	@RequestMapping("/StoreList.do")
	@ResponseBody
	public Layui getStoreList(StoreDto dto){
		return processGetStoreService.toGetStoreList(dto).data();
	}
	
}

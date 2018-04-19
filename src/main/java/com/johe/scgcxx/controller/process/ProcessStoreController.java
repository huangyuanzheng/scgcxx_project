package com.johe.scgcxx.controller.process;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.ProductDto;
import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.dto.StoreDto;
import com.johe.scgcxx.model.Product;
import com.johe.scgcxx.service.process.ProcessPackageService;
import com.johe.scgcxx.service.process.ProcessStoreService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("process/storehouse")
public class ProcessStoreController {
	private ProcessStoreService processStoreService;
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	public void setProcessStoreService(ProcessStoreService processStoreService){
		this.processStoreService = processStoreService;
	}
	
	@RequestMapping("/toList.do")
	public String toStoreList(){
		return "/WEB-INF/jsp/process/storehouse/store.jsp";
	}
	
	@RequestMapping("/doList.do")
	@ResponseBody
	public Layui doStoreList(StoreDto dto){
		return processStoreService.toGetStoreList(dto).data();
	}
	
	@RequestMapping(value="/doStore.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doStore(StoreDto dto, HttpSession session){
		dto.setStore_date(fmt.format(new Date()));
		dto.setStore_person((String) session.getAttribute("userId"));
		try {
			processStoreService.doStore(dto);
			return ResultDto.result(true, "入库成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "入库失败");
		}	
	}
}
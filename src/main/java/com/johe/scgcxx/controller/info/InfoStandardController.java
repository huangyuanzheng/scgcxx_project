package com.johe.scgcxx.controller.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.dto.StandardDto;
import com.johe.scgcxx.model.Customer;
import com.johe.scgcxx.model.Standard;
import com.johe.scgcxx.service.info.InfoStandardService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/info/standard")
public class InfoStandardController {
	private InfoStandardService infoStandardService;
	
	@Autowired
	public void setInfoStandardService(InfoStandardService infoStandardService){
		this.infoStandardService = infoStandardService;
	}
	
	@RequestMapping("/toList.do")
	public String toStandardList(){
		return "/WEB-INF/jsp/info/standard/standard.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doList.do", produces="application/json; charset=UTF-8")
	public Layui doStandardList(StandardDto dto){
		return infoStandardService.toGetList(dto).data();
	}
	
	@RequestMapping("toAdd.do")
	public String toAddStandard(StandardDto dto, Model model){
		Standard standard = infoStandardService.toGetId();
		if(standard != null){
			model.addAttribute("standard_id", standard.getStandard_id()+1);
		}else{
			model.addAttribute("standard_id", 1);
		}
		return "/WEB-INF/jsp/info/standard/addStandard.jsp";
	}
	@ResponseBody
	@RequestMapping(value="doAdd.do", produces="application/json; charset=UTF-8")
	public ResultDto doAddStandard(StandardDto dto){
		try {
			infoStandardService.toAdd(dto);
			return ResultDto.result(true, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "新增失败");
		}
	}
	
	@RequestMapping("toAlter.do")
	public String toAlterStandard(StandardDto dto, Model model){
		Standard standard = infoStandardService.toGet(dto);
		model.addAttribute("CheckStandard", standard);
		return "/WEB-INF/jsp/info/standard/alterStandard.jsp";
	}
	@ResponseBody
	@RequestMapping(value="doAlter.do", produces="application/json; charset=UTF-8")
	public ResultDto doAlterStandard(StandardDto dto){
		if(infoStandardService.toAlter(dto)){
			return ResultDto.result(true, "修改成功");
		}else{
			return ResultDto.result(false, "修改失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="toDelete.do", produces="application/json; charset=UTF-8")
	public ResultDto doDeleteStandard(StandardDto dto){
		try {
			infoStandardService.toDelete(dto);
			return ResultDto.result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "删除失败");
		}
	}
	
	
}

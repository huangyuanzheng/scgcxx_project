package com.johe.scgcxx.controller.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.ColorDto;
import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.model.Color;
import com.johe.scgcxx.service.info.InfoColorService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/info/color")
public class InfoColorController {
	private InfoColorService infoColorService;
	
	@Autowired
	public void setInfoColorService(InfoColorService infoColorService){
		this.infoColorService = infoColorService;
	}
	
	@RequestMapping("/toList.do")
	public String toCustomerList(){
		return "/WEB-INF/jsp/info/color/color.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doList.do", produces="application/json; charset=UTF-8")
	public Layui doColorList(ColorDto dto){
		return infoColorService.toGetList(dto).data();
	}
	
	@RequestMapping("toAdd.do")
	public String toAddColor(ColorDto dto, Model model){
		Color color = infoColorService.toGetId();
		if(color != null){
			model.addAttribute("co_id", color.getCo_id()+1);
		}
		else{
			model.addAttribute("co_id", 1);
		}
		return "/WEB-INF/jsp/info/color/addColor.jsp";
	}
	@ResponseBody
	@RequestMapping(value="doAdd.do", produces="application/json; charset=UTF-8")
	public ResultDto doAddColor(ColorDto dto){
		try {
			infoColorService.toAdd(dto);
			return ResultDto.result(true, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "新增失败");
		}
	}
	
	@RequestMapping("toAlter.do")
	public String toAlterColor(ColorDto dto, Model model){
		Color color = infoColorService.toGet(dto);
		model.addAttribute("CheckColor", color);
		return "/WEB-INF/jsp/info/color/alterColor.jsp";
	}
	@ResponseBody
	@RequestMapping(value="doAlter.do", produces="application/json; charset=UTF-8")
	public ResultDto doAlterColor(ColorDto dto){
		if(infoColorService.toAlter(dto)){
			return ResultDto.result(true, "修改成功");
		}else{
			return ResultDto.result(false, "修改失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="toDelete.do", produces="application/json; charset=UTF-8")
	public ResultDto doDeleteColor(ColorDto dto){
		try {
			infoColorService.toDelete(dto);
			return ResultDto.result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "删除失败");
		}
	}
	
}

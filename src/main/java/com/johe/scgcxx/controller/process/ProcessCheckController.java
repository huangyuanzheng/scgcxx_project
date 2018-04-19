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
import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.service.process.ProcessCheckService;
import com.johe.scgcxx.util.Layui;
@Controller
@RequestMapping("/process/check")
public class ProcessCheckController {
	private ProcessCheckService processCheckService;
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	public void setProcessArrangeService(ProcessCheckService processCheckService){
		this.processCheckService = processCheckService;
	}
	
	@RequestMapping("/toList.do")
	public String toPrintdyeList(){
		return "/WEB-INF/jsp/process/check/check.jsp";
	}
	
	@RequestMapping("/doList.do")
	@ResponseBody
	public Layui doPrintdyeList(ProcessDto dto){
		System.out.println(dto.getProcess_id()+"==============");
		System.out.println(dto.getProcess_status()+"===========>>>>>");
		return processCheckService.toGetCheckList(dto).data();
	}
	
	@RequestMapping("/toCheck.do")
	public String toRanse(CheckDto dto, Integer product_noCheck, Model model){
		Process process = processCheckService.toGetCheck(dto);
		model.addAttribute("check", process);
		model.addAttribute("product_noCheck", product_noCheck);
		return "/WEB-INF/jsp/process/check/toCheck.jsp";
	}
	
	@RequestMapping(value="/doCheck.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doRanse(CheckDto dto, HttpSession session){
		dto.setCheck_date(fmt.format(new Date()));
		dto.setCheck_person((String) session.getAttribute("userId"));
		try {
			processCheckService.doCheck(dto);
			return ResultDto.result(true, "质检保存成功");
		} catch (Exception e) {
			return ResultDto.result(false, "质检保存失败");
		}	
	}
}

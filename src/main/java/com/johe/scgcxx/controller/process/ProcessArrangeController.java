package com.johe.scgcxx.controller.process;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.service.process.ProcessArrangeService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/process/arrange")
public class ProcessArrangeController {
	private ProcessArrangeService processArrangeService;
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	public void setProcessArrangeService(ProcessArrangeService processArrangeService){
		this.processArrangeService = processArrangeService;
	}
	
	@RequestMapping("/toList.do")
	public String toPrintdyeList(){
		return "/WEB-INF/jsp/process/arrange/arrange.jsp";
	}
	
	@RequestMapping("/doList.do")
	@ResponseBody
	public Layui doPrintdyeList(ProcessDto dto){
		return processArrangeService.toGetArrangeList(dto).data();
	}
	
	@RequestMapping("/toArrange.do")
	public String toRanse(ProcessDto dto, Model model){
		Process process = processArrangeService.toGetArrange(dto);
		model.addAttribute("arrange", process);
		return "/WEB-INF/jsp/process/arrange/addArrange.jsp";
	}
	
	@RequestMapping(value="/doArrange.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doRanse(ProcessDto dto, HttpSession session){
		dto.setArrange_date(fmt.format(new Date()));
		dto.setArrange_person((String) session.getAttribute("userId"));
		dto.setProcess_status("25");
		if(processArrangeService.doArrange(dto)){
			return ResultDto.result(true, "整理成功");
		}else{
			return ResultDto.result(false, "整理失败");
		}
	}
}

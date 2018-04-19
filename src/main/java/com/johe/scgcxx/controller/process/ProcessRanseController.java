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
import com.johe.scgcxx.service.process.ProcessRanseService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/process/ranse")
public class ProcessRanseController {
	private ProcessRanseService processRanseService;
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	public void setProcessRanseService(ProcessRanseService processRanseService){
		this.processRanseService = processRanseService;
	}
	
	@RequestMapping("/toList.do")
	public String toRanseList(){
		return "/WEB-INF/jsp/process/ranse/ranse.jsp";
	}
	
	@RequestMapping("/doList.do")
	@ResponseBody
	public Layui doRanseList(ProcessDto dto){
		return processRanseService.toGetRanseList(dto).data();
	}
	
	@RequestMapping("/toRanse.do")
	public String toRanse(ProcessDto dto, Model model){
		Process process = processRanseService.toGetRanse(dto);
		model.addAttribute("ranse", process);
		return "/WEB-INF/jsp/process/ranse/addRanse.jsp";
	}
	
	@RequestMapping(value="/doRanse.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doRanse(ProcessDto dto, HttpSession session){
		dto.setDye_date(fmt.format(new Date()));
		dto.setDye_person((String) session.getAttribute("userId"));
		dto.setProcess_status("15");
		if(processRanseService.doRanse(dto)){
			return ResultDto.result(true, "染色成功");
		}else{
			return ResultDto.result(false, "染色失败");
		}
	}
}

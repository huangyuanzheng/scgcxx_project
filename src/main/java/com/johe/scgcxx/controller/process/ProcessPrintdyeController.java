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
import com.johe.scgcxx.service.process.ProcessPrintdyeService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/process/printdye")
public class ProcessPrintdyeController {
	private ProcessPrintdyeService processPrintdyeService;
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	public void setProcessPrintdyeService(ProcessPrintdyeService processPrintdyeService){
		this.processPrintdyeService = processPrintdyeService;
	}
	
	@RequestMapping("/toList.do")
	public String toPrintdyeList(){
		return "/WEB-INF/jsp/process/printdye/printdye.jsp";
	}
	
	@RequestMapping("/doList.do")
	@ResponseBody
	public Layui doPrintdyeList(ProcessDto dto){
		return processPrintdyeService.toGetPrintdyeList(dto).data();
	}
	
	@RequestMapping("/toPrintdye.do")
	public String toRanse(ProcessDto dto, Model model){
		Process process = processPrintdyeService.toGetPrintdye(dto);
		model.addAttribute("printdye", process);
		return "/WEB-INF/jsp/process/printdye/addPrintdye.jsp";
	}
	
	@RequestMapping(value="/doPrintdye.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doRanse(ProcessDto dto, HttpSession session){
		dto.setPrint_date(fmt.format(new Date()));
		dto.setPrint_person((String) session.getAttribute("userId"));
		dto.setProcess_status("20");
		if(processPrintdyeService.doPrintdye(dto)){
			return ResultDto.result(true, "印花成功");
		}else{
			return ResultDto.result(false, "印花失败");
		}
	}
}

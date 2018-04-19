package com.johe.scgcxx.controller.process;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.johe.scgcxx.model.Process;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.service.process.ProcessPretreatmentService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/process/pretreatment")
public class ProcessPretreatmentController {
	private ProcessPretreatmentService processPretreatmentService;
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	public void setProcessPretreatmentService(ProcessPretreatmentService processPretreatmentService){
		this.processPretreatmentService = processPretreatmentService;
	}
	
	@RequestMapping("/toList.do")
	public String toPretreatmentList(){
		return "/WEB-INF/jsp/process/pretreatment/pretreatment.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doList.do", produces="application/json; charset=UTF-8")
	public Layui doPretreatmentList(ProcessDto dto){
		return processPretreatmentService.toGetPretreatmentList(dto).data();
	}
	
	@RequestMapping("/toFinish.do")
	public String toFinishPretreatment(ProcessDto dto, Model model){
		Process process = processPretreatmentService.toGetPretreatment(dto);
		model.addAttribute("Pretreatment", process);
		return "/WEB-INF/jsp/process/pretreatment/addPretreatment.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doFinish.do", produces="application/json; charset=UTF-8")
	public ResultDto doFinishPretreatment(ProcessDto dto, HttpSession session){
		dto.setPretreat_date(fmt.format(new Date()));
		dto.setPretreat_person((String) session.getAttribute("userId"));
		dto.setProcess_status("10");
		if(processPretreatmentService.tofinishPretreatment(dto)){
			return ResultDto.result(true, "前处理成功");
		}else{
			return ResultDto.result(false, "前处理失败");
		}
	}
}

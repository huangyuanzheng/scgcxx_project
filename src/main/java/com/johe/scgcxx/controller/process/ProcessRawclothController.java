package com.johe.scgcxx.controller.process;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.PlanDto;
import com.johe.scgcxx.dto.ProcessDto;
import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.service.process.ProcessGetPlansService;
import com.johe.scgcxx.service.process.ProcessRawclothService;
import com.johe.scgcxx.util.Layui;
import com.johe.scgcxx.model.Process;
@Controller
@RequestMapping("process/rawcloth")
public class ProcessRawclothController {
	private ProcessRawclothService processRawclothService;
	private ProcessGetPlansService processGetPlansService;
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	public ProcessRawclothController(ProcessRawclothService processRawclothService, ProcessGetPlansService processGetPlansService){
		this.processGetPlansService = processGetPlansService;
		this.processRawclothService = processRawclothService;
	}
	
	@RequestMapping("/toList.do")
	public String toProcessList(){
		return "/WEB-INF/jsp/process/rawcloth/rawcloth.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doList.do", produces="application/json; charset=UTF-8")
	public Layui doProcessList(ProcessDto dto){
		return processRawclothService.toGetProcessList(dto).data();
	}
	
	@RequestMapping("/toGetAllPlan.do")
	public String toGetAllPlan(Model model){
		return "/WEB-INF/jsp/process/rawcloth/allPlans.jsp";
	}
	
	@RequestMapping(value="/doGetAllPlan.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Layui doGetAllPlan(PlanDto dto){
		return processGetPlansService.toGetPlanList(dto).data();
	}
	
	@RequestMapping("/toGroup.do")
	public String toGetPlan(PlanDto dto, Model model){
		Plan plan = processGetPlansService.toGetPlan(dto);
		Process process = processGetPlansService.toGetProcessGroupId();
		if(process != null){
			model.addAttribute("process_id", process.getProcess_id()+1);
		}else{
			model.addAttribute("process_id", 1);
		}
		model.addAttribute("plan", plan);
		return "/WEB-INF/jsp/process/rawcloth/addRawcloth.jsp";
	}
	@ResponseBody
	@RequestMapping(value="/doGroup.do", produces="application/json; charset=UTF-8")
	public ResultDto doGroupPlan(ProcessDto dto){
		try {
			dto.setProcess_status("00");
			processRawclothService.toGroupPlan(dto);
			return ResultDto.result(true, "分组成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "分组失败");
		}
	}
	@ResponseBody
	@RequestMapping(value="/toAssign.do", produces="application/json; charset=UTF-8")
	public ResultDto toAssignProcess(ProcessDto dto, HttpSession session){
		dto.setGroup_date(fmt.format(new Date()));
		dto.setProcess_status("05");
		dto.setGroup_person((String) session.getAttribute("userId"));
		if(processRawclothService.toAssignProcess(dto)){
			return ResultDto.result(true, "分组成功");
		}else{
			return ResultDto.result(true, "分组失败");
		}
	}
	@RequestMapping(value="/toAlter.do")
	public String toAlterProcess(ProcessDto dto, Model model){
		Process process = processRawclothService.toGetProcess(dto);
		model.addAttribute("Process", process);
		return "/WEB-INF/jsp/process/rawcloth/alterRawcloth.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doAlter.do", produces="application/json; charset=UTF-8")
	public ResultDto doAlterProcess(ProcessDto dto){
		if(processRawclothService.toAlterProcess(dto)){
			return ResultDto.result(true, "修改成功");
		}else {
			return ResultDto.result(false, "修改失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/toDelete.do", produces="application/json; charset=UTF-8")
	public ResultDto toDeleteProcess(ProcessDto dto){
		try {
			processRawclothService.toDeleteProcess(dto);
			return ResultDto.result(true, "删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultDto.result(false, "删除失败");
		}
	}
}

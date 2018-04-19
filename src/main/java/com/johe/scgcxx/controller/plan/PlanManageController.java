package com.johe.scgcxx.controller.plan;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.PlanDto;
import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.model.Color;
import com.johe.scgcxx.model.Customer;
import com.johe.scgcxx.model.Plan;
import com.johe.scgcxx.model.PlanQuery;
import com.johe.scgcxx.model.Standard;
import com.johe.scgcxx.service.plan.PlanManageService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/plan/manager")
public class PlanManageController {
	private PlanManageService planManageService;
	
	@Autowired
	public void setPlanManageService(PlanManageService planManageService){
		this.planManageService = planManageService;
	}
	
	@RequestMapping("/toList.do")
	public String toPlanList(){
		return "/WEB-INF/jsp/plan/manager/plan.jsp";
	}
	
	@RequestMapping(value="/doList.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Layui doPlanList(PlanDto dto, HttpSession session){
		dto.setPlan_person((String) session.getAttribute("userId"));
		return planManageService.toGetPlanList(dto).data();
	}
	
	@RequestMapping("toAdd.do")
	public String toAddPlan(Model model){
		List<Customer> customer = planManageService.getAllCustomer();
		model.addAttribute("allCustomer", customer);
		List<Color> color = planManageService.getAllColor();
		model.addAttribute("allColor", color);
		List<Standard> standard = planManageService.getAllStandard();
		model.addAttribute("allStandard", standard);
		Plan plan = planManageService.toGetIdAndXh();
		//System.out.println(plan.getPlan_id()+"__________________");
		if(plan != null){
			model.addAttribute("plan_id", plan.getPlan_id()+1);
			model.addAttribute("plan_xh", plan.getPlan_xh()+1);
		}else{
			model.addAttribute("plan_id", 1);
			model.addAttribute("plan_xh", 1);
		}
		return "/WEB-INF/jsp/plan/manager/addPlan.jsp";
	}
	
	@RequestMapping(value="doAdd.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doAddPlan(PlanDto dto, HttpSession session){
		dto.setPlan_person((String) session.getAttribute("userId"));
		dto.setPlan_status(0);
		try {
			planManageService.toAddPlan(dto);
			return ResultDto.result(true, "新增计划成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "新增计划失败");
		}
	}
	@RequestMapping(value="toAssign.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto toAssignPlan(PlanDto dto){
		dto.setPlan_status(1);
		dto.setPlan_date(new Date());
		System.out.println(dto.getPlan_date()+"==================");
		if(planManageService.toAssignPlan(dto)){
			return ResultDto.result(true, "计划下达成功");
		}else{
			return ResultDto.result(false, "计划下达失败");
		}
	}
	@RequestMapping(value="toDelete.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto toDeletePlan(PlanDto dto){
		try {
			planManageService.toDeletePlan(dto);
			return ResultDto.result(true, "计划删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "计划删除失败");
		}
	}
	@RequestMapping("toAlter.do")
	public String toAlterPlan(PlanDto dto, Model model){
		PlanQuery planQuery = planManageService.toGetPlan(dto);
		model.addAttribute("plan", planQuery);
		List<Customer> customer = planManageService.getAllCustomer();
		model.addAttribute("allCustomer", customer);
		List<Color> color = planManageService.getAllColor();
		model.addAttribute("allColor", color);
		List<Standard> standard = planManageService.getAllStandard();
		model.addAttribute("allStandard", standard);
		return "/WEB-INF/jsp/plan/manager/alterPlan.jsp"; 
	}
	
	@RequestMapping(value="doAlter.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doAlterPlan(PlanDto dto){
		if(planManageService.toAlterPlan(dto)){
			return ResultDto.result(true, "计划修改成功");
		}
		else{
			return ResultDto.result(true, "计划徐修改成功");
		}
	}
	
	
}

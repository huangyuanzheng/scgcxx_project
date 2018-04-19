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
import com.johe.scgcxx.dto.StoreDto;
import com.johe.scgcxx.service.process.ProcessOutService;
import com.johe.scgcxx.util.Layui;

@RequestMapping("/process/out")
@Controller
public class ProcessOutController {
	private ProcessOutService processOutService;
	static private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	public void setProcessOutService(ProcessOutService processOutService){
		this.processOutService = processOutService;
	}
	
	@RequestMapping("/toList.do")
	public String toPretreatmentList(){
		return "/WEB-INF/jsp/process/out/out.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doList.do", produces="application/json; charset=UTF-8")
	public Layui doPretreatmentList(StoreDto dto){
		return processOutService.toGetOutList(dto).data();
	}
	
	@ResponseBody
	@RequestMapping(value="/doOut.do", produces="application/json; charset=UTF-8")
	public ResultDto doFinishPretreatment(StoreDto dto, HttpSession session){
		dto.setOut_date(fmt.format(new Date()));
		dto.setOut_person((String) session.getAttribute("userId"));
		try {
			processOutService.doOut(dto);
			return ResultDto.result(true, "出库登记成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "出库登记失败");
		}	
	}
}

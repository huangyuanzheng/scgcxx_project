package com.johe.scgcxx.controller.safty;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.dto.UserDto;
import com.johe.scgcxx.model.ChildModule;
import com.johe.scgcxx.model.ParentModule;
import com.johe.scgcxx.model.User;
import com.johe.scgcxx.service.safty.SaftyLoginService;

@Controller
public class SaftyLoginController {
	private SaftyLoginService saftyLoginService;
	
	@Autowired
	public void setSaftyLoginService(SaftyLoginService saftyLoginService){
		this.saftyLoginService = saftyLoginService;
	}
	
	@RequestMapping("/safty/login/toLogin.do")
	public String toLogin(){
		return "/WEB-INF/jsp/safty/login/login.jsp";
	}
	
	@RequestMapping("/safty/login/doLogin.do")
	@ResponseBody
	public ResultDto doLogin(UserDto dto, HttpSession session){
		User user = saftyLoginService.checkLogin(dto);
		System.out.println(session.toString()+"==================");
		if(user != null){
			if(user.existUser(user.getU_id())){
				HttpSession session2 = user.Users.get(user.getU_id());
				System.out.println(session2.toString()+"==================>>>>");
				synchronized (session2) {
					session2.notifyAll();
				}
				user.Users.get(user.getU_id()).invalidate();
				user.Users.remove(user.getU_id());
				session.setAttribute("use", user);
				session.setAttribute("userId", user.getU_id());
				session.setAttribute("userName", user.getU_name());
				session.setAttribute("userPassword", user.getU_pwd());
			}else{
				session.setAttribute("use", user);
				session.setAttribute("userId", user.getU_id());
				session.setAttribute("userName", user.getU_name());
				session.setAttribute("userPassword", user.getU_pwd());
			}
			return ResultDto.result(true, "登陆成功");
		}else{
			return ResultDto.result(false, "用户名或密码错误");
		}
	}
	
	@RequestMapping("/safty/login/singleLogin.do")
	@ResponseBody
	public String singleLogin(HttpSession session){
		System.out.println(session.toString()+"------------------>");
		synchronized (session) {
			try {
				session.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return " ";
	}
	
	@RequestMapping("/safty/home/toHome.do")
	public String toHome(Model model, HttpSession session){
		String u_id = (String) session.getAttribute("userId");
		List<ParentModule> pam = saftyLoginService.getParentModel(u_id);
		List<ChildModule> chm = saftyLoginService.getChildModel(u_id);
		for(ParentModule p : pam){
			System.out.println(p.getM_name());
			for(ChildModule c : chm){
				System.out.println(c.getM_name());
			}
		}
		model.addAttribute("pam", pam);
		model.addAttribute("chm", chm);
		return "/WEB-INF/jsp/safty/home/home.jsp";
	}
	@RequestMapping("/safty/logout/doLogout.do")
	public String toLoginOut(HttpSession session){
		session.invalidate();
		return "redirect:/safty/login/toLogin.do";
	}
	
	@RequestMapping("/safty/password/toList.do")
	public String toShow(){
		return "/WEB-INF/jsp/safty/password/password.jsp";
	}
	
	@RequestMapping("/safty/password/toAlterPassword.do")
	public String toAlterPassword(){
		return "/WEB-INF/jsp/safty/password/alterPassword.jsp";
	}
	
	@RequestMapping("/safty/password/doAlterPassword.do")
	@ResponseBody
	public ResultDto doAlterPassword(String original, String identify, HttpSession session){
		String Password = (String) session.getAttribute("userPassword");
		String u_id = (String) session.getAttribute("userId");
		if(original.equals(Password)){
			if(saftyLoginService.alterPassword(u_id, identify)){
				return ResultDto.result(true, "修改成功");
			}else{
				return ResultDto.result(false, "修改失败");
			}
		}else{
			return ResultDto.result(false, "修改失败");
		}
	}
	
	
	
	
}

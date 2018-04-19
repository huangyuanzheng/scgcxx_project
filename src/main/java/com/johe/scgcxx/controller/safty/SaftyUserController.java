package com.johe.scgcxx.controller.safty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.dto.RoleDto;
import com.johe.scgcxx.dto.UserDto;
import com.johe.scgcxx.model.AccessRole;
import com.johe.scgcxx.model.Permission;
import com.johe.scgcxx.model.Rm;
import com.johe.scgcxx.model.Role;
import com.johe.scgcxx.model.Ur;
import com.johe.scgcxx.model.User;
import com.johe.scgcxx.service.safty.SaftyUserService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/safty/user")
public class SaftyUserController {
	private SaftyUserService saftyUserService;
	
	@Autowired
	public void setSaftyUserService(SaftyUserService saftyUserService){
		this.saftyUserService = saftyUserService;
	}
	
	@RequestMapping("/toList.do")
	public String toRoleList(){
		return "/WEB-INF/jsp/safty/user/user.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doList.do", produces="application/json; charset=UTF-8")
	public Layui doRoleList(UserDto dto){
		return saftyUserService.toGetUserList(dto).data();
	}
	
	@RequestMapping("toAdd.do")
	public String toAddRole(UserDto dto){
		return "/WEB-INF/jsp/safty/user/addUser.jsp";
	}
	@ResponseBody
	@RequestMapping(value="doAdd.do", produces="application/json; charset=UTF-8")
	public ResultDto doAddRole(UserDto dto){
		try {
			saftyUserService.toAddUser(dto);
			return ResultDto.result(true, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "新增失败");
		}
	}
	
	@RequestMapping("toAlter.do")
	public String toAlterRole(UserDto dto, Model model){
		User user = saftyUserService.toGetUser(dto);
		model.addAttribute("CheckUser", user);
		return "/WEB-INF/jsp/safty/user/alterUser.jsp";
	}
	@ResponseBody
	@RequestMapping(value="doAlter.do", produces="application/json; charset=UTF-8")
	public ResultDto doAlterRole(UserDto dto){
		if(saftyUserService.toAlterUser(dto)){
			return ResultDto.result(true, "修改成功");
		}else{
			return ResultDto.result(false, "修改失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="toDelete.do", produces="application/json; charset=UTF-8")
	public ResultDto doDeleteRole(UserDto dto){
		try {
			saftyUserService.toDeleteUser(dto);
			return ResultDto.result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "删除失败");
		}
	}
	
	@RequestMapping("/toAssign.do")
	public String toAssignRole(UserDto dto, Model model){
		User user = saftyUserService.toGetUser(dto);
		model.addAttribute("User", user);
		List<AccessRole> roles = saftyUserService.toGetRole(dto);
		model.addAttribute("AllRole", roles);
		return "/WEB-INF/jsp/safty/user/assignRole.jsp";
	}
	@RequestMapping(value="/doAssign.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doAssignRole(String u_id, Integer ro_id){
		try {
			saftyUserService.toAssignRole(u_id, ro_id);
			return ResultDto.result(true, "角色分配成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false);
		}
	}
	@RequestMapping(value="/doUnAssign.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doUnAssignRole(String u_id, Integer ro_id){
		try {
			saftyUserService.toUnAssignRole(u_id, ro_id);
			return ResultDto.result(true, "角色取消成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false);
		}
	}
	
}

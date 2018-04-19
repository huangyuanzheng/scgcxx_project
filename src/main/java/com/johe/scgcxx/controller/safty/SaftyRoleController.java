package com.johe.scgcxx.controller.safty;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johe.scgcxx.dto.ResultDto;
import com.johe.scgcxx.dto.RoleDto;
import com.johe.scgcxx.model.Permission;
import com.johe.scgcxx.model.Rm;
import com.johe.scgcxx.model.Role;
import com.johe.scgcxx.model.User;
import com.johe.scgcxx.service.safty.SaftyRoleService;
import com.johe.scgcxx.util.Layui;

@Controller
@RequestMapping("/safty/role")
public class SaftyRoleController {
	private SaftyRoleService saftyRoleService;
	
	@Autowired
	public void setSaftyRoleService(SaftyRoleService saftyRoleService){
		this.saftyRoleService = saftyRoleService;
	}
	
	@RequestMapping("/toList.do")
	public String toRoleList(){
		return "/WEB-INF/jsp/safty/role/role.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/doList.do", produces="application/json; charset=UTF-8")
	public Layui doRoleList(RoleDto dto){
		return saftyRoleService.toGetRoleList(dto).data();
	}
	
	@RequestMapping("/toAdd.do")
	public String toAddRole(RoleDto dto){
		return "/WEB-INF/jsp/safty/role/addRole.jsp";
	}
	@ResponseBody
	@RequestMapping(value="/doAdd.do", produces="application/json; charset=UTF-8")
	public ResultDto doAddRole(RoleDto dto){
		try {
			saftyRoleService.toAddRole(dto);
			return ResultDto.result(true, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "新增失败");
		}
	}
	
	@RequestMapping("/toAlter.do")
	public String toAlterRole(RoleDto dto, Model model){
		Role role = saftyRoleService.toGetRole(dto);
		model.addAttribute("CheckRole", role);
		return "/WEB-INF/jsp/safty/role/alterRole.jsp";
	}
	@ResponseBody
	@RequestMapping(value="/doAlter.do", produces="application/json; charset=UTF-8")
	public ResultDto doAlterRole(RoleDto dto){
		if(saftyRoleService.toAlterRole(dto)){
			return ResultDto.result(true, "修改成功");
		}else{
			return ResultDto.result(false, "修改失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/toDelete.do", produces="application/json; charset=UTF-8")
	public ResultDto doDeleteRole(RoleDto dto){
		try {
			saftyRoleService.toDeleteRole(dto);
			return ResultDto.result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false, "删除失败");
		}
	}
	@RequestMapping("/toAssign.do")
	public String toAssignRole(RoleDto dto, Model model){
		Role role = saftyRoleService.toGetRole(dto);
		model.addAttribute("Role", role);
		List<Rm> rms = saftyRoleService.toGetPerssionById(dto);
		model.addAttribute("RoleRm", rms);
		List<Permission> permission = saftyRoleService.toGetPermission(dto);
		model.addAttribute("AllPermission", permission);
		return "/WEB-INF/jsp/safty/role/assignPermission.jsp";
	}
	@RequestMapping(value="/doAssign.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doAssignRole(Integer m_id, Integer ro_id){
		try {
			saftyRoleService.toAssignPermission(m_id, ro_id);
			return ResultDto.result(true, "权限分配成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false);
		}
	}
	@RequestMapping(value="/doUnAssign.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ResultDto doUnAssignRole(Integer m_id, Integer ro_id){
		try {
			saftyRoleService.toUnAssignPermission(m_id, ro_id);
			return ResultDto.result(true, "权限取消成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultDto.result(false);
		}
	}

}

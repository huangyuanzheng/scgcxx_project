package com.johe.scgcxx.service.safty.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.safty.SaftyRoleDao;
import com.johe.scgcxx.dto.RoleDto;
import com.johe.scgcxx.model.Permission;
import com.johe.scgcxx.model.Rm;
import com.johe.scgcxx.model.Role;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.safty.SaftyRoleService;

@Service
public class SaftyRoleServiceImpl implements SaftyRoleService{
	
	private SaftyRoleDao saftyRoleDao;
	@Autowired
	public void setSaftyRoleDao(SaftyRoleDao saftyRoleDao){
		this.saftyRoleDao = saftyRoleDao;
	}
	
	@Override
	public Page toGetRoleList(RoleDto dto) {
		return EngineValue.squsel(saftyRoleDao, dto);
	}

	@Override
	public void toAddRole(RoleDto dto) {
		saftyRoleDao.insertRole(dto);
	}

	@Override
	public boolean toAlterRole(RoleDto dto) {
		if(saftyRoleDao.alterRole(dto) != 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Role toGetRole(RoleDto dto) {
		return saftyRoleDao.getRole(dto);
	}

	@Override
	public void toDeleteRole(RoleDto dto) {
		saftyRoleDao.deleteRole(dto);
	}

	@Override
	public List<Rm> toGetPerssionById(RoleDto dto) {
		return saftyRoleDao.getPerssionById(dto);
	}

	@Override
	public List<Permission> toGetPermission(RoleDto dto) {
		return saftyRoleDao.getPermission(dto);
	}

	@Override
	public void toAssignPermission(Integer m_id, Integer ro_id) {
		saftyRoleDao.AssignPermission(m_id, ro_id);
	}

	@Override
	public void toUnAssignPermission(Integer m_id, Integer ro_id) {
		saftyRoleDao.UnAssignPermission(m_id, ro_id);
	}

}

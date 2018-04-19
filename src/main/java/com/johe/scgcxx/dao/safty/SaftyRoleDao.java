package com.johe.scgcxx.dao.safty;

import java.util.List;

import com.johe.scgcxx.dto.RoleDto;
import com.johe.scgcxx.model.Permission;
import com.johe.scgcxx.model.Rm;
import com.johe.scgcxx.model.Role;
import com.johe.scgcxx.page.PageDao;

public interface SaftyRoleDao extends PageDao{
	public void insertRole(RoleDto dto);

	public int alterRole(RoleDto dto);

	public Role getRole(RoleDto dto);

	public void deleteRole(RoleDto dto);

	public List<Rm> getPerssionById(RoleDto dto);

	public List<Permission> getPermission(RoleDto dto);

	public void AssignPermission(Integer m_id, Integer ro_id);

	public void UnAssignPermission(Integer m_id, Integer ro_id);
}

package com.johe.scgcxx.service.safty;



import java.util.List;

import com.johe.scgcxx.dto.RoleDto;
import com.johe.scgcxx.model.Permission;
import com.johe.scgcxx.model.Rm;
import com.johe.scgcxx.model.Role;
import com.johe.scgcxx.page.Page;


public interface SaftyRoleService {
	Page toGetRoleList(RoleDto dto);

	void toAddRole(RoleDto dto);

	boolean toAlterRole(RoleDto dto);

	Role toGetRole(RoleDto dto);

	void toDeleteRole(RoleDto dto);

	List<Rm> toGetPerssionById(RoleDto dto);

	List<Permission> toGetPermission(RoleDto dto);

	void toAssignPermission(Integer m_id, Integer ro_id);

	void toUnAssignPermission(Integer m_id, Integer ro_id);
}

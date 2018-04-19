package com.johe.scgcxx.service.safty;



import java.util.List;

import com.johe.scgcxx.dto.UserDto;
import com.johe.scgcxx.model.AccessRole;
import com.johe.scgcxx.model.Role;
import com.johe.scgcxx.model.Ur;
import com.johe.scgcxx.model.User;
import com.johe.scgcxx.page.Page;


public interface SaftyUserService {
	Page toGetUserList(UserDto dto);

	void toAddUser(UserDto dto);

	boolean toAlterUser(UserDto dto);

	User toGetUser(UserDto dto);

	void toDeleteUser(UserDto dto);

	List<AccessRole> toGetRole(UserDto dto);

	void toAssignRole(String u_id, Integer ro_id);

	void toUnAssignRole(String u_id, Integer ro_id);
}

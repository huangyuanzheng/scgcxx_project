package com.johe.scgcxx.dao.safty;


import java.util.List;

import com.johe.scgcxx.dto.UserDto;
import com.johe.scgcxx.model.AccessRole;
import com.johe.scgcxx.model.User;
import com.johe.scgcxx.page.PageDao;

public interface SaftyUserDao extends PageDao{
	public void insertUser(UserDto dto);

	public int alterUser(UserDto dto);

	public User getUser(UserDto dto);

	public void deleteUser(UserDto dto);

	public List<AccessRole> getHasRole(UserDto dto);

	public void AssignRole(String u_id, Integer ro_id);

	public void UnAssignRole(String u_id, Integer ro_id);
}

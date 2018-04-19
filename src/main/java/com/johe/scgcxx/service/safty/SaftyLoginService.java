package com.johe.scgcxx.service.safty;

import java.util.List;

import com.johe.scgcxx.dto.UserDto;
import com.johe.scgcxx.model.ChildModule;
import com.johe.scgcxx.model.ParentModule;
import com.johe.scgcxx.model.User;

public interface SaftyLoginService {
	public User checkLogin(UserDto dto);

	public List<ParentModule> getParentModel(String u_id);

	public List<ChildModule> getChildModel(String u_id);

	public boolean alterPassword(String u_id, String identify);
}

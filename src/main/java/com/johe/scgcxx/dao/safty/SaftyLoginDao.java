package com.johe.scgcxx.dao.safty;

import java.util.List;

import com.johe.scgcxx.dto.UserDto;
import com.johe.scgcxx.model.ChildModule;
import com.johe.scgcxx.model.ParentModule;
import com.johe.scgcxx.model.User;

public interface SaftyLoginDao {
	public User findCountByUidAndUpwd(UserDto dto);

	public List<ParentModule> getParentByUid(String u_id);

	public List<ChildModule> getChildByUid(String u_id);

	public int alterPwd(String u_id, String identify);
}

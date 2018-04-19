package com.johe.scgcxx.service.safty.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.safty.SaftyLoginDao;
import com.johe.scgcxx.dto.UserDto;
import com.johe.scgcxx.model.ChildModule;
import com.johe.scgcxx.model.ParentModule;
import com.johe.scgcxx.model.User;
import com.johe.scgcxx.service.safty.SaftyLoginService;

@Service
public class SaftyLoginServiceImpl implements SaftyLoginService{
	private SaftyLoginDao saftyLoginDao;
	
	@Autowired
	public void setSaftyLoginDao(SaftyLoginDao saftyLoginDao){
		this.saftyLoginDao = saftyLoginDao;
	}

	@Override
	public User checkLogin(UserDto dto) {
		return saftyLoginDao.findCountByUidAndUpwd(dto);
	}

	@Override
	public List<ParentModule> getParentModel(String u_id) {
		return saftyLoginDao.getParentByUid(u_id);
	}

	@Override
	public List<ChildModule> getChildModel(String u_id) {
		return saftyLoginDao.getChildByUid(u_id);
	}

	@Override
	public boolean alterPassword(String u_id, String identify) {
		if(saftyLoginDao.alterPwd(u_id, identify) == 0){
			return false;
		}
		else{
			return true;
		}
	}

}

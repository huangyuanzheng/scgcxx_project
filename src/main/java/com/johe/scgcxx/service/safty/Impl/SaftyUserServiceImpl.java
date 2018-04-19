package com.johe.scgcxx.service.safty.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johe.scgcxx.dao.safty.SaftyRoleDao;
import com.johe.scgcxx.dao.safty.SaftyUserDao;
import com.johe.scgcxx.dto.UserDto;
import com.johe.scgcxx.model.AccessRole;
import com.johe.scgcxx.model.Role;
import com.johe.scgcxx.model.Ur;
import com.johe.scgcxx.model.User;
import com.johe.scgcxx.page.Page;
import com.johe.scgcxx.page.Impl.EngineValue;
import com.johe.scgcxx.service.safty.SaftyUserService;

@Service
public class SaftyUserServiceImpl implements SaftyUserService{
	
	private SaftyUserDao saftyUserDao;
	@Autowired
	public void setSaftyRoleDao(SaftyUserDao saftyUserDao){
		this.saftyUserDao = saftyUserDao;
	}
	@Override
	public Page toGetUserList(UserDto dto) {
		return EngineValue.squsel(saftyUserDao, dto);
	}
	@Override
	public void toAddUser(UserDto dto) {
		saftyUserDao.insertUser(dto);
	}
	@Override
	public boolean toAlterUser(UserDto dto) {
		if(saftyUserDao.alterUser(dto) != 0){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public User toGetUser(UserDto dto) {
		return saftyUserDao.getUser(dto);
	}
	@Override
	public void toDeleteUser(UserDto dto) {
		saftyUserDao.deleteUser(dto);
	}
	@Override
	public List<AccessRole> toGetRole(UserDto dto) {
		return saftyUserDao.getHasRole(dto);
	}
	@Override
	public void toAssignRole(String u_id, Integer ro_id) {
		saftyUserDao.AssignRole(u_id, ro_id);
	}
	@Override
	public void toUnAssignRole(String u_id, Integer ro_id) {
		saftyUserDao.UnAssignRole(u_id, ro_id);
	}
}

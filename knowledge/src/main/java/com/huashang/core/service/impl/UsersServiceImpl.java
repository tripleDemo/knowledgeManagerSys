package com.huashang.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huashang.core.mapper.UsersMapper;
import com.huashang.core.pojo.Users;
import com.huashang.core.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Users user) {
		return usersMapper.insert(user);
	}

	@Override
	public Users selectByPrimaryKey(String id) {
		return usersMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Users> selectAll() {
		return usersMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Users t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserPassword(String email, String encryptPwd) {
		return usersMapper.updateUserPassword(email, encryptPwd);
	}

	@Override
	public Users selectByUsername(String username) {
		return usersMapper.selectByUsername(username);
	}

	@Override
	public List<Users> likeByUsername(Long start, Integer pageSize, String username) {
		return usersMapper.likeByUsername(start, pageSize, username);
	}

}

package com.huashang.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashang.core.mapper.AdminsMapper;
import com.huashang.core.pojo.Admins;
import com.huashang.core.service.AdminsService;

@Service
public class AdminsServiceImpl implements AdminsService {
	@Autowired
	private AdminsMapper adminsMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Admins admin) {
		return adminsMapper.insert(admin);
	}

	@Override
	public Admins selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admins> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(Admins t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Admins selectByUsername(String username) {
		return adminsMapper.selectByUsername(username);
	}

}

package com.huashang.core.service;

import java.util.List;

import com.huashang.core.pojo.Users;

public interface UsersService extends BaseService<Users> {

	int updateUserPassword(String email, String encryptPwd);

	Users selectByUsername(String username);

	List<Users> likeByUsername(Long start, Integer pageSize, String username);

}

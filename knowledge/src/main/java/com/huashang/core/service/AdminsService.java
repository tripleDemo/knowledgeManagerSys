package com.huashang.core.service;

import com.huashang.core.pojo.Admins;

public interface AdminsService extends BaseService<Admins> {

	Admins selectByUsername(String username);

}

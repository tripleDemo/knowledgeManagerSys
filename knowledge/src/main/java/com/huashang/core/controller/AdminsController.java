package com.huashang.core.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.huashang.common.utils.JWTUtil;
import com.huashang.common.utils.Result;
import com.huashang.common.utils.StatusCode;
import com.huashang.core.pojo.Admins;
import com.huashang.core.service.AdminsService;

@CrossOrigin
@RestController
public class AdminsController {
	@Autowired
	private AdminsService adminsService;

	@Autowired
	private JWTUtil jWTUtil;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("/admin/login")
	public Result adminLogin(@RequestBody Map<String,String> requestMap){
		String username = requestMap.get("username");
		String password = requestMap.get("password");
		Admins admin = adminsService.selectByUsername(username);
		if(admin != null) {
			Boolean isMatches = bCryptPasswordEncoder.matches(password, admin.getAdminPassword());
			if(isMatches) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("admin", admin);
				String token = null;
				try{
					token = jWTUtil.createJWT(admin.getAdminId(), admin.getAdminUsername(), "admin");
				}catch (RuntimeException e){
					return new Result(false, StatusCode.TOKENERROR, "令牌生成失败");
				}
				map.put("token", token);
				return new Result(true, StatusCode.OK, "登录成功",map);
			}
		}
		return new Result(false, StatusCode.ERROR, "登录失败");			
	}

}

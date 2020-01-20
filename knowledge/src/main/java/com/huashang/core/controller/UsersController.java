package com.huashang.core.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.huashang.common.utils.EmailUtil;
import com.huashang.common.utils.JWTUtil;
import com.huashang.common.utils.JedisUtil;
import com.huashang.common.utils.Result;
import com.huashang.common.utils.StatusCode;
import com.huashang.core.dto.Retrieve;
import com.huashang.core.pojo.Users;
import com.huashang.core.service.UsersService;

@CrossOrigin
@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@Autowired 
	private EmailUtil emailUtil;

	@Autowired
	private JedisUtil.Strings jedisStrings;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private JWTUtil jWTUtil;
	
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * 验证码获取并存缓存
	 * @param email
	 * @return
	 */
	@PostMapping("/get/code")
	public Result sendAuthCodeEmail(@RequestBody Map<String,String> requestMap){
		String email = requestMap.get("email");
		String authCode = emailUtil.getAuthCode();  //生成随机验证码
		try {
			emailUtil.sendEmail(email,
					"尊敬的用户:你好! 企业知识库管理系统验证码为" + authCode); //邮箱发送验证码
			jedisStrings.setEx(email, 6000, authCode); //将验证码存入redis且有效时间为60秒
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, StatusCode.ERROR, "验证码发送失败");
		}
		return new Result(true, StatusCode.OK, "验证码发送成功");
	}

	/**
	 * 找回密码
	 * 验证码(忽略大小写)校验成功则修改用户密码，否则修改失败
	 * @param email
	 * @param newPassword
	 * @param code
	 * @return
	 */
	@PutMapping("/retrieve")
	public Result retrieve(@RequestBody Retrieve retrieve){
		try {
			String cacheCode = jedisStrings.get(retrieve.getEmail());//根据key从缓存获取记录
			if(cacheCode != null && cacheCode.equalsIgnoreCase(retrieve.getCode())) {
				//校验成功则执行密码修改
				String encryptPwd = bCryptPasswordEncoder.encode(retrieve.getNewPassword());//密码加密
				int updateNums = usersService.updateUserPassword(retrieve.getEmail(), encryptPwd);
				if(updateNums > 0) 
					return new Result(true, StatusCode.OK, "验证码校验成功且修改密码成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, StatusCode.ERROR, "验证码校验失败且修改密码失败");
		}
		return new Result(false, StatusCode.ERROR, "验证码校验失败且修改密码失败");
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @param code
	 * @return
	 */
	@PostMapping("/register")
	public Result register(@RequestBody Users user, @RequestParam("code") String code) {
		try {
			String cacheCode = jedisStrings.get(user.getEmail());//根据key从缓存获取记录
			if(cacheCode != null && cacheCode.equalsIgnoreCase(code)) {
				user.setCreatedAt(new Date());
				user.setUserId(String.valueOf(UUID.randomUUID()));
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));//密码加密
				int insertNums = usersService.insert(user);
				System.out.println(user);
				System.out.println(insertNums);
				if(insertNums > 0) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("user", user);
					String token = jWTUtil.createJWT(user.getUserId(), user.getUsername(), "user");
					map.put("token", token);
					return new Result(true, StatusCode.OK, "注册成功", map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, StatusCode.ERROR, "注册失败");
		}
		return new Result(false, StatusCode.ERROR, "注册失败");
	}

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public Result login(@RequestBody Map<String,String> requestMap){
		String username = requestMap.get("username");
		String password = requestMap.get("password");
		Users user = usersService.selectByUsername(username);
		if(user != null) {
			Boolean isMatches = bCryptPasswordEncoder.matches(password, user.getPassword());
			if(isMatches) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("user", user);
				String token = null;
				try{
					token = jWTUtil.createJWT(user.getUserId(), user.getUsername(), "user");
				}catch (RuntimeException e){
					return new Result(false, StatusCode.TOKENERROR, "令牌生成失败");
				}
				map.put("token", token);
				return new Result(true, StatusCode.OK, "登录成功",map);
			}
		}
		return new Result(false, StatusCode.ERROR, "登录失败");			
	}
	
	/**
	 * 根据用户名模糊查询分页获取用户数据(执行此操作的管理员需携带token)
	 * @param currentPage
	 * @param pageSize
	 * @param username
	 * @return
	 */
	@GetMapping("/user/{currentPage}/{pageSize}")
	public Result getUsersPageResultlikeByName(@PathVariable Long currentPage, 
			@PathVariable Integer pageSize, 
			@RequestParam("search") String username) {
		if(currentPage > 0 && pageSize > 0) {
			String token = (String) request.getAttribute("claims_admin");
			if(token != null && !"".equals(token)) { //拥有权限即可执行操作
				List<Users> users = usersService.likeByUsername((currentPage - 1) * pageSize, pageSize, username);
				Long total = (long) usersService.likeByUsername(null, null, username).size();
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("users", users);
				resultMap.put("total", total);
				return new Result(true, StatusCode.OK, "根据用户名模糊查询分页获取用户数据成功", resultMap);
			}else {
				return new Result(false, StatusCode.TOKENERROR, "权限不足");
			}
		}
		return new Result(false, StatusCode.ERROR, "根据用户名模糊查询分页获取用户数据失败");	
	}
}

package com.huashang.core.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import com.huashang.common.utils.JWTUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {
	@Autowired
	private JWTUtil jwtUtil;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//拦截器只是负责把请求头中token的令牌进行解析验证
		String token = request.getHeader("Authorization");
		if(token != null && !"".equals(token)){
			try{
				Claims claims = jwtUtil.parseJWT(token);
				String roles = (String) claims.get("roles");
				if(roles != null) {
					if(roles.equals("admin")){
						request.setAttribute("claims_admin", token);
					}else if(roles.equals("user")){
						request.setAttribute("claims_user", token);
					}
				}
			}catch (RuntimeException e){
				throw new RuntimeException("错误令牌");
			}
		}
		return true;
	}
}

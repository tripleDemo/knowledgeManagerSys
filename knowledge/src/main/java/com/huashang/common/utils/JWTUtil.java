package com.huashang.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 * JWT工具类
 */

public class JWTUtil {
	/**
	 * 盐
	 */
	private String key;

	/**
	 * 过期时间
	 */
	private long deadline;

	public JWTUtil() {}
	
    public JWTUtil(final String key, final long deadline) {
		super();
		this.key = key;
		this.deadline = deadline;
	}
    
	/**
	 * 生成JWT
	 * @param id
	 * @param subject
	 * @param roles
	 * @return
	 */
	public String createJWT(String id, String subject, String roles){
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		JwtBuilder builder = Jwts.builder().setId(id)
			.setSubject(subject)
			.setIssuedAt(now)
			.signWith(SignatureAlgorithm.HS256, key)
			.claim("roles", roles);
		if(deadline > 0){
			builder.setExpiration(new Date(nowMillis + deadline));
		}
		return builder.compact();
	}

	/**
	 * 解析JWT
	 * @param jwtStr
	 * @return
	 */
	public Claims parseJWT(String jwtStr){
		return Jwts.parser()
			.setSigningKey(key)
			.parseClaimsJws(jwtStr)
			.getBody();
	}
}


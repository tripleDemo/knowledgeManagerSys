package com.huashang.core.dto;

import java.io.Serializable;

/**
 * 找回密码接口接收的数据传输对象
 */
public class Retrieve implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	
	private String newPassword;
	
	private String code;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Retrieve [email=" + email + ", newPassword=" + newPassword + ", code=" + code + "]";
	}

}

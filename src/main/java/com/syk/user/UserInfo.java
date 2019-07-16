package com.syk.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class UserInfo {
	private String name;
	private String password;
	
	/*public UserInfo() {
		
	}*/
	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
}

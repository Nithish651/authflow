package com.financetracker.authflow.model;

import java.util.Set;

public class UserDetails {

	private String userName;
	private Set<String> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}

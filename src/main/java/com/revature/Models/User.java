package com.revature.Models;

public class User {

	public String username;
	public String password;
	public String name;
	public int permission;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

}

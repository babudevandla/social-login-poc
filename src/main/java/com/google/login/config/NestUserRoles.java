package com.google.login.config;

public enum NestUserRoles {

	ROLE_DEV(1,"ROLE_DEV"),
	ROLE_META(2,"ROLE_META"),
	ROLE_ADMIN(3,"ROLE_ADMIN");
	
	private int roleId;
	private String roleName;
	
	private NestUserRoles(int roleid, String roleName){
		this.roleId=roleid;
		this.roleName=roleName;
	}

	static NestUserRoles[] values=values();
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}

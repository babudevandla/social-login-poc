package com.google.login.config;

public enum UserRolesEnum {

	ROLE_SUPER_ADMIN(1,"ROLE_SUPER_ADMIN"),
	ROLE_ADMIN(2,"ROLE_ADMIN"),
	ROLE_CUST_SER(3,"ROLE_CUST_SER"),
	ROLE_FSYS_CUST(4,"ROLE_FSYS_CUST");
	
	private int roleId;
	private String roleName;
	
	private UserRolesEnum(int roleid, String roleName){
		this.roleId=roleid;
		this.roleName=roleName;
	}

	static UserRolesEnum[] values=values();
	
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

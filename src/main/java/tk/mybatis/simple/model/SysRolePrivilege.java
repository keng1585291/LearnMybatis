package tk.mybatis.simple.model;

public class SysRolePrivilege {
	/**
	 * ½ÇÉ«ID
	 */
	private Long roleId;
	
	/**
	 * È¨ÏÞID
	 */
	private Long privilegeId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
}

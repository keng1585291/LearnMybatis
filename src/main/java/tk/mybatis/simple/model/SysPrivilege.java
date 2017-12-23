package tk.mybatis.simple.model;

public class SysPrivilege {
	/**
	 * 权限ID
	 */
	private Long privilegeId;
	
	/**
	 * 权限名称
	 */
	private String privilegeName;
	
	/**
	 * 权限URL
	 */
	private String privilegeUrl;

	public Long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPrivilegeUrl() {
		return privilegeUrl;
	}

	public void setPrivilegeUrl(String privilegeUrl) {
		this.privilegeUrl = privilegeUrl;
	}
}

package tk.mybatis.simple.model;

import java.util.Date;

public class SysRole {
	/**
	 * 角色ID
	 */
	private Long roleId;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 有效标志
	 */
	private Long roleEnabled;
	
	/**
	 * 创建者
	 */
	private Long createBy;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 用户
	 * @return
	 */
	private SysUser user;
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getRoleEnabled() {
		return roleEnabled;
	}

	public void setRoleEnabled(Long roleEnabled) {
		this.roleEnabled = roleEnabled;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

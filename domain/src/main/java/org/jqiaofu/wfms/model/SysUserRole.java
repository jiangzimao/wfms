package org.jqiaofu.wfms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.jqiaofu.wfms.data.BaseEntity;

@Entity
@Table(name="sys_user_role")
@XmlRootElement(name = "SysUserRole")
public class SysUserRole extends BaseEntity<Integer> {
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name="user_role_id",length=20)
	private String userRoleId;

	@Column(name="user_id",length=20)
    private String userId;

	@Column(name="role_id",length=20)
    private String roleId;
	
	@Column(name="sys_code",length=50)
	private String sysCode;

	@Column(name="status",length=1,columnDefinition="CHAR")
    private String status;

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
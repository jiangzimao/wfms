package org.jqiaofu.wfms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.jqiaofu.wfms.data.BaseEntity;

@Entity
@Table(name="sys_role")
@XmlRootElement(name = "SysRole")
public class SysRole extends BaseEntity<Integer>{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name="role_id",length=20)
	private String roleId;

	@Column(name="role_code",length=64)
    private String roleCode;

	@Column(name="role_name",length=64)
    private String roleName;
	
	@Column(name="sys_code",length=50)
	private String sysCode;

	@Column(name="description",length=256)
    private String description;

	@Column(name="status",length=1,columnDefinition="CHAR")
    private String status;

	@Transient
    private String createUserName;

	@Transient
    private String updateUserName;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

}
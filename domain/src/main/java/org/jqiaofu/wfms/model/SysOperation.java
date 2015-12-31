package org.jqiaofu.wfms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.jqiaofu.wfms.data.BaseEntity;

@Entity
@Table(name="sys_operation")
@XmlRootElement(name = "SysOperation")
public class SysOperation extends BaseEntity<Integer> {
	
	@Transient
	private static final long serialVersionUID = 1724058126008678709L;

	@Column(name="operation_id",length=20)
    private String operationId;

	@Column(name="operation_code",length=50)
	private String operationCode;
	
	@Column(name="operation_type",length=20)
	private String operationType;
	
	@Column(name="sys_code",length=50)
	private String sysCode;

	@Column(name="menu_id",length=20)
    private String menuId;

	@Column(name="status",length=1,columnDefinition="CHAR")
    private String status;

    @Transient
    private SysRole sysRole;
	
    @Transient
	private SysMenu[] sysMenus;

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysMenu[] getSysMenus() {
		return sysMenus;
	}

	public void setSysMenus(SysMenu[] sysMenus) {
		this.sysMenus = sysMenus;
	}
}
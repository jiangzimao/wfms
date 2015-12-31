package org.jqiaofu.wfms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.jqiaofu.wfms.data.BaseEntity;

@Entity
@Table(name="sys_user")
@XmlRootElement(name = "SysUser")
public class SysUser extends BaseEntity<Integer>{
	
	@Transient
	private static final long serialVersionUID = -5927990368992484263L;
	
	@Column(name="user_id",length=20)
    private String userId;

	@Column(name="user_name",length=50)
    private String userName;
	
	@Column(name="real_name",length=50)
    private String realName;

	@Column(name="password",length=60)
    private String password;

	@Column(name="status",length=1,columnDefinition="CHAR")
    private Integer status;
	
	@Column(name="last_login_time", columnDefinition="DATE")
    private Date lastLoginTime;

	@Column(name="account_non_expired", length=1, columnDefinition="CHAR")
	private boolean accountNonExpired;

	@Column(name="account_non_locked", length=1, columnDefinition="CHAR")
	private boolean accountNonLocked;

	@Column(name="credentials_non_expired", length=1, columnDefinition="CHAR")
	private boolean credentialsNonExpired;

	@Column(name="enabled", length=1, columnDefinition="CHAR")
	private boolean enabled;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
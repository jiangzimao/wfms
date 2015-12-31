package org.jqiaofu.wfms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.jqiaofu.wfms.data.BaseEntity;

@Entity(name="sysMenu")
@Table(name="sys_menu")
@XmlRootElement(name = "SysMenu")
public class SysMenu extends BaseEntity<Integer>{

	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name="menu_id",length=20,updatable=false)
	private String menuId;

	@Column(name="menu_name",length=100)
	private String menuName;
	
	@Column(name="sys_code",length=50)
	private String sysCode;

	@Column(name="action_url",length=250)
	private String actionUrl;

	@Column(name="menu_level")
	private Long menuLevel;

	@Column(name="parent_id",length=20)
	private String parentId;

	@Column(name="isleaf")
	private Long isleaf;
	
	@Column(name="status",length=1,columnDefinition="CHAR")
	private String status;

	@Column(name="menu_seq",length=20)
	private String menuSeq;

	@Transient
	private List<SysMenu> children;
	
	@Column(name="checked",length=1,columnDefinition="CHAR")
	private String checked;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public Long getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Long menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Long getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(Long isleaf) {
		this.isleaf = isleaf;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(String menuSeq) {
		this.menuSeq = menuSeq;
	}

	public List<SysMenu> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenu> children) {
		this.children = children;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}
}
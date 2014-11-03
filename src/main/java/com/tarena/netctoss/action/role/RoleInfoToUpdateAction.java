package com.tarena.netctoss.action.role;

import java.util.List;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.manager.PrivilegeManager;
import com.tarena.netctoss.manager.RoleInfoManager;

/**
 * 角色修改 请求
 * 
 * @author Ivan
 * @since 2014-4-6
 */
public class RoleInfoToUpdateAction extends BaseAction {

	@Resource
	private RoleInfoManager roleInfoManager;
	@Resource
	private PrivilegeManager privilegeManager;

	private Integer id;
	private RoleInfo roleInfo;
	private List<Privilege> privileges;

	// 链接至修改角色页面
	public String toUpdate() throws Exception {
		roleInfo = roleInfoManager.get(id);
		privileges = privilegeManager.list();
		return SUCCESS;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}
}

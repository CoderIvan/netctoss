package com.tarena.netctoss.action.admin;

import java.util.List;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.bean.MyPager;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.manager.AdminInfoManager;
import com.tarena.netctoss.manager.PrivilegeManager;
import com.tarena.netctoss.manager.RoleInfoManager;

/**
 * 获取管理员列表 请求处理
 * 
 * @author Ivan
 * @since 2014-3-24
 */
public class AdminListAction extends BaseAction {
	@Resource
	private AdminInfoManager adminInfoManager;
	@Resource
	private RoleInfoManager roleInfoManager;
	@Resource
	private PrivilegeManager prvilegeManager;

	// input
	private Integer privilegeId;// 模块ID
	private Integer roleInfoId;// 角色名称

	// output
	private Pager adminInfoPager; // 管理员列表
	private List<RoleInfo> roleInfos; // 角色列表
	private List<Privilege> privileges;// 模块列表

	// 获取管理员列表
	public String list() throws Exception {
		adminInfoPager = adminInfoManager.list(new MyPager(httpRequest, 5), privilegeId, roleInfoId);
		roleInfos = roleInfoManager.list();
		privileges = prvilegeManager.list();
		return SUCCESS;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public Integer getPrivilegeId() {
		return privilegeId;
	}
	
	public void setRoleInfoId(Integer roleInfoId) {
		this.roleInfoId = roleInfoId;
	}
	
	public Integer getRoleInfoId() {
		return roleInfoId;
	}

	public Pager getAdminInfoPager() {
		return adminInfoPager;
	}

	public List<RoleInfo> getRoleInfos() {
		return roleInfos;
	}
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}
}

package com.tarena.netctoss.action.admin;

import java.util.List;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.manager.AdminInfoManager;
import com.tarena.netctoss.manager.RoleInfoManager;

/**
 * 处理管理员修改请求
 * 
 * @author Ivan
 * @since 2014-3-31
 */
public class AdminToUpdateAction extends BaseAction {
	@Resource
	private AdminInfoManager adminInfoManager;
	@Resource
	private RoleInfoManager roleInfoManager;

	/**
	 * 链接至管理员修改页面
	 * 
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-3-31
	 */
	private Integer id;
	private AdminInfo adminInfo;
	private List<RoleInfo> roleInfos;

	public String toUpdate() throws Exception {
		adminInfo = adminInfoManager.get(id);
		roleInfos = roleInfoManager.list();
		return SUCCESS;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AdminInfo getAdminInfo() {
		return adminInfo;
	}
	
	public List<RoleInfo> getRoleInfos() {
		return roleInfos;
	}
}

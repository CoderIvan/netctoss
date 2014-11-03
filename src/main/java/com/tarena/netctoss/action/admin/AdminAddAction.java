package com.tarena.netctoss.action.admin;

import java.util.List;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.manager.AdminInfoManager;
import com.tarena.netctoss.manager.RoleInfoManager;

/**
 * 添加管理员 请求处理
 * 
 * @author Ivan
 * @since 2014-3-24
 */
public class AdminAddAction extends BaseAction {
	@Resource
	private RoleInfoManager roleInfoManager;
	
	/**
	 * 处理链接至 添加管理员页面
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-3-29
	 */	
	private List<RoleInfo> roleInfos;
	
	public String toAdd() throws Exception {
		roleInfos = roleInfoManager.list();
		return SUCCESS;
	}
	
	public List<RoleInfo> getRoleInfos() {
		return roleInfos;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-3-29
	 */
	
	@Resource
	private AdminInfoManager adminInfoManager;
	private String name;
	private String adminCode;
	private String password;
	private String telephone;
	private String email;
	private Integer[] roleInfoId;
	
	public String add() throws Exception{
		return runAjaxJSON(new IAjaxJSONCB() {
			@Override
			public void run() throws Exception {
				AdminInfo adminInfo = new AdminInfo();
				adminInfo.setName(name);
				adminInfo.setAdminCode(adminCode);
				adminInfo.setPassword(password);
				adminInfo.setTelephone(telephone);
				adminInfo.setEmail(email);
				adminInfo.setRoleInfo(roleInfoId);
				adminInfoManager.save(adminInfo);
			}
		});
	}

	public void setRoleInfoManager(RoleInfoManager roleInfoManager) {
		this.roleInfoManager = roleInfoManager;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoleInfoId(Integer[] roleInfoId) {
		this.roleInfoId = roleInfoId;
	}
	
}

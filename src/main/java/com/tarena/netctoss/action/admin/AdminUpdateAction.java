package com.tarena.netctoss.action.admin;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.manager.AdminInfoManager;
/**
 * 更新管理员信息 请求
 * @author Ivan
 * @since 2014-4-1
 */
public class AdminUpdateAction extends BaseAction{
	@Resource
	private AdminInfoManager adminInfoManager;
	private String name;
	private Integer id;
	private String telephone;
	private String email;
	private Integer[] roleInfoIds;
	
	//更新管理员信息
	public String update() throws Exception{
		return runAjaxJSON(new IAjaxJSONCB(){
			@Override
			public void run() throws Exception {
				AdminInfo adminInfo = new AdminInfo();
				adminInfo.setName(name);
				adminInfo.setTelephone(telephone);
				adminInfo.setEmail(email);
				adminInfo.setRoleInfo(roleInfoIds);
				adminInfoManager.updateById(id, adminInfo);
			}
		});
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoleInfoIds(Integer[] roleInfoIds) {
		this.roleInfoIds = roleInfoIds;
	}
}

package com.tarena.netctoss.action.role;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.manager.RoleInfoManager;

/**
 * 角色更新请求
 * 
 * @author Ivan
 * @since 2014-4-6
 */
public class RoleInfoUpdateAction extends BaseAction {
	
	@Resource
	private RoleInfoManager roleInfoManager;

	private Integer id;
	private String name;
	private Integer[] privilegeId;
	
	/**
	 * 角色更新请求
	 * 
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-6
	 */
	public String update() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB() {
			@Override
			public void run() throws Exception {
				RoleInfo roleInfo = new RoleInfo();
				roleInfo.setName(name);
				roleInfo.setPrivilege(privilegeId);
				roleInfoManager.update(id, roleInfo);
			}
		});
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrivilegeId(Integer[] privilegeId) {
		this.privilegeId = privilegeId;
	}
}

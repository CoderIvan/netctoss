package com.tarena.netctoss.action.role;

import java.util.List;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.manager.PrivilegeManager;
import com.tarena.netctoss.manager.RoleInfoManager;

/**
 * 处理增加角色 请求
 * 
 * @author Ivan
 * @since 2014-4-4
 */
public class RoleInfoAddAction extends BaseAction {
	/**
	 * 链接至角色添加页面
	 * 
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-4
	 */
	@Resource
	private PrivilegeManager privilegeManager;
	private List<Privilege> privilege;

	public String toAdd() throws Exception {
		privilege = privilegeManager.list();
		return SUCCESS;
	}

	public List<Privilege> getPrivilege() {
		return privilege;
	}

	/**
	 * 添加角色
	 * 
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-4
	 */
	@Resource
	private RoleInfoManager roleInfoManager;
	private Integer[] privilegeId;
	private String name;

	public String add() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB() {
			@Override
			public void run() throws Exception {
				RoleInfo roleInfo = new RoleInfo();
				roleInfo.setName(name);
				roleInfo.setPrivilege(privilegeId);
				roleInfoManager.save(roleInfo);
			}
		});
	}

	public void setPrivilegeId(Integer[] privilegeId) {
		this.privilegeId = privilegeId;
	}

	public void setName(String name) {
		this.name = name;
	}
}

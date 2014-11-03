package com.tarena.netctoss.action.role;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.manager.RoleInfoManager;

/**
 * 删除角色 请求
 * 
 * @author Ivan
 * @since 2014-4-6
 */
public class RoleInfoDeleteAction extends BaseAction {

	@Resource
	private RoleInfoManager roleInfoManager;
	private Integer id;

	public String delete() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB() {
			@Override
			public void run() throws Exception {
				roleInfoManager.delete(id);
			}
		});
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

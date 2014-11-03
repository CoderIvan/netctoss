package com.tarena.netctoss.action.admin;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.manager.AdminInfoManager;

/**
 * 处理管理删除请求
 * 
 * @author Ivan
 * @since 2014-4-3
 */
public class AdminDeleteAction extends BaseAction {
	@Resource
	private AdminInfoManager adminInfoManager;

	private Integer id;

	// 删除管理员
	public String delete() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB() {
			@Override
			public void run() throws Exception {
				adminInfoManager.deleteById(id);
			}
		});
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

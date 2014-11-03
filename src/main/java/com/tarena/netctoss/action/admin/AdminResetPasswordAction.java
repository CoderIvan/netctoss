package com.tarena.netctoss.action.admin;

import java.util.List;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.manager.AdminInfoManager;

/**
 * 重置管理员密码 请求
 * 
 * @author Ivan
 * @since 2014-3-30
 */
public class AdminResetPasswordAction extends BaseAction {
	
	@Resource
	private AdminInfoManager adminInfoManager;
	
	private List<Integer> id;// 需要重置的管理员ID集合

	//批量重置密码请求
	public String reset() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB() {
			@Override
			public void run() throws Exception {
				adminInfoManager.updateByReset(id);
			}
		});
	}

	public List<Integer> getId() {
		return id;
	}

	public void setId(List<Integer> id) {
		this.id = id;
	}
}

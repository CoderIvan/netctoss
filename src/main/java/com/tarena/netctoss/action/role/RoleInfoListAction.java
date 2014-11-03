package com.tarena.netctoss.action.role;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.bean.MyPager;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.manager.RoleInfoManager;

/**
 * 获取所有RoleInfo列表 请求
 * 
 * @author Ivan
 * @since 2014-4-3
 */
public class RoleInfoListAction extends BaseAction {
	@Resource
	private RoleInfoManager roleInfoManager;
	
	private Pager roleInfoPager;

	// 获取RoleInfo列表
	public String index() throws Exception {
		roleInfoPager = roleInfoManager.list(new MyPager(httpRequest,5));
		return SUCCESS;
	}
	
	public Pager getRoleInfoPager() {
		return roleInfoPager;
	}
}

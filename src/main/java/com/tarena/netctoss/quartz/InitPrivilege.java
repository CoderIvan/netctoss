package com.tarena.netctoss.quartz;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.tarena.netctoss.manager.PrivilegeManager;

/**
 * 初始化权限
 * 
 * @author Ivan
 * @since 2014-4-7
 */
public class InitPrivilege {
	@Resource
	private PrivilegeManager privilegeManager;

	@PostConstruct
	public void init() throws Exception {
		privilegeManager.init();
	}
}

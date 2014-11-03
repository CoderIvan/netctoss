package com.tarena.netctoss.manager;

import com.tarena.netctoss.entity.AdminInfo;

public interface LoginManager {

	/**
	 * 根据用户名和密码登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户对象
	 * @throws Exception
	 */
	public AdminInfo login(String username, String password) throws Exception;
}

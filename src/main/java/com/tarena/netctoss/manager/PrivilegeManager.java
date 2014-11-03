package com.tarena.netctoss.manager;

import java.util.List;

import com.tarena.netctoss.entity.Privilege;

/**
 * 权限 业务逻辑
 * 
 * @author Ivan
 * 
 * @since 2013-10-22
 */
public interface PrivilegeManager {
	/**
	 * 获取所有权限
	 * 
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-6
	 */
	public List<Privilege> list() throws Exception;

	/**
	 * 根据XML文件，初始化数据中的权限数据
	 * 
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-7
	 */
	public void init() throws Exception;
}

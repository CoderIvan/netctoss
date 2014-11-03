package com.tarena.netctoss.dao;

import com.tarena.netctoss.entity.RoleInfo;

public interface RoleInfoDao extends BaseDao<RoleInfo, Integer> {
	/**
	 * 根据角色ID，获取角色对象
	 * 
	 * 同时关联权限
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-6
	 */
	public RoleInfo getByAll(Integer id) throws Exception;
}

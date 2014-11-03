package com.tarena.netctoss.dao;

import java.util.List;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.AdminInfo;

public interface AdminInfoDao extends BaseDao<AdminInfo, Integer> {

	/**
	 * 根据管理员ID，返回所有权限ID
	 * 
	 * @author Ivan
	 * 
	 * @param adminId
	 *            根据ID
	 * @return 权限ID集合
	 * @throws Exception
	 * @since 2013-9-17
	 */
	public List<Integer> getUrlsByAdminId(Integer adminId) throws Exception;

	/**
	 * 根据角色ID与权限ID，查找满足的管理员
	 * 
	 * 需要获取管理员，及关联其拥有的角色
	 * 
	 * @param pager
	 *            分页参数
	 * @param privilegeId
	 *            权限ID
	 * @param roleInfoId
	 *            角色ID
	 * @return
	 * @author Ivan
	 * @throws Exception
	 * @since 2014-3-27
	 */
	public Pager list(Pager pager, Integer privilegeId, Integer roleInfoId)
			throws Exception;
}

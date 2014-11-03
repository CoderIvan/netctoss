package com.tarena.netctoss.manager;

import java.util.List;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.RoleInfo;

/**
 * 角色 业务逻辑
 * 
 * @author Ivan
 * @since 2014-3-26
 */
public interface RoleInfoManager {

	/**
	 * 根据管理员ID，查找所有能访问的URL
	 * 
	 * @author Ivan
	 * 
	 * @param adminId
	 *            管理员ID
	 * @return 所有能访问的URL
	 * @since 2013-9-15
	 */
	public List<String> getURLByAdminId(Integer adminId) throws Exception;

	/**
	 * 获取所有角色集合
	 * 
	 * @return 角色集合
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-3-26
	 */
	public List<RoleInfo> list() throws Exception;

	/**
	 * 根据分页参数获取角色集合
	 * 
	 * @param pager
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-3
	 */
	public Pager list(Pager pager) throws Exception;

	/**
	 * 添加角色
	 * 
	 * @param roleInfo
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-5
	 */
	public Integer save(RoleInfo roleInfo) throws Exception;

	/**
	 * 根据ID获取角色
	 * 
	 * @return
	 * @throws Excetpion
	 * @author Ivan
	 * @since 2014-4-6
	 */
	public RoleInfo get(Integer id) throws Exception;

	/**
	 * 根据角色ID，更新角色内容
	 * 
	 * @param id
	 *            角色ID
	 * @param roleInfo
	 *            角色内容
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-6
	 */
	public void update(Integer id, RoleInfo roleInfo) throws Exception;

	/**
	 * 根据角色ID，删除角色
	 * 
	 * @param id
	 *            角色ID
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-6
	 */
	public void delete(Integer id) throws Exception;
}

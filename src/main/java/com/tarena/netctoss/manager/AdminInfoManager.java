package com.tarena.netctoss.manager;

import java.util.List;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.AdminInfo;

/**
 * 管理员模块 业务逻辑
 * 
 * @author Ivan
 * @since 2014-3-24
 */
public interface AdminInfoManager {

	/**
	 * 根据角色ID与权限ID，查找满足的管理员
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

	/**
	 * 根据ID，获取AdminInfo对象
	 * 
	 * @param id
	 *            管理员ID
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-3-29
	 */
	public AdminInfo get(Integer id) throws Exception;

	/**
	 * 添加管理员
	 * 
	 * @param adminInfo
	 * @author Ivan
	 * @throws Exception
	 * @since 2014-3-29
	 */
	public Integer save(AdminInfo adminInfo) throws Exception;

	/**
	 * 批量重置管理员密码
	 * 
	 * @param adminInfoId
	 *            管理员ID集合
	 * @throws Excetpion
	 * @author Ivan
	 * @since 2014-3-30
	 */
	public int updateByReset(List<Integer> adminInfoId) throws Exception;

	/**
	 * 根据管理员ID，更新管理员信息
	 * 
	 * @param adminInfoId
	 *            管理员ID
	 * @param adminInfo
	 *            封装需要更新的管理员信息内容
	 * @return 返回管理员ID
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-1
	 */
	public void updateById(Integer adminInfoId, AdminInfo adminInfo)
			throws Exception;

	/**
	 * 根据管理员ID，删除管理员
	 * 
	 * @param adminInfoId
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-3
	 */
	public void deleteById(Integer adminInfoId) throws Exception;

	/**
	 * 登录用户更新个人资料
	 * 
	 * @param adminInfo
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-7
	 */
	public void updateByItself(AdminInfo adminInfo) throws Exception;

	/**
	 * 登录用户更新个人密码
	 * 
	 * @param id 登录用户的个人ID
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-7
	 */
	public void updateByItself(Integer id , String oldPassword , String newPassword) throws Exception;
}

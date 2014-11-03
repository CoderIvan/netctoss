package com.tarena.netctoss.dao;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Service;

/**
 * 业务账号 持久化操作
 * 
 * @author Ivan
 * 
 */
public interface ServiceDao extends BaseDao<Service, Integer> {

	/**
	 * 根据传入条件，获取业务账务列表
	 * 
	 * @param accountIdcardNo
	 *            身份证号
	 * @param hostId
	 *            服务器ID
	 * @param osUsername
	 *            OS账号
	 * @param status
	 *            业务账号状态
	 * @param myPager
	 *            分页参数
	 * @return
	 */
	public Pager list(String accountIdcardNo, String hostId, String osUsername,
			String status, Pager pager) throws Exception;

	/**
	 * 暂停指定账务账号下的所有业务账号
	 * 
	 * @param accountId
	 *            指定的账号账号
	 * @return
	 * @throws Exception
	 */
	public int pauseServiceByAccountId(Integer accountId) throws Exception;

	/**
	 * 删除指定账务账号下的所有业务账号
	 * 
	 * @param accountId
	 *            指定的账号账号
	 * @return
	 * @throws Exception
	 */
	public int deleteServiceByAccountId(Integer accountId) throws Exception;
}

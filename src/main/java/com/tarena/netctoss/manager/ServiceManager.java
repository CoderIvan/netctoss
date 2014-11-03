package com.tarena.netctoss.manager;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Service;

/**
 * 业务信息逻辑管理
 * 
 * @author Ivan
 * 
 */
public interface ServiceManager {

	/**
	 * 根据ID，获取业务信息
	 * 
	 * @param id
	 *            业务信息ID
	 * @return 业务信息对象
	 * @throws Exception
	 */
	public Service get(Integer id) throws Exception;

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
	 * 根据传入的业务账号ID，暂停业务账号
	 * 
	 * @param serviceId
	 *            业务账号ID
	 * @throws Exception
	 */
	public void updateToPause(Integer serviceId) throws Exception;

	/**
	 * 根据传入的业务账号ID，开通业务账号
	 * 
	 * @param serviceId
	 *            业务账号ID
	 * @throws Exception
	 */
	public void updateToOpen(Integer serviceId) throws Exception;

	/**
	 * 根据传入的业务账号ID，删除业务账号
	 * 
	 * @param serviceId
	 *            业务账号ID
	 * @throws Exception
	 */
	public void updateToDelete(Integer serviceId) throws Exception;

	/**
	 * 根据转入的业务账号ID，记录需要更新的资费类型
	 * 
	 * @param serviceId
	 *            业务账号ID
	 * @param costId
	 *            需要更改为的资费ID
	 * @throws Exception
	 */
	public void update(Integer serviceId, Integer costId) throws Exception;
}

package com.tarena.netctoss.manager;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Account;

/**
 * 账务账号逻辑管理
 * 
 * @author Ivan
 * 
 * @since 2013-10-10
 */
public interface AccountManager {
	/**
	 * 根据条件，查找所有账号(分页)
	 * 
	 * @param idcardNo
	 *            身份证
	 * @param realName
	 *            真实姓名
	 * @param loginName
	 *            登录名
	 * @param status
	 *            状态
	 * @param pager
	 *            分页Bean
	 * @return
	 * @throws Exception
	 * @since 2013-10-10
	 */
	public Pager listByCondition(String idcardNo, String realName,
			String loginName, String status, Pager pager) throws Exception;

	/**
	 * 根据账号ID，暂停业务
	 * 
	 * @author Ivan
	 * 
	 * @param id
	 *            账号ID
	 * @throws Exception
	 * @since 2013-10-10
	 */
	public void updateStatusByPause(Integer id) throws Exception;

	/**
	 * 根据账号ID，开通业务
	 * 
	 * @author Ivan
	 * 
	 * @param id
	 *            账号ID
	 * @throws Exception
	 * @since 2013-10-10
	 */
	public void updateStatusByOpen(Integer id) throws Exception;

	/**
	 * 根据账号ID，删除业务
	 * 
	 * @author Ivan
	 * 
	 * @param id
	 *            账号ID
	 * @throws Exception
	 * @since 2013-10-10
	 */
	public void updateStatusByDelete(Integer id) throws Exception;

	/**
	 * 根据账号ID，查找账务账号
	 * 
	 * @author Ivan
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 * @since 2013-10-20
	 */
	public Account getById(Integer id) throws Exception;

	/**
	 * 根据账号ID，查找账务身份证号码
	 * 
	 * @author Ivan
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 * @since 2013-10-20
	 */
	public String getIdcardNoById(Integer id) throws Exception;

	/**
	 * 根据身份证号，查询账务账号ID
	 * 
	 * @param idcardNo
	 *            身份证号
	 * @return 账务账号ID
	 * @throws Exception
	 */
	public Integer getIdByIdcardNo(String idcardNo) throws Exception;

	/**
	 * 保存账务账号
	 * 
	 * @param account
	 * @throws Exception
	 */
	public void save(Account account) throws Exception;

	/**
	 * 更新账务账号资料
	 * 
	 * 如果需要更新密码，则需要另外输入原密码与新密码
	 * 
	 * @param account 原账号对象
	 * @param new_account 新账号资料
	 * @param isUpdatePassword 是否更新密码
	 * @throws Exception
	 */
	public void update(Account account, String oldPwd, String newPwd) throws Exception;
}

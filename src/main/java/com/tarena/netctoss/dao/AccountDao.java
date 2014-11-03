package com.tarena.netctoss.dao;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Account;

public interface AccountDao extends BaseDao<Account, Integer> {
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
	 */
	public Pager listByCondition(String idcardNo, String realName,
			String loginName, String status, Pager pager) throws Exception;

}

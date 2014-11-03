package com.tarena.netctoss.manager;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Bill;
import com.tarena.netctoss.entity.BillItem;

/**
 * 账单业务逻辑处理
 * 
 * @author Ivan
 * @since 2014-4-11
 */
public interface BillManager {
	/**
	 * 根据条件，获取账单列表
	 * 
	 * @param myPager
	 * @param idcardNo
	 *            身份证号
	 * @param loginName
	 *            账务账号名
	 * @param realName
	 *            名字
	 * @return
	 * @author Ivan
	 * @param month
	 * @param year
	 * @throws Exception
	 * @since 2014-4-12
	 */
	public Pager list(Pager pager, String idcardNo, String loginName,
			String realName, String year, String month) throws Exception;

	/**
	 * 根据账单ID，获取账单
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-12
	 */
	public Bill get(Integer id) throws Exception;

	/**
	 * 根据账单ID，查看账单明细
	 * 
	 * @param pager
	 * @param billId
	 *            账单ID
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-12
	 */
	public Pager listBillItem(Pager pager, Integer billId) throws Exception;

	/**
	 * 根据账单明细ID，获取账单明细
	 * 
	 * @param billItemId
	 *            账单明细ID
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-12
	 */
	public BillItem getBillItem(Integer billItemId) throws Exception;

	/**
	 * 根据账单明细ID，获取业务详单
	 * 
	 * @param pager
	 * @param billItemId
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-12
	 */
	public Pager listServiceDetail(Pager pager, Integer billItemId)
			throws Exception;
}

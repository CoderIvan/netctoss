package com.tarena.netctoss.manager.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.BillDao;
import com.tarena.netctoss.entity.Bill;
import com.tarena.netctoss.entity.BillItem;
import com.tarena.netctoss.manager.BillManager;

/**
 * 账单业务逻辑处理
 * 
 * @author Ivan
 * @since 2014-4-11
 */
@Service
public class BillManagerImpl implements BillManager {
	@Resource
	private BillDao billDao;

	@Override
	public Pager list(Pager pager, String idcardNo, String loginName,
			String realName, String year, String month) throws Exception {
		// 转入的month可能为"全部"
		if (!StringUtils.isNumeric(month)) {
			month = null;
		}
		return billDao.list(pager, idcardNo, loginName, realName, year, month);
	}

	@Override
	public Bill get(Integer id) throws Exception {
		return billDao.get(id);
	}

	@Override
	public Pager listBillItem(Pager pager, Integer billId) throws Exception {
		return billDao.listBillItem(pager, billId);
	}
	
	@Override
	public BillItem getBillItem(Integer billItemId) throws Exception {
		return billDao.getBillItem(billItemId);
	}
	
	@Override
	public Pager listServiceDetail(Pager pager , Integer billItemId) throws Exception{
		return billDao.listServiceDetail(pager, billItemId);
	}
}

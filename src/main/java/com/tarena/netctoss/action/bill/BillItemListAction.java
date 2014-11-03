package com.tarena.netctoss.action.bill;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.bean.MyPager;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Bill;
import com.tarena.netctoss.manager.BillManager;

/**
 * 查看账单详单列表 请求
 * 
 * @author Ivan
 * @since 2014-4-12
 */
public class BillItemListAction extends BaseAction {
	@Resource
	private BillManager billManager;
	// input
	private Integer billId;
	// output
	private Pager billItemPager;
	private Bill bill;

	public String billItem() throws Exception {
		bill = billManager.get(billId);
		billItemPager = billManager.listBillItem(new MyPager(httpRequest,5),billId);
		return SUCCESS;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Pager getBillItemPager() {
		return billItemPager;
	}

	public Bill getBill() {
		return bill;
	}
}

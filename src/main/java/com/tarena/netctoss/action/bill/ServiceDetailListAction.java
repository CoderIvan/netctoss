package com.tarena.netctoss.action.bill;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.bean.MyPager;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Bill;
import com.tarena.netctoss.entity.BillItem;
import com.tarena.netctoss.manager.BillManager;

public class ServiceDetailListAction extends BaseAction {

	@Resource
	private BillManager billManager;

	// input
	private Integer billItemId;
	// output
	private Bill bill;
	private BillItem billItem;
	private Pager serviceDetailPager;

	public String serviceDetail() throws Exception {
		billItem = billManager.getBillItem(billItemId);
		bill = billManager.get(billItem.getBillId());
		serviceDetailPager = billManager.listServiceDetail(new MyPager(httpRequest, 5), billItemId);
		return SUCCESS;
	}

	public void setBillItemId(Integer billItemId) {
		this.billItemId = billItemId;
	}

	public BillItem getBillItem() {
		return billItem;
	}

	public Bill getBill() {
		return bill;
	}

	public Pager getServiceDetailPager() {
		return serviceDetailPager;
	}
}

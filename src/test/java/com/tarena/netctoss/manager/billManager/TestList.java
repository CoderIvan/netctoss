package com.tarena.netctoss.manager.billManager;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Bill;
import com.tarena.netctoss.manager.BillManager;

public class TestList extends BaseConfig {
	@Resource
	private BillManager billManager;

	@SuppressWarnings("unchecked")
	@Test
	public void list() throws Exception {
		Pager pager = billManager.list(new Pager(5), null, null, null,null,null);
		for (Bill bill : (ArrayList<Bill>) pager.getList()) {
			System.err.println(bill);
		}
	}
}

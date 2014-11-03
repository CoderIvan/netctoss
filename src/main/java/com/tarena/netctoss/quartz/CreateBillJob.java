package com.tarena.netctoss.quartz;

import javax.annotation.Resource;

import com.tarena.netctoss.manager.ProcedureManager;

/**
 * 调用GBILL_ALL,UPDATE_SERVICE_COST
 * 
 * @author Ivan
 * @since 2014-4-12
 */
public class CreateBillJob {
	@Resource
	private ProcedureManager procedureManager;

	public void myJob() throws Exception {
		procedureManager.callGBillAll();
		procedureManager.callUpdateServiceCost();
	}
}

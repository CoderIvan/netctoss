package com.tarena.netctoss.manager;

/**
 * 存储过程调用 管理
 * 
 * @author Ivan
 * @since 2014-4-12
 */
public interface ProcedureManager {
	
	public void callGBillAll() throws Exception;
	
	public void callUpdateServiceCost() throws Exception;
}

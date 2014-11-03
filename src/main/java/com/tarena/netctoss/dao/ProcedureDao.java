package com.tarena.netctoss.dao;

/**
 * 存储过程 调用
 * 
 * @author Ivan
 * @since 2014-4-12
 */
public interface ProcedureDao {

	public void callGBillAll() throws Exception;

	public void callUpdateServiceCost() throws Exception;
}

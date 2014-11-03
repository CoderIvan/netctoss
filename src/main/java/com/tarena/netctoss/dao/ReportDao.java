package com.tarena.netctoss.dao;

import com.tarena.netctoss.bean.Pager;

/**
 * 报表 持久化层
 * 
 * @author Ivan
 * @since 2014-4-9
 */
public interface ReportDao {

	/**
	 * 获取每位客户每月的累计时长
	 * 
	 * @param pager
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-9
	 */
	public Pager findCustomerDuration(Pager pager) throws Exception;

	/**
	 * 获取每台服务器上累计时长最高的前三名客户
	 * 
	 * @param pager
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-9
	 */
	public Pager findDurationTopThree(Pager pager) throws Exception;

	/**
	 * 获取每台服务器每种资费标准的使用次数
	 * @param pager
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-9
	 */
	public Pager findHostUsed(Pager pager) throws Exception;
}

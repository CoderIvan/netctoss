package com.tarena.netctoss.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.ReportDao;
import com.tarena.netctoss.manager.ReportManager;

/**
 * 报表 业务处理逻辑
 * 
 * @author Ivan
 * @since 2014-4-9
 */
@Service
public class ReportManagerImpl implements ReportManager {
	@Resource
	private ReportDao reportDao;

	@Override
	public Pager findCustomerDuration(Pager pager) throws Exception {
		return reportDao.findCustomerDuration(pager);
	}
	
	@Override
	public Pager findDurationTopThree(Pager pager) throws Exception {
		return reportDao.findDurationTopThree(pager);
	}
	
	@Override
	public Pager findHostUsed(Pager pager) throws Exception {
		return reportDao.findHostUsed(pager);
	}
}

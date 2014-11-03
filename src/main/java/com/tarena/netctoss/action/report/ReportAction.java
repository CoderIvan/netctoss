package com.tarena.netctoss.action.report;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.bean.MyPager;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.manager.ReportManager;

/**
 * 报表查看 请求
 * 
 * @author Ivan
 * @since 2014-4-9
 */
public class ReportAction extends BaseAction {
	@Resource
	public ReportManager reportManager;
	private Pager pager;
	private String flag;

	public String index() throws Exception {
		if("02".equals(flag)){
			pager = reportManager.findDurationTopThree(new MyPager(httpRequest, 5));
		}else if("03".equals(flag)){
			pager = reportManager.findHostUsed(new MyPager(httpRequest, 5));
		}else{
			pager = reportManager.findCustomerDuration(new MyPager(httpRequest, 5));
		}
		return SUCCESS;
	}

	public Pager getPager() {
		return pager;
	}
	
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getFlag() {
		return flag;
	}
}

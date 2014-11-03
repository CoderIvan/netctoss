package com.tarena.netctoss.action.service;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.bean.MyPager;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.manager.ServiceManager;

/**
 * 查看业务账号列表请求处理
 * 
 * @author Ivan
 * 
 */
public class ServiceListAction extends BaseAction {
	@Resource
	private ServiceManager serviceManager;
	// input
	private String osUsername;
	private String hostId;
	private String accountIdcardNo;
	private String status;
	// output
	private Pager servicePager;

	// 查看业务账号列表
	public String index() throws Exception {
		servicePager = serviceManager.list(accountIdcardNo, hostId, osUsername,
				status, new MyPager(httpRequest, 5));
		return SUCCESS;
	}

	public Pager getServicePager() {
		return servicePager;
	}
	
	public String getAccountIdcardNo() {
		return accountIdcardNo;
	}
	
	public void setAccountIdcardNo(String accountIdcardNo) {
		this.accountIdcardNo = accountIdcardNo;
	}

	public String getOsUsername() {
		return osUsername;
	}

	public void setOsUsername(String osUsername) {
		this.osUsername = osUsername;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

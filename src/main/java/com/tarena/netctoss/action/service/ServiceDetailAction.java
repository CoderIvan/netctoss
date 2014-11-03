package com.tarena.netctoss.action.service;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Service;
import com.tarena.netctoss.manager.ServiceManager;

/**
 * 查看业务账号详情
 * 
 * @author Ivan
 * 
 */
public class ServiceDetailAction extends BaseAction {

	@Resource
	private ServiceManager serviceManager;
	private Integer id;
	private Service service;

	public String detail() throws Exception {
		service = serviceManager.get(id);
		return SUCCESS;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Service getService() {
		return service;
	}
}

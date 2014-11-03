package com.tarena.netctoss.action.service;

import java.util.List;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Cost;
import com.tarena.netctoss.entity.Service;
import com.tarena.netctoss.exception.ServiceException;
import com.tarena.netctoss.manager.CostManager;
import com.tarena.netctoss.manager.ServiceManager;

/**
 * 业务账号修改
 * 
 * @author Ivan
 * 
 */
public class ServiceUpdateAction extends BaseAction {
	@Resource
	private ServiceManager serviceManager;
	@Resource
	private CostManager costManager;

	// toUpdate
	private List<Cost> costs;
	private Integer serviceId;
	private Service service;
	// update
	private Integer costId;

	// 链接至更新页面
	public String toUpdate() throws Exception {
		service = serviceManager.get(serviceId);
		costs = costManager.list();
		return SUCCESS;
	}

	// 更新资费
	public String update() throws Exception {
		try {
			serviceManager.update(serviceId, costId);
			setAjaxJSON(true, null);
		} catch (ServiceException e) {
			setAjaxJSON(false, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			setAjaxJSON(false, "系统异常");
		}
		return JSON;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Service getService() {
		return service;
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}
}

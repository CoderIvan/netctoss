package com.tarena.netctoss.action.service;

import javax.annotation.Resource;

import com.tarena.netctoss.exception.ServiceException;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.manager.ServiceManager;

/**
 * 业务账号状态变更请求
 * 
 * @author Ivan
 * 
 */
public class ServiceStatusAction extends BaseAction {
	@Resource
	private ServiceManager serviceManager;

	private Integer serviceId;

	// 暂停业务
	public String pause() throws Exception {
		try {
			serviceManager.updateToPause(serviceId);
			setAjaxJSON(true, null);
		} catch (ServiceException e) {
			setAjaxJSON(false, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			setAjaxJSON(false, "系统异常");
		}
		return JSON;
	}

	// 开通业务
	public String open() throws Exception {
		try {
			serviceManager.updateToOpen(serviceId);
			setAjaxJSON(true, null);
		} catch (ServiceException e) {
			setAjaxJSON(false, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			setAjaxJSON(false, "系统异常");
		}
		return JSON;
	}

	// 删除业务
	public String delete() throws Exception {
		try {
			serviceManager.updateToDelete(serviceId);
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
}

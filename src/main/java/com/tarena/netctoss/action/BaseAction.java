package com.tarena.netctoss.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class BaseAction extends AjaxSupport implements Action, SessionAware,
		ServletRequestAware{

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 定义HttpServletRequest
	 */

	protected HttpServletRequest httpRequest;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.httpRequest = request;
	}

	/**
	 * 定义Session
	 */
	protected Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * 定义web的全局路径
	 */
	public String getBase() {
		return httpRequest.getScheme() + "://"+ httpRequest.getServerName() + ":" + httpRequest.getServerPort() + httpRequest.getContextPath();
	}
}

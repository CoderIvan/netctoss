package com.tarena.netctoss.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 拦截器
 * 
 * 检查用户是否拥有当前请求的权限
 * 
 * @author Ivan
 * @since 2014-4-7
 */
public class PowerInterceptor implements Interceptor {
	private static final long serialVersionUID = -8806061109152779053L;

	@Override
	public String intercept(ActionInvocation actioninvocation) throws Exception {
		String curr_url = ServletActionContext.getRequest().getServletPath();
		if(false){
			return "nopower";
		}
		return actioninvocation.invoke();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}
}
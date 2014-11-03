package com.tarena.netctoss.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tarena.netctoss.util.Const;

/**
 * 拦截器
 * 
 * 检查用户是否已登录
 * 
 * @author Ivan
 * @since 2014-4-7
 */
public class LoginInterceptor implements Interceptor {
	private static final long serialVersionUID = -4977563439868189363L;

	@Override
	public String intercept(ActionInvocation actioninvocation) throws Exception {
		Map<String, Object> session = actioninvocation.getInvocationContext().getSession();
		if (session.get(Const.SESSION_ADMIN_ID) == null) {
			return "login";
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
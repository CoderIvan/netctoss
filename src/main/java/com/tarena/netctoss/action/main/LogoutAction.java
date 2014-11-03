package com.tarena.netctoss.action.main;

import com.tarena.netctoss.action.BaseAction;

public class LogoutAction extends BaseAction {
	public String logout() throws Exception {
		httpRequest.getSession().invalidate();
		return LOGIN;
	}
}

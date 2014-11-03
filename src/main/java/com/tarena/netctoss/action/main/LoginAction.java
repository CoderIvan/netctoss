package com.tarena.netctoss.action.main;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.manager.LoginManager;
import com.tarena.netctoss.util.Const;

/**
 * 管理用户的登入、登出与验证码处理请求
 * 
 * @author Ivan
 */
public class LoginAction extends BaseAction {
	@Resource
	private LoginManager loginManager;

	private String username;// 登录名
	private String password;// 密码
	private String verifiCode;// 验证码

	// 处理登录请求
	public String login() throws Exception {
		// 检查验证码
		String code = (String) session.get(Const.SESSION_VERIFICATION_CODE);
		if (verifiCode != null && verifiCode.equalsIgnoreCase(code)) {
			// 验证用户名是否正确
			AdminInfo user = loginManager.login(username, password);
			if (user != null) {
				session.put(Const.SESSION_ADMIN_ID, user.getId());
				setAjaxJSON(true, getBase()+"/main");
			} else {
				setAjaxJSON(false, "用户名或密码错误，请重新输入");
			}
		} else {
			setAjaxJSON(false, "验证码错误，请重新输入");
		}
		return JSON;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setVerifiCode(String verifiCode) {
		this.verifiCode = verifiCode;
	}

}

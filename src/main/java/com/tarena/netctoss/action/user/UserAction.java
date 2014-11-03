package com.tarena.netctoss.action.user;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.manager.AdminInfoManager;
import com.tarena.netctoss.util.Const;

/**
 * 处理登录用户的请求
 * 
 * @author Ivan
 * @since 2014-4-7
 */
public class UserAction extends BaseAction {
	@Resource
	private AdminInfoManager adminInfoManager;

	/**
	 * 获取登录用户的资料信息
	 * 
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-7
	 */

	private AdminInfo adminInfo;

	public String info() throws Exception {
		Integer id = (Integer) session.get(Const.SESSION_ADMIN_ID);
		adminInfo = adminInfoManager.get(id);
		return SUCCESS;
	}

	public AdminInfo getAdminInfo() {
		return adminInfo;
	}

	/**
	 * 更新登录用户的资料信息
	 * 
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-7
	 */
	private String name;
	private String telephone;
	private String email;

	public String updateInfo() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB() {
			@Override
			public void run() throws Exception {
				AdminInfo adminInfo = new AdminInfo();
				adminInfo.setId((Integer) session.get(Const.SESSION_ADMIN_ID));
				adminInfo.setName(name);
				adminInfo.setTelephone(telephone);
				adminInfo.setEmail(email);
				adminInfoManager.updateByItself(adminInfo);
			}
		});
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 更新登录用户的密码信息
	 * 
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-4-7
	 */
	private String oldPassword;
	private String newPassword;

	public String updatePwd() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB() {
			@Override
			public void run() throws Exception {
				adminInfoManager.updateByItself((Integer) session.get(Const.SESSION_ADMIN_ID), oldPassword, newPassword);
			}
		});
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}

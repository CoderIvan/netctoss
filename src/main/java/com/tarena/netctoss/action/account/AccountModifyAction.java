package com.tarena.netctoss.action.account;

import java.util.Date;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.manager.AccountManager;

/**
 * 处理账务账号修改请求
 * 
 * @author Ivan
 * 
 */
public class AccountModifyAction extends BaseAction {
	@Resource
	private AccountManager accountManager;
	private Integer id;
	private String realName;
	private String idcardNo;
	private String loginName;
	private String telephone;
	private Integer recommenderId;
	private Date birthdate;
	private String email;
	private String mailaddress;
	private String zipcode;
	private String qq;

	private String isUpdatePassword;
	private String loginPassword;
	private String new_loginPassword;

	public String modify() throws Exception {
		Account account = new Account();
		account.setId(id);
		account.setRealName(realName);
		account.setIdcardNo(idcardNo);
		account.setLoginName(loginName);
		account.setTelephone(telephone);
		account.setRecommenderId(recommenderId);
		account.setBirthdate(birthdate);
		account.setEmail(email);
		account.setMailaddress(mailaddress);
		account.setZipcode(zipcode);
		account.setQq(qq);
		account.setLoginPassword(new_loginPassword);
		if("true".equals(isUpdatePassword)){
			accountManager.update(account, loginPassword, new_loginPassword);
		}else{
			accountManager.update(account, null, null);
		}
		return SUCCESS;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setRecommenderId(Integer recommenderId) {
		this.recommenderId = recommenderId;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void setNew_loginPassword(String new_loginPassword) {
		this.new_loginPassword = new_loginPassword;
	}

	public void setIsUpdatePassword(String isUpdatePassword) {
		this.isUpdatePassword = isUpdatePassword;
	}

}

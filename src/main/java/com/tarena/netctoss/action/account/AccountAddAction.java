package com.tarena.netctoss.action.account;

import java.util.Date;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.manager.AccountManager;

/**
 * 处理添加账务账号请求
 * 
 * @author Ivan
 * 
 */
public class AccountAddAction extends BaseAction {
	@Resource
	private AccountManager accountManager;

	private String realName;
	private String idcardNo;
	private String loginName;
	private String loginPassword;
	private String telephone;
	private Integer recommenderId;
	private Date birthdate;
	private String email;
	private String occupation;
	private String gender;
	private String mailaddress;
	private String zipcode;
	private String qq;

	// 链接至添加账务账号页面
	public String toAdd() throws Exception {
		return SUCCESS;
	}

	// 保存账务账号
	public String add() throws Exception {
		Account account = new Account();
		account.setRealName(realName);
		account.setIdcardNo(idcardNo);
		account.setLoginName(loginName);
		account.setLoginPassword(loginPassword);
		account.setTelephone(telephone);
		account.setRecommenderId(recommenderId);
		account.setBirthdate(birthdate);
		account.setEmail(email);
		account.setOccupation(occupation);
		account.setGender(gender);
		account.setMailaddress(mailaddress);
		account.setZipcode(zipcode);
		account.setQq(qq);
		accountManager.save(account);
		return SUCCESS;
	}

	public void setaccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
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

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
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

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

}

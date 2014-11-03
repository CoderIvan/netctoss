package com.tarena.netctoss.action.account;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.manager.AccountManager;

/**
 * 账务账号详情查看控制
 * 
 * @author Ivan
 * 
 * @since 2013-10-22
 */
public class AccountDetailAction extends BaseAction {
	@Resource
	private AccountManager accountManager;
	private Integer id;// 账务账号ID
	private Account account;// 账务账号对象
	private String idcardNo;// 身份证号

	// 查看账号详情
	public String detail() throws Exception {
		account = accountManager.getById(id);
		return SUCCESS;
	}

	// 根据推荐人身份证号查找推荐人ID
	public String getRecommenderId() throws Exception {
		id = accountManager.getIdByIdcardNo(idcardNo);
		return SUCCESS;
	}

	// 根据推荐人ID查找推荐人身份证号
	public String getRecommenderIdcardNo() throws Exception {
		idcardNo = accountManager.getIdcardNoById(id);
		return SUCCESS;
	}

	public Account getAccount() {
		return account;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

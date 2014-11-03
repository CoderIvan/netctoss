package com.tarena.netctoss.entity.report;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 记录 每位客户每月的累计时长 资料
 * 
 * @author Ivan
 * @since 2014-4-9
 */
@Entity
public class CustomerDuration {
	@Id
	private Integer id;
	private String loginName;
	private String realName;
	private String idcardNo;
	private String telephone;
	private String month;
	private Long duration;

	public CustomerDuration() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

}

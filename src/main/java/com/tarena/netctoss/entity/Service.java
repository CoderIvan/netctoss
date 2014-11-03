package com.tarena.netctoss.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * 业务信息表，客户申请了远程登录业务，即获得一个业务帐号 对应一台UNIX服务器上的 OS 帐号，即UNIX服务器的IP地址与OS帐号
 * 
 * @author Ivan
 * 
 */
@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SERVICE_ID_SQ", allocationSize = 1)
	private Integer id;
	@ManyToOne(fetch=FetchType.LAZY)
	private Account account;
	@ManyToOne(fetch=FetchType.LAZY)
	private Host host;
	@ManyToOne(fetch=FetchType.LAZY)
	private Cost cost;
	private String osUsername;
	private String loginPassword;
	private String status;
	private Date createDate;
	private Date pauseDate;
	private Date closeDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public String getOsUsername() {
		return osUsername;
	}

	public void setOsUsername(String osUsername) {
		this.osUsername = osUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getPauseDate() {
		return pauseDate;
	}

	public void setPauseDate(Date pauseDate) {
		this.pauseDate = pauseDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

}

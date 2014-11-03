package com.tarena.netctoss.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 帐务账号对象， 从帐务角度看客户，即自然人 ，称为帐务号
 * 
 * @author Ivan
 * 
 */
@Entity
public class Account {

	@Id
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "ACCOUNT_ID_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	private Integer id;// 账务账号
	private Integer recommenderId;// 推荐人账务账号ID
	private String loginName;// 登录NetCTOSS系统的名称,用于用户自服务
	private String loginPassword;// 登录NetCTOSS的口令
	private String status;// 账务账号状态 {"0":"开通","1":"暂停","2":"删除"}
	private Date createDate;// 创建日期
	private Date pauseDate;// 暂停日期（开通状态时为空）
	private Date closeDate;// 删除日期
	private String realName;// 客户姓名
	private String idcardNo;// 身份证号码
	private Date birthdate;// 出生日期
	private String gender;// 性别{"0":"男","1":女"}
	private String occupation;// 职业
	private String telephone;// 联系电话
	private String email;// 电子邮箱
	private String mailaddress;// 邮箱邮编
	private String zipcode;// 邮编
	private String qq;// QQ
	private Date lastLoginTime;// 最后一次登录时间
	private String lastLoginIp;// 最后一次登录IP地址

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRecommenderId() {
		return recommenderId;
	}

	public void setRecommenderId(Integer recommenderId) {
		this.recommenderId = recommenderId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMailaddress() {
		return mailaddress;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

}

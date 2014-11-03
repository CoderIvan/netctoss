package com.tarena.netctoss.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 * 管理员 实体类
 * 
 * @author Ivan
 */
@Entity
public class AdminInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "ADMININFO_ID_SQ", allocationSize = 1)
	private Integer id;// 主键，管理员ID
	@ManyToMany
	@JoinTable(name = "ADMIN_ROLE")
	private Set<RoleInfo> roleInfo;
	private String adminCode;// 管理员账号
	private String password; // 密码
	private String name;// 姓名
	private String telephone;// 电话
	private String email;// 电子邮件
	private Date enrollDate;// 创建日期

	public AdminInfo() {
		super();
	}

	public AdminInfo(Integer id, Set<RoleInfo> roleInfo, String adminCode,
			String password, String name, String telephone, String email,
			Date enrollDate) {
		super();
		this.id = id;
		this.roleInfo = roleInfo;
		this.adminCode = adminCode;
		this.password = password;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.enrollDate = enrollDate;
	}

	public AdminInfo(Integer id, Integer[] roleInfoIds, String adminCode,
			String password, String name, String telephone, String email,
			Date enrollDate) {
		super();
		this.id = id;
		setRoleInfo(roleInfoIds);
		this.adminCode = adminCode;
		this.password = password;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.enrollDate = enrollDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Set<RoleInfo> getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(Set<RoleInfo> roleInfo) {
		this.roleInfo = roleInfo;
	}

	// 重载原方法， RoleInfo的ID集合-->RoleInfo集合
	public void setRoleInfo(Integer[] roleInfoIds) {
		if(this.roleInfo == null){
			this.roleInfo = new HashSet<RoleInfo>();//TODO 用HashSet是否合适
		}else{
			this.roleInfo.clear();
		}
		// 无论情况下，要设置RoleInfo，都需要清空原集合
		if (roleInfoIds != null && roleInfoIds.length > 0) {
			for (Integer roleInfoId : roleInfoIds) {
				RoleInfo roleInfo = new RoleInfo();
				roleInfo.setId(roleInfoId);
				this.roleInfo.add(roleInfo);
			}
		}
	}
}

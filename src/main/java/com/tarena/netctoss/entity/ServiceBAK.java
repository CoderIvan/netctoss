package com.tarena.netctoss.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 保存业务账号的更新信息
 * 
 * @author Ivan
 * 
 */
@Entity
@Table(name = "SERVICE_UPDATE_BAK")
public class ServiceBAK {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SERVICE_UPDATE_BAK_ID", allocationSize = 1)
	private Integer id;
	private Integer serviceId;
	private String unixhost;
	private String osusername;
	private Date createDate;
	private Integer costId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getUnixhost() {
		return unixhost;
	}

	public void setUnixhost(String unixhost) {
		this.unixhost = unixhost;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCostId() {
		return costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	public String getOsusername() {
		return osusername;
	}

	public void setOsusername(String osusername) {
		this.osusername = osusername;
	}

}

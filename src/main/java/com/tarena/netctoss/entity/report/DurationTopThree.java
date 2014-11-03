package com.tarena.netctoss.entity.report;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 记录每台服务器上累计时长
 * 
 * @author Ivan
 * @since 2014-4-9
 */
@Entity
public class DurationTopThree {
	@Id
	private String unixHost;
	private String osUsername;
	private String realName;
	private String idcardNo;
	private Long duration;

	public DurationTopThree() {
	}

	public String getUnixHost() {
		return unixHost;
	}

	public void setUnixHost(String unixHost) {
		this.unixHost = unixHost;
	}

	public String getOsUsername() {
		return osUsername;
	}

	public void setOsUsername(String osUsername) {
		this.osUsername = osUsername;
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

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

}

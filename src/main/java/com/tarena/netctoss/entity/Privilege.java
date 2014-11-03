package com.tarena.netctoss.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 权限对象
 * 
 * @author Ivan
 * @since 2014-3-25
 */
@Entity
public class Privilege {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "PRIVILEGE_ID_SQ", allocationSize = 1)
	private Integer id; // 权限ID
	private String moduleName;// 权限名
	private String url;// 权限下可访问的地址

	public Privilege() {
		super();
	}

	public Privilege(Integer id){
		super();
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getUrls() {
		List<String> urls = null;
		if (url != null && url.startsWith("{") && url.endsWith("}")) {
			urls = Arrays.asList(url.substring(1, url.length() - 2).split(","));
		}
		return urls;
	}

	public void setUrls(List<String> urls) {
		if (urls != null && urls.size() != 0) {
			StringBuilder sb = new StringBuilder();

			sb.append("{");
			for (int i = 0; i < urls.size(); i++) {
				if (i == 0) {
					sb.append(urls.get(i));
				} else {
					sb.append(",").append(urls.get(i));
				}
			}
			sb.append("}");

			this.url = sb.toString();
		}
	}
}

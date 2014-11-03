package com.tarena.netctoss.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tarena.netctoss.entity.Privilege;

public class PrivilegeReader {
	
	private static final List<Privilege> privileges = new ArrayList<Privilege>();
	
	static {
		toModuleList();
	}

	/**
	 * 初始化权限对象集
	 * 
	 * @param xml
	 * @return
	 * @author Ivan
	 * @since 2014-3-25
	 */
	@SuppressWarnings("unchecked")
	private static void toModuleList() {
		InputStream xml = PrivilegeReader.class.getClassLoader().getResourceAsStream("privileges.xml");
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(xml);
			Element root = doc.getRootElement();
			List<Element> moduleElements = root.elements("privilege");

			for (Element moduleElement : moduleElements) {
				Integer id = Integer.parseInt(moduleElement.attributeValue("id"));// 权限的ID值
				String moduleName = moduleElement.elementText("name");// 权限的名称
				List<String> urls = new ArrayList<String>();// 可访问路径
				List<Element> urlElements = moduleElement.element("urls").elements();
				for (Element element : urlElements) {
					urls.add(element.getText());
				}
				
				Privilege privilege = new Privilege();
				privilege.setId(id);
				privilege.setModuleName(moduleName);
				privilege.setUrls(urls);
				privileges.add(privilege);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Privilege> getPrivileges() {
		return privileges;
	}
}

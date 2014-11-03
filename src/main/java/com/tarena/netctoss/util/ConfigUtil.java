package com.tarena.netctoss.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

	private static final String path;
	private static Properties props;

	static {
		String pptName = "/Note_Orcale.properties";
		String classPath = ConfigUtil.class.getPackage().getName().replaceAll("\\.", "/");
		path = classPath + pptName;
		props = new Properties();
		ClassLoader loader = ConfigUtil.class.getClassLoader();
		InputStream is = loader.getResourceAsStream(path);
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}

	// public static void main(String[] args) {
	// System.out.println(getValue("DBDRIVER"));
	// System.out.println(getValue("DBURL"));
	// System.out.println(getValue("DBUSER"));
	// System.out.println(getValue("DBPASS"));
	// }
}

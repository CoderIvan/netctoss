package com.tarena.netctoss.util;

public class DAOFactory {
	public static Object getInstance(String name) {
		Object obj = null;
		try {
			String classname = ConfigUtil.getValue(name);
			obj = Class.forName(classname).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

package com.tarena.netctoss.manager.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.netctoss.dao.AdminInfoDao;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.manager.LoginManager;

@Service
public class LoginManagerImpl implements LoginManager {
	@Resource
	private AdminInfoDao adminInfoDao;

	@Override
	public AdminInfo login(String username, String password) throws Exception {
		HashMap<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("adminCode", username);
		proMap.put("password", password);
		return adminInfoDao.get(proMap);
	}
}

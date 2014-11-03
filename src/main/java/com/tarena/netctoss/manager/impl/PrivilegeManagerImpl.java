package com.tarena.netctoss.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.netctoss.dao.PrivilegeDao;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.manager.PrivilegeManager;
import com.tarena.netctoss.util.PrivilegeReader;

@Service
public class PrivilegeManagerImpl implements PrivilegeManager {
	@Resource
	private PrivilegeDao privilegeDao;

	@Override
	public List<Privilege> list() throws Exception {
		return privilegeDao.list();
	}

	@Override
	public void init() throws Exception {
		List<Privilege> privileges = PrivilegeReader.getPrivileges();
		for (Privilege privilege : privileges) {
			privilegeDao.saveOrUpdate(privilege);
		}
	}
}

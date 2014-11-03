package com.tarena.netctoss.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.RoleInfoDao;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.exception.ServiceException;
import com.tarena.netctoss.manager.RoleInfoManager;
import com.tarena.netctoss.util.Const;

@Service
public class RoleInfoManagerImpl implements RoleInfoManager {
	@Resource
	private RoleInfoDao roleInfoDao;

	@Override
	public List<String> getURLByAdminId(Integer adminId) throws Exception {
		return null;
	}

	@Override
	public List<RoleInfo> list() throws Exception {
		return roleInfoDao.list();
	}

	@Override
	public Pager list(Pager pager) throws Exception {
		Map<String, String> sortMap = new HashMap<String, String>();
		sortMap.put("id", Const.SORT_ASC);
		return roleInfoDao.listBySortMap(pager, sortMap);
	}

	@Override
	public Integer save(RoleInfo roleInfo) throws Exception {
		HashMap<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("name", roleInfo.getName());
		RoleInfo _roleInfo = roleInfoDao.get(proMap);
		if (_roleInfo == null) {
			return roleInfoDao.save(roleInfo);
		} else {
			throw new ServiceException("该角色名已存在");
		}
	}
	
	@Override
	public RoleInfo get(Integer id) throws Exception {
		return roleInfoDao.getByAll(id);
	}
	
	@Override
	public void update(Integer id, RoleInfo roleInfo) throws Exception {
		RoleInfo _roleInfo = roleInfoDao.get(id);
		if (_roleInfo != null) {
			if (!_roleInfo.getName().equals(roleInfo.getName())) {// 如果更新了角色名，需检查是否与其它角色名重复
				HashMap<String, Object> proMap = new HashMap<String, Object>();
				proMap.put("name", roleInfo.getName());
				if (roleInfoDao.get(proMap) != null) {
					throw new ServiceException("该角色名已存在");
				}
			}
			_roleInfo.setName(roleInfo.getName());
			_roleInfo.setPrivilege(roleInfo.getPrivilege());
			roleInfoDao.update(_roleInfo);
		} else {
			throw new ServiceException("该角色不存在");
		}
	}
	
	@Override
	public void delete(Integer id) throws Exception{
		roleInfoDao.delete(id);
	}
}

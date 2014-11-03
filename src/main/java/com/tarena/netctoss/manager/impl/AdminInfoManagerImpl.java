package com.tarena.netctoss.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.AdminInfoDao;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.exception.ServiceException;
import com.tarena.netctoss.manager.AdminInfoManager;

@Service
public class AdminInfoManagerImpl implements AdminInfoManager {
	@Resource
	private AdminInfoDao adminInfoDao;

	@Override
	public Pager list(Pager pager, Integer privilegeId, Integer roleInfoId)
			throws Exception {
		if (new Integer(-1).equals(privilegeId)) {
			privilegeId = null;
		}
		if (new Integer(-1).equals(roleInfoId)) {
			roleInfoId = null;
		}
		return adminInfoDao.list(pager, privilegeId, roleInfoId);
	}

	@Override
	public AdminInfo get(Integer id) throws Exception {
		return adminInfoDao.get(id);
	}

	@Override
	public Integer save(AdminInfo adminInfo) throws Exception {
		AdminInfo _adminInfo = new AdminInfo();
		_adminInfo.setName(adminInfo.getName());
		_adminInfo.setAdminCode(adminInfo.getAdminCode());
		_adminInfo.setPassword(adminInfo.getPassword());
		_adminInfo.setTelephone(adminInfo.getTelephone());
		_adminInfo.setEmail(adminInfo.getEmail());
		_adminInfo.setRoleInfo(adminInfo.getRoleInfo());
		_adminInfo.setEnrollDate(new Date());
		return adminInfoDao.save(_adminInfo);
	}

	@Override
	public int updateByReset(List<Integer> adminInfoId) throws Exception {
		if (adminInfoId != null && adminInfoId.size() != 0) {
			Map<String, Object> setMap = new HashMap<String, Object>();
			setMap.put("password", "111111");
			Map<String, Object> proMap = new HashMap<String, Object>();
			proMap.put("id", adminInfoId);
			return adminInfoDao.updateByMap(setMap, proMap);
		} else {
			throw new ServiceException("未选择任何需要重置密码的账号");
		}
	}

	@Override
	public void updateById(Integer adminInfoId, AdminInfo adminInfo)
			throws Exception {
		AdminInfo _adminInfo = adminInfoDao.get(adminInfoId);
		if (_adminInfo != null) {
			_adminInfo.setName(adminInfo.getName());
			_adminInfo.setTelephone(adminInfo.getTelephone());
			_adminInfo.setEmail(adminInfo.getEmail());
			_adminInfo.setRoleInfo(adminInfo.getRoleInfo());
			adminInfoDao.update(_adminInfo);
		} else {
			throw new ServiceException("不存在该管理员");
		}
	}
	
	@Override
	public void deleteById(Integer adminInfoId) throws Exception {
		AdminInfo _adminInfo = adminInfoDao.get(adminInfoId);
		if (_adminInfo != null) {
			adminInfoDao.delete(_adminInfo);
		} else {
			throw new ServiceException("不存在该管理员");
		}
	}
	
	@Override
	public void updateByItself(AdminInfo adminInfo) throws Exception {
		if(adminInfo.getId() != null){
			AdminInfo _adminInfo = adminInfoDao.get(adminInfo.getId());
			if(_adminInfo != null){
				_adminInfo.setName(adminInfo.getName());
				_adminInfo.setTelephone(adminInfo.getTelephone());
				_adminInfo.setEmail(adminInfo.getEmail());
				adminInfoDao.update(_adminInfo);
			}else{
				throw new ServiceException("不存在该管理员");
			}
		}else{
			throw new ServiceException("尚未登录");
		}
	}
	
	@Override
	public void updateByItself(Integer id, String oldPassword, String newPassword) throws Exception {
		if(id == null){
			throw new ServiceException("尚未登录");
		}
		AdminInfo _adminInfo = adminInfoDao.get(id);
		if(_adminInfo == null){
			throw new ServiceException("不存在该管理员");
		}
		if(oldPassword == null || !oldPassword.equals(_adminInfo.getPassword())){
			throw new ServiceException("原密码输入错误");
		}
		_adminInfo.setPassword(newPassword);
		adminInfoDao.update(_adminInfo);
	}
}

package com.tarena.netctoss.manager.impl;

import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.ServiceBAKDao;
import com.tarena.netctoss.dao.ServiceDao;
import com.tarena.netctoss.entity.Service;
import com.tarena.netctoss.entity.ServiceBAK;
import com.tarena.netctoss.exception.ServiceException;
import com.tarena.netctoss.manager.ServiceManager;
import com.tarena.netctoss.util.Const;

@org.springframework.stereotype.Service
public class ServiceManagerImpl implements ServiceManager {
	@Resource
	private ServiceDao serviceDao;
	@Resource
	private ServiceBAKDao serviceBAKDao;

	@Override
	public Service get(Integer id) throws Exception {
		return serviceDao.get(id);
	}

	@Override
	public Pager list(String accountIdcardNo, String hostId, String osUsername,
			String status, Pager pager) throws Exception {
		return serviceDao.list(accountIdcardNo, hostId, osUsername, status,
				pager);
	}

	@Override
	public void updateToPause(Integer serviceId) throws Exception {
		Service service = serviceDao.get(serviceId);
		if (service != null) {
			if (Const.SERVICE_STATUS_OPEN.equals(service.getStatus())) {
				service.setStatus(Const.SERVICE_STATUS_PAUSE);
				service.setPauseDate(new Date());// 暂停后，记载暂停时间
				serviceDao.update(service);
			} else if (Const.SERVICE_STATUS_PAUSE.equals(service.getStatus())) {
				throw new ServiceException("该业务账号已经暂停");
			} else if (Const.SERVICE_STATUS_DELETE.equals(service.getStatus())) {
				throw new ServiceException("该业务账号已经删除");
			} else {
				throw new ServiceException("该业务账号状态异常，请联系管理员");
			}
		} else {
			new ServiceException("不存在该业务账号");
		}
	}

	@Override
	public void updateToOpen(Integer serviceId) throws Exception {
		Service service = serviceDao.get(serviceId);
		if (service != null) {
			if (Const.SERVICE_STATUS_PAUSE.equals(service.getStatus())) {
				String accountStatus = service.getAccount().getStatus();
				if (accountStatus.equals(Const.ACCOUNT_STATUS_OPEN)) {
					service.setStatus(Const.SERVICE_STATUS_OPEN);
					service.setPauseDate(null);// 重新开通后，删除暂停时间
					serviceDao.update(service);
				} else if (accountStatus.equals(Const.ACCOUNT_STATUS_PAUSE)) {
					throw new ServiceException("暂停状态的账务账号下属的业务账号不能被开通");
				} else if (accountStatus.equals(Const.ACCOUNT_STATUS_DELETE)) {
					throw new ServiceException("删除状态的账务账号下属的业务账号不能被开通");
				} else {
					throw new ServiceException("该业务账号所属的账务账号状态异常，请联系管理员");
				}
			} else if (Const.SERVICE_STATUS_OPEN.equals(service.getStatus())) {
				throw new ServiceException("该业务账号已经开通");
			} else if (Const.SERVICE_STATUS_DELETE.equals(service.getStatus())) {
				throw new ServiceException("该业务账号已经删除");
			} else {
				throw new ServiceException("该业务账号状态异常，请联系管理员");
			}
		} else {
			new ServiceException("不存在该业务账号");
		}
	}

	@Override
	public void updateToDelete(Integer serviceId) throws Exception {
		Service service = serviceDao.get(serviceId);
		if (service != null) {
			if (Const.SERVICE_STATUS_PAUSE.equals(service.getStatus()) || Const.SERVICE_STATUS_OPEN.equals(service.getStatus())) {
				service.setStatus(Const.SERVICE_STATUS_DELETE);
				service.setCloseDate(new Date());// 删除后，记载删除时间
				serviceDao.update(service);
			} else if (Const.SERVICE_STATUS_DELETE.equals(service.getStatus())) {
				throw new ServiceException("该业务账号已经删除");
			} else {
				throw new ServiceException("该业务账号状态异常，请联系管理员");
			}
		} else {
			new ServiceException("不存在该业务账号");
		}
	}

	@Override
	public void update(Integer serviceId, Integer costId) throws Exception {
		Service service = serviceDao.get(serviceId);
		if (service != null) {
			HashMap<String, Object> proMap = new HashMap<String, Object>();
			proMap.put("serviceId", serviceId);
			ServiceBAK serviceBAK = serviceBAKDao.get(proMap);// 查找Service_Update_BAK表是否已经存在该业务的更新信息
			if (serviceBAK == null) {// 如果原来不存在资费变更的记录，则创建
				serviceBAK = new ServiceBAK();
			}
			serviceBAK.setServiceId(serviceId);
			serviceBAK.setCostId(costId);
			serviceBAK.setUnixhost(service.getHost().getId());
			serviceBAK.setOsusername(service.getOsUsername());
			serviceBAK.setCreateDate(new Date());
			serviceBAKDao.saveOrUpdate(serviceBAK);
		} else {
			new ServiceException("不存在该业务账号");
		}
	}
}

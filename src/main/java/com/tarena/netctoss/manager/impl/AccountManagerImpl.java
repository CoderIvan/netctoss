package com.tarena.netctoss.manager.impl;

import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.AccountDao;
import com.tarena.netctoss.dao.ServiceDao;
import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.exception.ServiceException;
import com.tarena.netctoss.manager.AccountManager;
import com.tarena.netctoss.util.Const;

@Service
public class AccountManagerImpl implements AccountManager {
	@Resource
	private AccountDao accountDao;
	@Resource
	private ServiceDao serviceDao;

	@Override
	public Pager listByCondition(String idcardNo, String realName,
			String loginName, String status, Pager pager) throws Exception {
		return accountDao.listByCondition(idcardNo, realName, loginName,
				status, pager);
	}

	@Override
	public void updateStatusByPause(Integer id) throws Exception {
		Account account = accountDao.get(id);
		if (account != null) {
			String status = account.getStatus();
			if (Const.ACCOUNT_STATUS_OPEN.equals(status)) {
				account.setStatus(Const.ACCOUNT_STATUS_PAUSE);// 暂停账号业务
				account.setPauseDate(new Date());// 暂停后，记载暂停时间
				serviceDao.pauseServiceByAccountId(id);// 暂停账务账号，同时暂停下属的所有业务账号
				accountDao.update(account);
			} else if (Const.ACCOUNT_STATUS_PAUSE.equals(status)) {
				throw new ServiceException("该业务账号已经暂停");
			} else if (Const.ACCOUNT_STATUS_DELETE.equals(status)) {
				throw new ServiceException("该业务账号已经删除");
			} else {
				throw new ServiceException("该业务账号状态异常");
			}
		} else {
			throw new ServiceException("不存在该业务账号");
		}
	}

	@Override
	public void updateStatusByOpen(Integer id) throws Exception {
		Account account = accountDao.get(id);
		if (account != null) {
			String status = account.getStatus();
			if (Const.ACCOUNT_STATUS_PAUSE.equals(status)) {
				account.setStatus(Const.ACCOUNT_STATUS_OPEN);// 开通账号业务
				account.setPauseDate(null);// 重新开通后，删除暂停时间
				accountDao.update(account);
			} else if (Const.ACCOUNT_STATUS_OPEN.equals(status)) {
				throw new ServiceException("该业务账号已经开通");
			} else if (Const.ACCOUNT_STATUS_DELETE.equals(status)) {
				throw new ServiceException("该业务账号已经删除");
			} else {
				throw new ServiceException("该业务账号状态异常");
			}
		} else {
			throw new ServiceException("不存在该业务账号");
		}
	}

	@Override
	public void updateStatusByDelete(Integer id) throws Exception {
		Account account = accountDao.get(id);
		if (account != null) {
			String status = account.getStatus();
			if (Const.ACCOUNT_STATUS_OPEN.equals(status) || Const.ACCOUNT_STATUS_PAUSE.equals(status)) {
				account.setStatus(Const.ACCOUNT_STATUS_DELETE);// 删除账号业务，标示为删除，不能再开通、修改、删除；
				account.setCloseDate(new Date());// 删除后，记载删除时间
				serviceDao.deleteServiceByAccountId(id);// 删除账务账号，同时删除下属的所有业务账号
				accountDao.update(account);
			} else if (Const.ACCOUNT_STATUS_DELETE.equals(status)) {
				throw new ServiceException("该业务账号已经删除");
			} else {
				throw new ServiceException("该业务账号状态异常");
			}
		} else {
			throw new ServiceException("不存在该业务账号");
		}
	}

	@Override
	public String getIdcardNoById(Integer id) throws Exception {
		Account account = accountDao.get(id);
		if (account == null) {
			return null;
		} else {
			return account.getIdcardNo();
		}
	}

	@Override
	public Account getById(Integer id) throws Exception {
		return accountDao.get(id);
	}

	@Override
	public Integer getIdByIdcardNo(String idcardNo) throws Exception {
		HashMap<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("idcardNo", idcardNo);
		proMap.put("status", Const.ACCOUNT_STATUS_OPEN);
		Account account = accountDao.get(proMap);
		if (account == null) {
			return null;
		} else {
			return account.getId();
		}
	}

	@Override
	public void save(Account account) throws Exception {
		Account account_temp = new Account();
		account_temp.setRealName(account.getRealName());
		account_temp.setIdcardNo(account.getIdcardNo());
		account_temp.setLoginName(account.getLoginName());
		account_temp.setLoginPassword(account.getLoginPassword());
		account_temp.setTelephone(account.getTelephone());
		account_temp.setRecommenderId(account.getRecommenderId());
		account_temp.setBirthdate(account.getBirthdate());
		account_temp.setEmail(account.getEmail());
		account_temp.setOccupation(account.getOccupation());
		account_temp.setGender(account.getGender());
		account_temp.setMailaddress(account.getMailaddress());
		account_temp.setZipcode(account.getZipcode());
		account_temp.setQq(account.getQq());
		account_temp.setStatus(Const.ACCOUNT_STATUS_OPEN);
		account_temp.setCreateDate(new Date());
		accountDao.save(account_temp);
	}

	@Override
	public void update(Account account, String oldPwd, String newPwd) throws Exception{
		Account oldAccount = accountDao.get(account.getId());
		if(oldAccount != null){
			if(StringUtils.isNotEmpty(oldPwd) && StringUtils.isNotEmpty(newPwd)){//需要更新密码
				if(oldPwd.equals(oldAccount.getLoginPassword())){
					oldAccount.setLoginPassword(newPwd);
				}else{
					throw new ServiceException("旧密码输入错误，请重新输入");
				}
			}
			oldAccount.setRealName(account.getRealName());
			oldAccount.setIdcardNo(account.getIdcardNo());
			oldAccount.setLoginName(account.getLoginName());
			oldAccount.setTelephone(account.getTelephone());
			oldAccount.setRecommenderId(account.getRecommenderId());
			oldAccount.setBirthdate(account.getBirthdate());
			oldAccount.setEmail(account.getEmail());
			oldAccount.setMailaddress(account.getMailaddress());
			oldAccount.setZipcode(account.getZipcode());
			oldAccount.setQq(account.getQq());
			accountDao.update(oldAccount);
		}else{
			throw new ServiceException("不存在该账务账号");
		}
	}
}

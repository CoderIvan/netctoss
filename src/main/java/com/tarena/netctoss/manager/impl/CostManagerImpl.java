package com.tarena.netctoss.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.CostDao;
import com.tarena.netctoss.entity.Cost;
import com.tarena.netctoss.exception.ServiceException;
import com.tarena.netctoss.manager.CostManager;
import com.tarena.netctoss.util.Const;

@Service
public class CostManagerImpl implements CostManager {
	@Resource
	private CostDao costDao;

	@Override
	public Pager list(Pager pager, String sortKey, String sortValue)
			throws Exception {
		Map<String, String> sortMap = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(sortKey)
				&& StringUtils.isNotEmpty(sortValue)) {
			sortMap.put(sortKey, sortValue);
		} else {
			sortMap.put("id", Const.SORT_ASC);
		}
		return costDao.list(pager, null, sortMap);
	}

	@Override
	public void save(String name, String costType, Integer baseDuration,
			Float baseCost, Float unitCost, String descr) throws Exception {
		HashMap<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("name", name);
		Cost oldCost = costDao.get(proMap);
		if (oldCost == null) {
			Cost cost = new Cost();
			cost.setName(name);
			cost.setCostType(costType);
			cost.setBaseDuration(baseDuration);
			cost.setBaseCost(baseCost);
			cost.setUnitCost(unitCost);
			cost.setDescr(descr);
			// 创建资费时，状态为暂停，记载创建时间；
			cost.setStatus(Const.COST_STATUS_PAUSE);
			cost.setCreateTime(new Date());
			clearupCost(cost);//根据套餐类型，规范数据
			costDao.save(cost);
		} else {
			throw new ServiceException("该资费名已存在");
		}
	}

	@Override
	public void delete(Integer id) throws Exception {
		Cost cost = costDao.get(id);
		if (cost != null) {
			String status = cost.getStatus();
			if (Const.COST_STATUS_PAUSE.equals(status)) {
				cost.setStatus(Const.COST_STATUS_DELETE);
				costDao.update(cost);
			} else if (Const.COST_STATUS_OPEN.equals(status)) {
				throw new ServiceException("开通后的资费信息不能删除");
			} else if (Const.COST_STATUS_DELETE.equals(status)) {
				throw new ServiceException("该资费信息已经删除");
			} else {
				throw new ServiceException("该资费信息状态异常");
			}
		} else {
			throw new ServiceException("该资费信息不存在");
		}
	}

	@Override
	public void open(Integer id) throws Exception {
		Cost cost = costDao.get(id);
		if (cost != null) {
			String status = cost.getStatus();
			if (Const.COST_STATUS_PAUSE.equals(status)) {
				cost.setStatus(Const.COST_STATUS_OPEN);
				costDao.update(cost);
			} else if (Const.COST_STATUS_OPEN.equals(status)) {
				throw new ServiceException("该资费信息已经开通");
			} else if (Const.COST_STATUS_DELETE.equals(status)) {
				throw new ServiceException("该资费信息已经被删除 ");
			} else {
				throw new ServiceException("该资费信息状态异常");
			}
		} else {
			throw new ServiceException("该资费信息不存在");
		}
	}

	@Override
	public Cost get(Integer id) throws Exception {
		return costDao.get(id);
	}

	@Override
	public List<Cost> list() throws Exception {
		return costDao.list();
	}

	@Override
	public void update(Cost cost) throws Exception {
		Cost updateCost = costDao.get(cost.getId());
		if (updateCost != null) {
			String status = updateCost.getStatus();
			if (Const.COST_STATUS_PAUSE.equals(status)) {
				updateCost.setName(cost.getName());// 套餐名
				updateCost.setCostType(cost.getCostType());//套餐类型
				updateCost.setBaseDuration(cost.getBaseDuration());// 基本时长
				updateCost.setBaseCost(cost.getBaseCost());// 基本费用
				updateCost.setUnitCost(cost.getUnitCost());// 单位费用
				updateCost.setDescr(cost.getDescr());// 资费说明
				clearupCost(updateCost);//根据套餐类型，规范数据
				costDao.update(updateCost);
			} else if (Const.COST_STATUS_OPEN.equals(status)) {
				throw new ServiceException("已经开通的资费信息无法被修改");
			} else if (Const.COST_STATUS_DELETE.equals(status)) {
				throw new ServiceException("已经删除的资费信息无法被修改 ");
			} else {
				throw new ServiceException("该资费信息状态异常");
			}
		} else {
			throw new ServiceException("该资费信息不存在");
		}
	}

	// 根据资费Cost的套餐类型，设置该资费
	private void clearupCost(Cost cost) throws Exception {
		if(Const.COST_COSTTYPE_PERMONTH.equals(cost.getCostType())){
			//如果为包月，则无基本时长与单位费用
			cost.setBaseDuration(0);
			cost.setUnitCost(0f);
		}else if(Const.COST_COSTTYPE_PERTIME.equals(cost.getCostType())){
			//如果为计时，则无基本时长与基本费用
			cost.setBaseDuration(0);
			cost.setBaseCost(0f);
		}else if(Const.COST_COSTTYPE_PACKAGE.equals(cost.getCostType())){
			//如果为套餐，则不作处理
		}else{
			throw new ServiceException("该资费信息状态异常");
		}
	}
}

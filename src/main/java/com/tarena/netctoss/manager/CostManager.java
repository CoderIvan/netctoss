package com.tarena.netctoss.manager;

import java.util.List;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Cost;

/**
 * 资费管理业务逻辑
 * 
 * @author Ivan
 * 
 * @since 2013-10-22
 */
public interface CostManager {

	/**
	 * 获取所有资费信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Cost> list() throws Exception;

	/**
	 * 根据分页参数，查找所有资费信息
	 * 
	 * @param pager
	 *            分页参数
	 * @param sortKey
	 *            需要排序的键名
	 * @param sortValue
	 *            需要排序的方式
	 * @return
	 * @throws Exception
	 */
	public Pager list(Pager pager, String sortKey, String sortValue)
			throws Exception;

	/**
	 * 根据传入参数，保存资费信息
	 * 
	 * @author Ivan
	 * 
	 * @param name
	 *            资费名称
	 * @param costType
	 *            资费类型
	 * @param baseDuration
	 *            基本时长
	 * @param baseCost
	 *            基本费用
	 * @param unitCost
	 *            单位费用
	 * @param descr
	 *            资费说明
	 * @since 2013-11-2
	 */
	public void save(String name, String costType, Integer baseDuration,
			Float baseCost, Float unitCost, String descr) throws Exception;

	/**
	 * 根据传入的资费ID，删除此资费信息
	 * 
	 * @author Ivan
	 * 
	 * @param id
	 *            资费ID
	 * @throws Exception
	 * @since 2013-11-20
	 */
	public void delete(Integer id) throws Exception;

	/**
	 * 根据传入的资费ID，开通此资费信息
	 * 
	 * @author Ivan
	 * 
	 * @param id
	 * @throws Exception
	 * @since 2013-11-20
	 */
	public void open(Integer id) throws Exception;

	/**
	 * 根据资费ID，查找资费信息
	 * 
	 * @author Ivan
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 * @since 2013-11-21
	 */
	public Cost get(Integer id) throws Exception;

	/**
	 * 更新资费信息
	 * 
	 * @param cost
	 *            要更新的内容
	 * @throws Exception
	 */
	public void update(Cost cost) throws Exception;

}

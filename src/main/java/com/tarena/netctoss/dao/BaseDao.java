package com.tarena.netctoss.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.bean.Pager;

public interface BaseDao<T, PK extends Serializable> {
	/**
	 * 删除实体
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void delete(T entity) throws Exception;

	/**
	 * 根据ID,删除实体
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void delete(PK id) throws Exception;

	/**
	 * 根据ID，获取实体
	 * 
	 * @param id
	 *            主键
	 * @return
	 * @throws Exception
	 */
	public T get(PK id) throws Exception;

	/**
	 * 根据ID，获取实体(懒加载)
	 * 
	 * @param id
	 *            主键
	 * @throws Exception
	 */
	public T load(PK id) throws Exception;

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体
	 * @throws Exception
	 */
	public PK save(T entity) throws Exception;

	/**
	 * 保存或更新实体
	 * 
	 * @param entity
	 *            实体
	 * @throws Exception
	 */
	public void saveOrUpdate(T entity) throws Exception;

	/**
	 * 根据条件，获取实体
	 * 
	 * @param proMap
	 *            条件Map
	 * @throws Exception
	 */
	public T get(Map<String, Object> proMap) throws Exception;

	/**
	 * 更新实体
	 * 
	 * @param entity
	 *            实体
	 * @throws Exception
	 */
	public void update(T entity) throws Exception;

	/**
	 * 根据更新内容与要更新的对象的条件，批量更新
	 * 
	 * @param setMap
	 *            需要更新的内容
	 * @param proMap
	 *            需要过滤的条件
	 * @return {-1 :表示更新语句没执行,0 :无表示影响行数}
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-3-30
	 */
	public int updateByMap(Map<String, Object> setMap,
			Map<String, Object> proMap) throws Exception;

	/**
	 * 获取所有实体
	 * 
	 * @return 实体的集合
	 * @throws Exception
	 */
	public List<T> list() throws Exception;

	/**
	 * 根据分页参数，获取实体集合
	 * 
	 * @author Ivan
	 * 
	 * @param pager
	 * @return
	 * @throws Exception
	 * @since 2013-10-22
	 */
	public Pager list(Pager pager) throws Exception;

	/**
	 * 根据分页参数与查询条件，获取实体集合
	 * 
	 * @author Ivan
	 * 
	 * @param pager
	 * @return
	 * @throws Exception
	 * @since 2013-10-22
	 */
	public Pager listByProMap(Pager pager, Map<String, Object> proMap)
			throws Exception;

	/**
	 * 根据分页参数与排序条件，获取实体集合
	 * 
	 * @param pager
	 * @param sortMap
	 * @return
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-3-26
	 */
	public Pager listBySortMap(Pager pager, Map<String, String> sortMap)
			throws Exception;

	/**
	 * 根据分页参数与查询条件、排序条件，获取实体集合
	 * 
	 * @author Ivan
	 * 
	 * @param pager
	 * @return
	 * @throws Exception
	 * @since 2013-10-22
	 */
	public Pager list(Pager pager, Map<String, Object> proMap,
			Map<String, String> sortMap) throws Exception;

}

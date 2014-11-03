package com.tarena.netctoss.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.tarena.netctoss.dao.CostDao;
import com.tarena.netctoss.entity.Cost;
@Repository
public class CostDaoHibernateImpl extends BaseDaoHibernateImpl<Cost, Integer> implements CostDao {
}

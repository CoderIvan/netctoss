package com.tarena.netctoss.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.tarena.netctoss.dao.PrivilegeDao;
import com.tarena.netctoss.entity.Privilege;

/**
 * 权限 持久化操作 实现类
 * 
 * @author Ivan
 * @since 2014-4-6
 */
@Repository
public class PrivilegeDaoHibernateImpl extends
		BaseDaoHibernateImpl<Privilege, Integer> implements PrivilegeDao {

}

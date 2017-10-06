package com.scut.crm.dao.impl;
 
import com.scut.crm.dao.IBaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BaseDaoImpl implements IBaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int save(Object object) {
		Transaction tran = null;
		int objectId = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
			objectId = (Integer) session.save(object);
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		}
		return objectId;
	}

	@Override
	public void update(Object object) {
		Transaction tran = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
			session.update(object);
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		}
	}

	@Override
	public Object get(Class c, int id) {
		Object object = null;
		Transaction tran = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
			object = session.get(c, id);
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		}
		return object;
	}

	@Override
	public void remove(Object obj) {
		Transaction tran = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
			session.delete(obj);
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		}
	}

	@Override
	public <T> List<T> queryList(String hql, Object[] param) {
		List<T> list = new ArrayList<>();
		Transaction tran = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
			}
			list = query.list();
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		}
		return list;
	}

	@Override
	public Object queryOne(String hql, Object[] param) {
		Object object = null;
		Transaction tran = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
			}
			object = query.uniqueResult();
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
		}
		return object;
	}

	@Override
	public <T> List<T> queryByPage(String hql, Object[] param, int currentPage, int pageSize) {
		List<T> list = new ArrayList<>();
		Transaction tran = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
			}
			query.setFirstResult((currentPage-1) * pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
		}
		return list;
	}

	@Override
	public int count(String hql, Object[] param) {
		int records = 0;
		Transaction tran = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
			}
			Long count = (Long) query.uniqueResult();
			records = count.intValue();
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
		}
		return records;
	}
}


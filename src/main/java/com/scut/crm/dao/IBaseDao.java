package com.scut.crm.dao;
 
import java.util.List;

public interface IBaseDao {
	
	int save(Object object);

	void update(Object object);

	Object get(Class c, int id);

	void remove(Object obj);

	<T> List<T> queryList(String hql, Object[] param);

	Object queryOne(String hql, Object[] param);

	<T> List<T> queryByPage(String hql, Object[] param, int currentPage, int pageSize);

	int count(String hql, Object[] param);

}


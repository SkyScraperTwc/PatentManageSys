package com.scut.crm.service;

import com.scut.crm.entity.Pagination;

import java.util.List;
import java.util.Map;

public interface IBaseService<T> {
	Pagination<T> listByPage(Map<String, Object> map);

	Pagination<T> listByForeignKey(Map<String, Object> map);

	int getTotalRecords(String joint, Object[] params);

	T getById(Integer id);

	String getIdentifier(Class c);

	T getBySerialNumber(String serialNumber);

	void update(T object);

	void remove(T object);

	int save(T object);
}

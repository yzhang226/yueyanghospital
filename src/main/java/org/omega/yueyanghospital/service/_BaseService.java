package org.omega.yueyanghospital.service;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.service.IdEntityService;

public abstract class _BaseService<T> extends IdEntityService<T> {

	public _BaseService() { 
		super();
	}
	
	public _BaseService(Dao dao ) {
		super(dao);
	}
	
	public T save(T obj) {
		return dao().insert(obj);
	}
	
	public int update(T obj) {
		return dao().update(obj);
	}
	
	public int remove(T obj) {
		return dao().delete(obj);
	}
	
	public T get(long id) {
		return dao().fetch(getEntityClass(), id);
	}
	
	public List<T> findAll() {
		return dao().query(getEntityClass(), null);
	}
	
}

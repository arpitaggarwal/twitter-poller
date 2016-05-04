package com.test.dao;

/**
 * Class <BaseDao> is the base class to be extended by every class needs to be
 * persisted in database.
 * 
 * @author ArpitAggarwal
 *
 * @param <T>
 */
public abstract class BaseDao<T> {

	protected abstract Class<T> getEntityClass();

	public void save(T obj) {
		// save call to database
	}

	public void find(T obj) {
		// find particular object call to database
	}

	public void findAll() {
		// find all object call to database
	}
}

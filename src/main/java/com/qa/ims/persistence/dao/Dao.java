package com.qa.ims.persistence.dao;

import java.util.List;

import com.qa.ims.persistence.domain.Orders;

public interface Dao<T> {

    List<T> readAll();
     
    T create(T t);
     
    T update(T t);

	void delete(Long id);

	void delete(String id);

	/**
	 * Updates a order in the database
	 * 
	 * @param order - takes in a order object, the id field will be used to update
	 *              that order in the database
	 * @return
	 */
	Orders updateOrder(Orders order);

	/**
	 * Creates a order in the database
	 * 
	 * @param order - takes in a order object. id will be ignored
	 */
	Orders createOrder(Orders order);

	void deleteOrder(String orderID);

	void delete(long id);

	void deleteOrder(Long orderlineID, Long orderID);

}
	
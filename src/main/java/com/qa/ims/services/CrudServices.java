package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.domain.Orders;

public interface CrudServices<T> {

    public List<T> readAll();
     
    T create(T t);
     
    T update(T t);
 

	public void delete(Long id);

	void deleteOrder(Long orderlineID, Long orderID);

	Orders updateOrder(Orders order);

}

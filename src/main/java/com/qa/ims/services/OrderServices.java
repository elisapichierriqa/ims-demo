package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orders;

public class OrderServices {
	private Dao<Orders> orderDao;
	
	public void orderServices(Dao<Orders> orderDao) {
		this.orderDao = orderDao;
	}
	
	public List<Orders> readAll() {
		return orderDao.readAll();
	}

	public Orders create(Orders orders) {
		return orderDao.create(orders);
	}

	public Orders update(Orders order) {
		return orderDao.update(order);
	}

	public void delete(Long orderID) {
		orderDao.delete(orderID);
	}

}

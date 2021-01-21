package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;

public class itemsServices implements CrudServices<Items> {
	
	private Dao<Items> itemDao;
	
	public itemsServices(Dao<Items> itemDao) {
		this.itemDao = itemDao;
	}
	
	public List<Items> readAll() {
		return itemDao.readAll();
	}

	public Items create(Items item) {
		return itemDao.create(item);
	}

	public Items update(Items item) {
		return itemDao.update(item);
	}


	@Override
	public void delete(Long id) {
		itemDao.delete(id);

		
	}

	public void delete(String id) {
		itemDao.delete(id);
		
	}

	@Override
	public void deleteOrder(Long orderlineID, Long orderID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders updateOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

}
	

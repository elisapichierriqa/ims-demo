package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;

public class ItemDaoMysql implements Dao<Items> {
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);

	public ItemDaoMysql(String username, String password) {
	}

	public ItemDaoMysql(String jdbcConnectionUrl, String username, String password) {
	}

	Items itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemID = resultSet.getLong("itemID");
		String item_name = resultSet.getString("item_name");
		return new Items(itemID, item_name);
	}

	@Override
	public List<Items> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Items create(Items t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Items update(Items t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	

}

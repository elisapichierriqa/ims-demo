package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;

public class ItemDaoMysql implements Dao<Items> {
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);
	private String jdbcConnectionUrl;
	private String username;
	private String password;
	

	public ItemDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}

	public ItemDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Items itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String item_name = resultSet.getString("item_name");
		Double item_value = resultSet.getDouble("item_value");
		return new Items(id, item_name, item_value);
	}

	// Read all Items in system
	@Override
	public List<Items> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from items");) {
			ArrayList<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(itemFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Items readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

//Create Items in system
	@Override
	public Items create(Items item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into items(item_name, item_value) values('" + item.getItem_name() + "','" + item.getItem_value() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Items readItems(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items where id = " + id);) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

//Update item in system
	@Override
	public Items update(Items item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"update items set item_name ='" + item.getItem_name() + "' where id =" + item.getId());
			return readItems(item.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

//Delete an item from system by id
	
	@Override
	public void delete(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from items where item id =" + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	@Override
	public void delete(String id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from items where item id =" + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public Orders updateOrder(Orders order) {
		return null;
	}

//	private Orders readOrders(Long orderID) {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where orderID = " + orderID);) {
//			resultSet.next();
//			return orderFromResultSet(resultSet);
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//
//	}



	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from items where item id =" + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		
	}

	@Override
	public void deleteOrder(String orderID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(Long orderlineID, Long orderID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders createOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

}

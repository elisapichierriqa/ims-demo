package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.OrderDaoMysql;

public class OrderDaoMysqlTest {

	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysqlTest.class);

	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
	private static String username = "root";
	private static String password = "root";

	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}

	@Before
	public void setUp() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM orders");
			statement.executeUpdate("DELETE FROM customers");
			statement.executeUpdate("DELETE FROM orderlines;");			
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	

	@Test
	public void createTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long orderID = 1L;
		Long customerID = 1L;
		String postcode = "NOT REAL";
		Orders orders = new Orders(orderID, customerID, postcode);
		Orders savedOrder = new Orders(orderID, customerID, postcode);
		orderDaoMysql.create(orders);
		assertEquals(savedOrder, orders);
}
	@Test
	public void updateTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(username, password);
		Long orderID = 1L;
		Long itemID = 1L;
		String postcode = "NOT REAL";
		Orders order = new Orders(orderID, itemID, postcode);
		Orders savedOrder = new Orders(orderID, itemID, postcode);
		orderDaoMysql.update(order);
		assertEquals(savedOrder, order);
	}

	@Test
	public void readAllTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(username, password);

		List<Orders> orderList = List.of(new Orders(1L, 1L, "postcode"), new Orders(1L, 1L, "postcode"),
				new Orders(1L, 1L, "postcode"));
		for (Orders order : orderList) {
			orderDaoMysql.create(order);
		}
		orderList = orderDaoMysql.readAll();
		assertEquals(orderList, orderDaoMysql.readAll());
	}
	
	@Test
	public void deleteTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(username, password);
		Long itemID = 1L;
		Long orderID = 1L;
		String postcode = "NOT REAL";

		Orders order = new Orders(itemID, orderID, postcode);
		order = orderDaoMysql.create(order);
		orderDaoMysql.delete(orderID);
		assertEquals(null, order);
}
	
	
}




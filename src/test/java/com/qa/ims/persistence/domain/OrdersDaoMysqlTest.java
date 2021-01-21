package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.ItemDaoMysql;
import com.qa.ims.persistence.dao.OrderDaoMysql;

public class OrdersDaoMysqlTest {

	public static final Logger LOGGER = Logger.getLogger(OrdersDaoMysqlTest.class);

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
			statement.executeUpdate("delete from ims.items");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
//
//	@Test
//	public void createTest() {
//		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
//		String item_name = "Broomstick";
//		Double item_value = 500.00;
//		Items item = new Items(1L, item_name, item_value);
//		Items savedItems = new Items(1L, item_name, item_value);
//		item = itemDaoMysql.create(item);
//		item.setId(1L);
//		assertEquals(savedItems, item);
//
//	}
//
//	@Test
//	public void readTest() {
//		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
//		String item_name = "Broomstick";
//		Double item_value = 500.00;
//		Items item = new Items(1L, item_name, item_value);
//		Items savedItems = new Items(1L, item_name, item_value);
//		item = itemDaoMysql.create(item);
//		item.setId(1L);
//		itemDaoMysql.readItems(1L);
//		assertEquals(savedItems, item);
//	
//}
//}





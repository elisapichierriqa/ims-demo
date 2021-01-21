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
	
	public class ItemsDaoMysqlTest {

		public static final Logger LOGGER = Logger.getLogger(ItemsDaoMysqlTest.class);

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
				statement.executeUpdate("delete from items");
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

//		@Test
//		public void createTest() {
//			ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
//			//long id = 1L;
//			String item_name = "Broomstick";
//			Double item_value = 500.00;
//			Items item = new Items(1L, item_name, item_value);
//			Items savedItems = new Items(1L, item_name, item_value);
//			item = itemDaoMysql.create(item);
//			itemDaoMysql.readAll();
//			assertEquals(savedItems, item);
//
//		}

		@Test
		public void readTest() {
			ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
			String item_name = "Broomstick";
			Double item_value = 500.00;
			Long id = 1L;
			Items item = new Items(id, item_name, item_value);
			Items savedItems = new Items(id, item_name, item_value);
			item = itemDaoMysql.create(item);
			item.setId(id);
			itemDaoMysql.readItems(id);
			assertEquals(savedItems, item);
		
}
//		public void updateTest() {
//			ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
//			long id = 1L;
//			String item_name = "Better Broomstick";
//			Double item_value = 550.00;
//			Items item = new Items(id, item_name, item_value);
//			Items savedItems = new Items(id, item_name, item_value);
//			item = itemDaoMysql.update(item);
//			savedItems = itemDaoMysql.update(savedItems);
//			assertEquals(savedItems, item);
//		}
	}

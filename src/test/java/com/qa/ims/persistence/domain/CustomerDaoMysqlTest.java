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
	import com.qa.ims.persistence.dao.CustomerDaoMysql;
	
	
	public class CustomerDaoMysqlTest {
		

		public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

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
				statement.executeUpdate("delete from ims.customers");
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

		@Test
		public void createTest() {
			CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
			String first_name = "Bob";
			String last_name = "Bobsen";
			Customer customer = new Customer(1L, first_name, last_name);
			Customer savedCustomer = new Customer(1L, first_name, last_name);
			customer = customerDaoMysql.create(customer);
			customer.setId(1L);
			assertEquals(savedCustomer, customer);

		}

		@Test
		public void readTest() {
			CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
			String first_name = "Bob";
			String last_name = "Bobsen";
			Customer customer = new Customer(1L, first_name, last_name);
			Customer savedCustomer = new Customer(1L, first_name, last_name);
			customer = customerDaoMysql.create(customer);
			customer.setId(1L);
			customerDaoMysql.readCustomer(1L);
			assertEquals(savedCustomer, customer);
		}
//		
//		@Test
//		public void readAllTest() {
//			CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
//			Customer c1 = new Customer("Bob", "Bobsen");
//			Customer c2 = new Customer("Marco", "Volo");
//			customerDaoMysql.create(c1);
//			customerDaoMysql.create(c2);
//			List<Customer> customer = customerDaoMysql.readAll();
//			assertEquals(c1, customer.get(0));
//			assertEquals(c2, customer.get(1));
//		
//			}

}

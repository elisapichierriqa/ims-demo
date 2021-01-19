package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class orderController {

		public static final Logger LOGGER = Logger.getLogger(orderController.class);
		
		private CrudServices<Orders> ordersService;
		
		public orderController(CrudServices<Orders> ordersService) {
			this.ordersService(ordersService);
		}
		

		String getInput() {
			return Utils.getInput();
	
			//View all orders in the system 
}
		@Override
		public List<Orders> readAll() {
			List<Orders> Orders = ordersService.readAll();
			for(Orders orders: Orders) {
				LOGGER.info(Orders.toString());
			}
			return Orders;
		}

		/**
		 * Creates an order in the system
		 */
		@Override
		public Orders create() {
			LOGGER.info("Please enter a first name");
			String firstName = getInput();
			LOGGER.info("Please enter a last name");
			String lastName = getInput();
			Customer customer = customerService.create(new Customer(firstName, lastName));
			LOGGER.info("Customer created");
			return customer;
		}

		/**
		 * Deletes an existing order by the id of the order
		 */
		@Override
		public void delete() {
			LOGGER.info("Please enter the id of the customer you would like to delete");
			Long id = Long.valueOf(getInput());
			customerService.delete(id);
		}
		
}

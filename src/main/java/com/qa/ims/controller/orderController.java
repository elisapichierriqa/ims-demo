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
		

		private void ordersService(CrudServices<Orders> ordersService) {
			this.ordersService(ordersService);
			
		}


		String getInput() {
			return Utils.getInput();
	
			//View all orders in the system 
}
		public List<Orders> readAll() {
			List<Orders> orders = ordersService.readAll();
			for(Orders order: orders) {
				LOGGER.info(order.toString());
			}
			return orders;
		}

		/**
		 * Creates an order in the system
		 */
		public Orders create() {
			return null;
		}

		/**
		 * Deletes an existing order by the id of the order
		 */
		public void delete() {
			LOGGER.info("Please enter the id of the order you would like to delete");
			Long orderID = Long.valueOf(getInput());
			ordersService.delete(orderID);
		}
		
}

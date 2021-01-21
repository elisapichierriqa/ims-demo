package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {

		public static final Logger LOGGER = Logger.getLogger(OrderController.class);
		private CrudServices<Orders> OrderServices;
		
		public OrderController(CrudServices<Orders> OrderServices) {
			this.OrderServices = OrderServices;
		}


		String getInput() {
			return Utils.getInput();
	
			//View all orders in the system 
}
		public List<Orders> readAll() {
			List<Orders> orders = OrderServices.readAll();
			for(Orders order: orders) {
				LOGGER.info(order.toString());
			}
			return orders;
		}

		/**
		 * Creates an order in the system
		 */
		@Override
		public Orders create() {
			LOGGER.info("Enter customer ID.");
			Long customerID = Long.valueOf(getInput());
			LOGGER.info("Enter the ID of the item you would like to add.");
			Long itemID = Long.valueOf(getInput());
			LOGGER.info("Enter your postcode.");
			String postcode = getInput();
			Orders order = OrderServices.create(new Orders(customerID, itemID, postcode));
			LOGGER.info("Order created.");
			return order;
		}

		/**
		 * Deletes an existing order by the id of the order
		 */
		public void delete() {
			LOGGER.info("Please enter the id of the order you would like to delete");
			Long orderID = Long.valueOf(getInput());
			OrderServices.delete(orderID);
			LOGGER.info("Order deleted.");
		}


		@Override
		public Orders update() {
			LOGGER.info("Please enter the ID of the order you would like to update.");
			Long orderID = Long.valueOf(getInput());
			LOGGER.info("Please enter your customer ID");
			Long customerID = Long.valueOf(getInput());
			LOGGER.info("Please enter the new item ID");
			Long itemID = Long.valueOf(getInput());
			LOGGER.info("Please enter the new postcode.");
			String postcode = getInput();
			Orders orders = OrderServices.update(new Orders(orderID, customerID, itemID, postcode));
			LOGGER.info("Order updated.");
			return orders;
		}
		
}

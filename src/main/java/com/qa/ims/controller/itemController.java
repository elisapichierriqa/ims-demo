package com.qa.ims.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;



public class itemController implements CrudController<Items>{

	public static final Logger LOGGER = Logger.getLogger(itemController.class);
	
	private CrudServices<Items> itemsService;
	
	public itemController(CrudServices<Items> itemsService) {
		this.itemsService = itemsService;}
	
	String getInput() {
		return Utils.getInput();
	}
	
	
	
//View all items

	@Override
	public List<Items> readAll() {
		List<Items> items = itemsService.readAll();
		for (@SuppressWarnings("unused") Items Items: items) {
			LOGGER.info(items.toString());
		}
		return items;
	}

//add an item to the system
	@Override
	public Items create() {
		LOGGER.info("Please enter the name of the item you'd like to create.");
		String item_name = getInput();
		LOGGER.info("Please enter the value of the item you'd like to create.");
		Double item_value = getDoubleInput();
		Items item = itemsService.create(new Items(item_name, item_value));
		LOGGER.info("Item created.");
		return item;
}


//update an item in the system
	@Override
	public Items update() {

		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = Long.valueOf(getLongInput());
		LOGGER.info("Enter the new name of the item.");
		String item_name = getInput();
		LOGGER.info("Enter the new price of the item.");
		Double item_value = getDoubleInput();
		Items items = itemsService.update(new Items(id, item_name, item_value));
		LOGGER.info("Item Updated.");
		return items;
	}
private long getLongInput() {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	return scanner.nextLong();

}

//delete an item from the system
	@Override
	public void delete() {
			LOGGER.info("Please enter the id of the item you would like to delete");
			Long id = Long.valueOf(getInput());
			itemsService.delete(id);
			LOGGER.info("Item deleted.");
		}

	public Double getDoubleInput() {
		return Utils.getDoubleInput();
		
	}
		

}

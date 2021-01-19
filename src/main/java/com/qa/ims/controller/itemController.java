package com.qa.ims.controller;

import java.util.List;
import org.apache.log4j.Logger;


import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class itemController implements CrudController<Items>{

	public static final Logger LOGGER = Logger.getLogger(itemController.class);
	
	private CrudServices<Items> itemsService;
	
	public itemController(CrudServices<Items> itemsService) {
		this.itemsService = itemsService;
	}
	

	String getInput() {
		return Utils.getInput();
	}
	
//View all items
	@Override
	public List<Items> readAll() {
		List<Items> Items = itemsService.readAll();
		for(Items items: Items) {
			LOGGER.info(items.toString());
		}
		return Items;
	}
//add an item to the system
	@Override
	public Items create() {
		LOGGER.info("Please enter the name of the item you'd like to create.");
		String item_name = getInput();
		Items Items = itemsService.create(new Items(null, item_name));
		LOGGER.info("Item created.");
		return Items;
	}
//update an item in the system
	@Override
	public Items update() {

		LOGGER.info("Please enter the id of the item you would like to update");
		String itemID = String.valueOf(getInput());
		LOGGER.info("Please enter the name of the item you would like to update");
		String item_name = getInput();
		Items Items = itemsService.update(new Items(itemID, item_name));
		LOGGER.info("Item Updated");
		return Items;
	}
	
//delete an item from the system
	@Override
	public void delete() {
			LOGGER.info("Please enter the id of the item you would like to delete");
			Long itemID = Long.valueOf(getInput());
			itemsService.delete(itemID);
		}
		

}

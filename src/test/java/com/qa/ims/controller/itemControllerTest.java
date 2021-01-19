package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Items;

@RunWith(MockitoJUnitRunner.class)

	public class itemControllerTest {
	
	@Mock
	private com.qa.ims.services.itemsServices itemsServices;
	
	@Spy
	@InjectMocks
	private itemController itemController;
	@Test
	public void readAllTest() {
		itemController itemController = new itemController(itemsServices);
		List<Items> items = new ArrayList<>();
		items.add(new Items("1", "Easel"));
		items.add(new Items("2", "Dice"));
		items.add(new Items("3", "Wizard Hat"));
		Mockito.when(itemsServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	
	}
	@Test
	public void createTest() {
		String item_name = "Dice";
		Mockito.doReturn(item_name).when(itemController).getInput();
		Items items = new Items(null, item_name);
		Items savedItems = new Items(null, "Easel");
		Mockito.when(itemsServices.create(items)).thenReturn(savedItems);
		assertEquals(savedItems, itemController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String itemID = "1";
		String item_name = "Easel";
		Mockito.doReturn(itemID, item_name).when(itemController).getInput();
		Items items = new Items(itemID, item_name);
		Mockito.when(itemsServices.update(items)).thenReturn(items);
		assertEquals(items, itemController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String itemID = "1";
		Mockito.doReturn(itemID).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemsServices, Mockito.times(1)).delete("1");
	}
	
}



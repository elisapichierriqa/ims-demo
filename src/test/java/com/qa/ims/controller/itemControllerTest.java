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
		items.add(new Items("Easel", 20.00));
		items.add(new Items("Dice", 5.00));
		items.add(new Items("Wizard Hat", 100.00));
		Mockito.when(itemsServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	
	}
	@Test
	public void createTest() {
		String item_name = "Dice";
		Double item_value = 5.00;
		Mockito.doReturn(item_name).when(itemController).getInput();
		Mockito.doReturn(item_value).when(itemController).getDoubleInput();
		Items items = new Items(item_name, item_value);
		Items savedItems = new Items(1L, "Easel", 20.00);
		Mockito.when(itemsServices.create(items)).thenReturn(savedItems);
		assertEquals(savedItems, itemController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String id = "1";
		String item_name = "Easel";
		Double item_value = 20.00;
		Mockito.doReturn(id, item_name).when(itemController).getInput();
		Items items = new Items(1L, item_name, item_value);
		Mockito.when(itemsServices.update(items)).thenReturn(items);
		assertEquals(items, itemController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemsServices, Mockito.times(1)).delete(1L);
	}
	
}



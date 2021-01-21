package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemsTest {

	private Items item;
	private Items other;
	
	@Before
	public void setUp() {
		item = new Items(1L, "Magic Wand", 50.00);
		other = new Items(1L, "Magic Wand", 50.00);
	}
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getItem_name());
		assertNotNull(item.getItem_value());
		
		item.setId(null);
		assertNull(item.getId());
		item.setItem_name(null);
		assertNull(item.getItem_name());
		item.setItem_value(null);
		assertNull(item.getItem_value());
		
	}
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getId(), 0);
		assertEquals("Magic Wand", item.getItem_name());
		assertEquals("Magic Wand", item.getItem_value());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setItem_name(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setItem_name("Unmagic Wand");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItem_name(null);
		other.setItem_name(null);
		assertTrue(item.equals(other));
	}
	@Test
	public void nullId() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	@Test
	public void nullItem_value() {
		item.setItem_value(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullItemValueOnBoth() {
		item.setItem_value(null);
		other.setItem_value(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherItemValueDifferent() {
		other.setItem_value(500000.00);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Items item = new Items("Magic Wand", 50.00);
		assertNull(item.getId());
		assertNotNull(item.getItem_name());
		assertNotNull(item.getItem_value());
	}
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Items item = new Items(null, null);
		Items other = new Items(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "id:1 item_name:Magic Wand item_value:50.00";
		assertEquals(toString, item.toString());
	}
}




package com.qa.ims.persistence.domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class OrdersTest {

	private Orders order;
	private Orders other;
	
	@Before
	public void setUp() {
		order = new Orders(1L, 1L, 1L, "NOT REAL");
		other = new Orders(1L, 1L, 1L, "NOT REAL");
	}
	@Test
	public void settersTest() {
		
		assertNotNull(order.getOrderID());
		assertNotNull(order.getCustomerID());
		assertNotNull(order.getItemID());
		assertNotNull(order.getPostcode());
		
		order.setOrderID(null);
		assertNull(order.getOrderID());
		order.setCustomerID(null);
		assertNull(order.getCustomerID());
		order.setItemID(null);
		assertNull(order.getItemID());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createOrderWithId() {
		assertEquals(1L, order.getOrderID(), 0);
		assertEquals(1L, order.getCustomerID(), 0);
		assertEquals(1L, order.getItemID(), 0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void orderIDNullButOtherOrderIDNotNull() {
		order.setOrderID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void postcodessNotEqual() {
		other.setPostcode("AAA AAAA");
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullorderID() {
		order.setOrderID(null);
		other.setOrderID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullId() {
		order.setOrderID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		order.setOrderID(null);
		other.setItemID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setOrderID(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullPostcde() {
		order.setPostcode(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullPostcodeOnBoth() {
		order.setPostcode(null);
		other.setPostcode(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherPostcodeDifferent() {
		other.setPostcode("BBB BBBB");
		assertFalse(order.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Orders order = new Orders(1L, 1L, "CCC CCCC");
		assertNull(order.getOrderID());
		assertNotNull(order.getItemID());
		assertNotNull(order.getCustomerID());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Orders order = new Orders(null, null, null);
		Orders other = new Orders(null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "order id:1L item 1L customer id:1L postcode:NOT REAL";
		assertEquals(toString, order.toString());
	}
}




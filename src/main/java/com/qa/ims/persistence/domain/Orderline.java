package com.qa.ims.persistence.domain;

public class Orderline {
	
	private Long orderlineID;
	private int quantity;
	private Long itemID;
	private Double item_value;
	
	
public Orderline(Long orderlineID, int quantity, Long itemID, Double item_value) {
	super();
	this.orderlineID = orderlineID;
	this.quantity = quantity;
	this.itemID = itemID;
	this.item_value = item_value;

}

public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Double getItem_value() {
	return item_value;
}
public void setItem_value(Double item_value) {
	this.item_value = item_value;
}


public Long getOrderlineID() {
	return orderlineID;
}

public void setOrderlineID(Long orderlineID) {
	this.orderlineID = orderlineID;
}

public Long getItemID() {
	return itemID;
}

public void setItemID(Long itemID) {
	this.itemID = itemID;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((orderlineID == null) ? 0 : orderlineID.hashCode());
//	result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Orderline other = (Orderline) obj;
	if (orderlineID == null) {
		if (other.itemID != null)
			return false;
	} else if (!itemID.equals(other.itemID))
		return false;
	if (itemID == null) {
		if (other.itemID != null)
			return false;
	} else if (orderlineID.equals(other.orderlineID))
		return false;
	if (item_value == null) {
		if (other.item_value != null)
			return false;
	} else if (!item_value.equals(other.item_value))
		return false;
	return true;
}
}

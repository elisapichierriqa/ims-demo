package com.qa.ims.persistence.domain;

public class Items {
	private String itemID;
	private String item_name;
	private Double item_value;
	
	public Items(String itemID, String item_name, Double item_value) {
		this.itemID = itemID;
		this.item_name = item_name;
		this.item_value = item_value;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	public String toString() {
		return "item ID:" + itemID + "item name:" + item_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
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
		Items other = (Items) obj;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (itemID.equals(other.itemID))
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		return true;
	}

	public Double getItem_value() {
		return item_value;
	}

	public void setItem_value(Double item_value) {
		this.item_value = item_value;
	}

}

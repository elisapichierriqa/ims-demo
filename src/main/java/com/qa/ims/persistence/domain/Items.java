package com.qa.ims.persistence.domain;

public class Items {
	private Long id;
	private String item_name;
	private Double item_value;
	
	public Items(String item_name, Double item_value) {
		super();
		this.item_name = item_name;
		this.item_value = item_value;
	}
	public Items(Long id, String item_name, Double item_value) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.item_value = item_value;
	}


	public Items(long l, String string) {
		// TODO Auto-generated constructor stub
	}
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	public String toString() {
		return " item ID: " + id + " item name: " + item_name + " item value: " + item_value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (id.equals(other.id))
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}

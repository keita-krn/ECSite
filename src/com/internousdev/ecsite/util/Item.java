package com.internousdev.ecsite.util;

public class Item {

	private String itemName;
	private int itemPrice;
	private int count;

	public Item(String itemName,int itemPrice,int count){
		this.setItemName(itemName);
		this.setItemPrice(itemPrice);
		this.setCount(count);
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

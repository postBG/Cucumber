package com.mart.shopping;

public class Item {

	private String product;
	private int quantity;
	private int unitPrice;

	public Item(String product, int quantity, int unitPrice) {
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getProduct() {
		return product;
	}
}

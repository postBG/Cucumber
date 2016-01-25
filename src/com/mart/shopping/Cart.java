package com.mart.shopping;

import java.util.ArrayList;
import java.util.List;


public class Cart {
	
	private List<Item> items = new ArrayList<Item>();

	public void add(String product, int quantity, int unitPrice){
		items.add(new Item(product, quantity, unitPrice));
	}

	public Integer priceOf(String product) {
		Item searchedItem = searchItem(product);
		if(searchedItem == null)
			return 0;

		return searchedItem.getUnitPrice() * searchedItem.getQuantity();
	}

	private Item searchItem(String product) {
		for(Item item : items){
			if(product.equals(item.getProduct())){
				return item;
			}
		}
		return null;
	}

	public Integer countItems() {
		return items.size();
	}

	public Integer totalPrice() {
		Integer pureTotalPrice = pureTotalPrice();
		return applyDisCount(pureTotalPrice);
	}
	
	private Integer pureTotalPrice() {
		Integer totalPrice = 0;
		for(Item item : items){
			totalPrice += item.getUnitPrice() * item.getQuantity();
		}
		return totalPrice;
	}
	
	private Integer applyDisCount(Integer pureTotalPrice){
		if(pureTotalPrice < 10000){
			return pureTotalPrice;
		}
		
		double priceAfterDiscount = pureTotalPrice * 0.9; 
		pureTotalPrice = Integer.valueOf((int)priceAfterDiscount);
		return pureTotalPrice;
		
	}
}

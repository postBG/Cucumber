package com.mart.shopping;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartTest {
	private Cart cart;

	@Before
	public void setUp() {
		cart = new Cart();
	}

	@Test
	public void noItemInCart() {
		assertEquals(Integer.valueOf(0), cart.countItems()); // 쿼리 메소드
	}

	@Test
	public void oneItemWhenOneProductIsAdded() {
		addProductToCart("렛츠비");
		assertEquals(Integer.valueOf(1), cart.countItems()); // 쿼리 메소드
	}

	@Test
	public void twoItemsWhenTwoProductIsAdded() {
		addProductToCart("렛츠비");
		addProductToCart("꼬깔콘");

		assertEquals(Integer.valueOf(2), cart.countItems()); // 쿼리 메소드
	}
	
	@Test
	public void priceOfWhenCartIsEmpty(){
		assertEquals(Integer.valueOf(0), cart.priceOf("렛츠비"));
	}
	
	@Test
	public void priceOfWhenOneProductAdded(){
		String product = "렛츠비";
		cart.add(product, 1, 100);
		assertEquals(Integer.valueOf(100), cart.priceOf(product));
	}


	@Test
	public void priceOfWhenTwoProductAdded(){
		cart.add("꼬깔콘", 2, 200);
		cart.add("렛츠비", 1, 100);
		
		assertEquals(Integer.valueOf(100), cart.priceOf("렛츠비"));
	}

	@Test
	public void zeroTotalPriceWhenCarIsEmpty(){
		assertEquals(Integer.valueOf(0), cart.totalPrice());
	}
	
	
	@Test
	public void totalPriceIsItemPriceWhenOneProductAdded(){
		cart.add("렛츠비", 2, 100);
		assertEquals(Integer.valueOf(200), cart.totalPrice());
	}
	
	@Test
	public void sumOfPriceIsItemPriceWhenTwoProductAdded(){
		cart.add("렛츠비", 2, 100);
		cart.add("꼬깔콘", 3, 1000);
		
		assertEquals(Integer.valueOf(3200), cart.totalPrice());
	}
	
	@Test
	public void applyTenPercentDiscountWhenBuyOneProductMoreThanTenThousandWon(){
		cart.add("렛츠비", 4, 2500);
		
		assertEquals(Integer.valueOf(9000), cart.totalPrice());
	}
	
	private void addProductToCart(String product) {
		int quantity_not_important = 1;
		int unitPrice_not_important = 1;
		
		cart.add(product, quantity_not_important, unitPrice_not_important);
	}

}

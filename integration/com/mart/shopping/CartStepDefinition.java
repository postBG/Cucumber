package com.mart.shopping;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class CartStepDefinition {
	private Cart cart = new Cart();

	@Given("^'길동'이는 구매가 준비됨$")
	public void 길동_이는_구매가_준비됨() throws Throwable {
	}

	@When("^길동이가 (\\d+) 원짜리 (.*) (\\d+)개를 담았다\\.$")
	public void 길동이가_원짜리_렛츠비_개를_담았다(int price, String product, int quantity) throws Throwable {
		cart.add(product, quantity, price);
	}

	@Then("^(.*) 가격은 (\\d+)원이다\\.$")
	public void 가격은_원이다(String product, Integer expectPrice) throws Throwable {
		assertEquals(expectPrice, cart.priceOf(product));
	}

	@Then("^총 합계는 (\\d+)원이다\\.$")
	public void 총_합계는_원이다(Integer totalPrice) throws Throwable {
		assertEquals(totalPrice ,cart.totalPrice());
	}



}

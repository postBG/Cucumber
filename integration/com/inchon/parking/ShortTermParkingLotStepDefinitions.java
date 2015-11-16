package com.inchon.parking;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.is;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShortTermParkingLotStepDefinitions {

	@When("^나는 평일에 단기 주차장에 (.*)동안 주차한다\\.$")
	public void 나는_평일에_단기_주차장에_동안_주차한다(String duration) throws Throwable {
	}
	
	@When("^나는 주말에 단기 주차장에 (.*)동안 주차한다\\.$")
	public void 나는_주말에_단기_주차장에_동안_주차한다(String duration) throws Throwable {
		throw new PendingException();
	}	

	@When("^나는 주말과 평일 혼합하여 단기 주차장에 (.*)동안 주차한다\\.$")
	public void 나는_주말과_평일_혼합하여_단기_주차장에_동안_주차한다(String duration) throws Throwable {
		throw new PendingException();
	}	
	
	@Then("^나는 주차요금으로 (\\d+)원을 지불해야 한다\\.$")
	public void 나는_주차요금으로_원을_지불해야_한다(int expectedPrice) throws Throwable {
		ParkingCalculator parkingCalculator = new ParkingCalculator();
		assertThat(parkingCalculator.calculate(),is(expectedPrice));
	}
}

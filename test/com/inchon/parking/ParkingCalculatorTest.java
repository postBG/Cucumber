package com.inchon.parking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ParkingCalculatorTest {
	@Test
	public void basePrice() {
		ParkingCalculator parkingCalculator = new ParkingCalculator();
		assertThat(parkingCalculator.calculate(0),is(0));
	}
	
	@Test
	public void basePriceForOneMinute() {
		ParkingCalculator parkingCalculator = new ParkingCalculator();
		assertThat(parkingCalculator.calculate(1),is(1200));
		assertThat(parkingCalculator.calculate(2),is(1200));
	}
	
	
}

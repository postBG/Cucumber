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
}

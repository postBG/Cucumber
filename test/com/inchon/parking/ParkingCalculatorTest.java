package com.inchon.parking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ParkingCalculatorTest {
	ParkingCalculator parkingCalculator = new ParkingCalculator();
	
	@Test
	public void basePriceForZeroMinute() {
		assertThat(parkingCalculator.calculate(0),is(0));
	}
	
	@Test
	public void basePrice() {
		assertThat(parkingCalculator.calculate(1),is(1200));
		assertThat(parkingCalculator.calculate(2),is(1200));
		assertThat(parkingCalculator.calculate(30),is(1200));
	}
	
	@Test
	public void priceFor31() {
		assertThat(parkingCalculator.calculate(31),is(1800));
		assertThat(parkingCalculator.calculate(45),is(1800));
	}
	
	@Test
	public void priceFor46() {
		assertThat(parkingCalculator.calculate(46),is(2400));
	}
}

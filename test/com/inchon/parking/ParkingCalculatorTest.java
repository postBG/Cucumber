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
	public void additionalPriceFor31() {
		assertThat(parkingCalculator.calculate(31),is(1800));
		assertThat(parkingCalculator.calculate(45),is(1800));
	}
	
	@Test
	public void additionalPriceFor46() {
		assertThat(parkingCalculator.calculate(46),is(2400));
	}
	
	@Test
	public void dailyLimitPrice() {
		assertThat(parkingCalculator.calculate(5*60),is(12000));
		assertThat(parkingCalculator.calculate(5*60+1),is(12000));
	}

	@Test
	public void priceForMoreThanDay() {
		assertThat(parkingCalculator.calculate(24*60+1),is(13200));
		assertThat(parkingCalculator.calculate(2*24*60+1),is(25200));
	}
	
	@Test
	public void priceForWeekend() {
		parkingCalculator = ParkingCalculator.createWeekendParkingCalculator();
		assertThat(parkingCalculator.calculate(1),is(1400));
	}

}

package com.inchon.parking;

public class ParkingCalculator {
	private static final int DAY_IN_MINUTES = 24*60;
	
	private int 	dailyCostLimit = 12000;
	private int additionalCost = 600;
	private int baseCost = 1200;
	private int dailyCostLimitDuration = 5*60;
	private int baseCostDuration = 30;
	private int additionalCostTimeUnit = 15;

	public Integer calculate(Integer durationInMinutes) {
		int cost = 0;
		
		int days = durationInMinutes/DAY_IN_MINUTES;
		if ( days >= 1 ) {
			cost += days*dailyCostLimit;
			durationInMinutes -= days*DAY_IN_MINUTES;
		}
		
		if ( durationInMinutes >= dailyCostLimitDuration ) {
			cost += dailyCostLimit;
			durationInMinutes = 0;
		}
		if ( durationInMinutes > baseCostDuration ) {
			cost += ((durationInMinutes-baseCostDuration-1)/additionalCostTimeUnit+1)*additionalCost;
		}
		if ( durationInMinutes >= 1 ) {
			cost += baseCost;
		}
		return cost;
	}
	
	public static ParkingCalculator createWeekendParkingCalculator() {
		ParkingCalculator parkingCalculator = new ParkingCalculator();
		parkingCalculator.additionalCost = 700;
		parkingCalculator.additionalCostTimeUnit = 15;
		parkingCalculator.baseCost = 1400;
		parkingCalculator.baseCostDuration = 30;
		parkingCalculator.dailyCostLimit = 14000;
		parkingCalculator.dailyCostLimitDuration = 5*60;
		
		return parkingCalculator;
	}

}

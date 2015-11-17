package com.inchon.parking;

public class ParkingCalculator {

	public Integer calculate(Integer durationInMinutes) {
		int cost = 0;
		
		if ( durationInMinutes >= 46 ) {
			return 1200 + 1200;
		}
		if ( durationInMinutes >= 31 ) {
			cost += 600;
		}
		if ( durationInMinutes >= 1 )
			cost += 1200;
		return cost;
	}

}

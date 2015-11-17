package com.inchon.parking;

public class ParkingCalculator {

	public Integer calculate(Integer durationInMinutes) {
		if ( durationInMinutes >= 1 )
			return 1200;
		return 0;
	}

}

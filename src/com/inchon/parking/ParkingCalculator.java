package com.inchon.parking;

public class ParkingCalculator {

	public Integer calculate(Integer durationInMinutes) {
		int cost = 0;
		
		if ( durationInMinutes >= 24*60 ) {
			cost += (durationInMinutes/(24*60))*12000;
			durationInMinutes -= (durationInMinutes/(24*60))*24*60;
		}
		if ( durationInMinutes >= 5*60 ) {
			cost += 12000;
			durationInMinutes = 0;
		}
		if ( durationInMinutes >= 31 ) {
			cost += ((durationInMinutes-30-1)/15+1)*600;
		}
		if ( durationInMinutes >= 1 )
			cost += 1200;
		return cost;
	}

}

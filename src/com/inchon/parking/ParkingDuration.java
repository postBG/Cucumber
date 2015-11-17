package com.inchon.parking;

public class ParkingDuration {

	private String dayType;
	private int durationInMinutes;

	public ParkingDuration(String dayType, int durationInMinutes) {
		this.dayType = dayType;
		this.durationInMinutes = durationInMinutes;
	}

	public Integer getDurationInMinutes() {
		return durationInMinutes;
	}

	public String getDayType() {
		return dayType;
	}

}

package com.inchon.parking;

public class ParkingDuration {

	private String dayType;
	private int durationInMinutes;
	private boolean weekend;

	public ParkingDuration(String dayType, int durationInMinutes) {
		this.dayType = dayType;
		this.durationInMinutes = durationInMinutes;
	}

	public ParkingDuration(boolean weekend, Integer durationInMinutes) {
		this.weekend = weekend;
		this.durationInMinutes = durationInMinutes;
	}

	public Integer getDurationInMinutes() {
		return durationInMinutes;
	}

	public String getDayType() {
		return dayType;
	}

	public boolean isWeekend() {
		return weekend;
	}

}

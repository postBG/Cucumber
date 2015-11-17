package com.inchon.parking;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeInterval {

	DateTime startDate;
	DateTime endDate;

	public TimeInterval(String startTime, String endTime) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		startDate = dateTimeFormatter.parseDateTime(startTime);
		endDate = dateTimeFormatter.parseDateTime(endTime);
	}

	public Integer durationInMinutes() {
		return durationInMinutes(startDate,endDate);
	}

	Integer durationInMinutes(DateTime start,DateTime end) {
		Duration duration = new Duration(start,end);
		return (int)duration.getStandardMinutes();
	}

	/**
	 * @deprecated Use {@link com.inchon.parking.ParkingDurationGenerator#durationList(TimeService,com.inchon.parking.TimeInterval)} instead
	 */
	public List<ParkingDuration> durationList(TimeService timeService, ParkingDurationGenerator parkingDurationGenerator) {
		return parkingDurationGenerator.durationList(timeService, this);
	}

}

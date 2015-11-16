package com.inchon.parking;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeInterval {

	private DateTime startDate;
	private DateTime endDate;

	public TimeInterval(String startTime, String endTime) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		startDate = dateTimeFormatter.parseDateTime(startTime);
		endDate = dateTimeFormatter.parseDateTime(endTime);
	}

	public Integer durationInMinutes() {
		Duration duration = new Duration(startDate,endDate);
		return (int)duration.getStandardMinutes();
	}

}

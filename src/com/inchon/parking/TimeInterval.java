package com.inchon.parking;

import java.util.ArrayList;
import java.util.List;

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
		return durationInMinutes(startDate,endDate);
	}

	private Integer durationInMinutes(DateTime start,DateTime end) {
		Duration duration = new Duration(start,end);
		return (int)duration.getStandardMinutes();
	}

	public List<ParkingDuration> durationList(TimeService timeService) {
		List<ParkingDuration> durations = new ArrayList<>();
		
		boolean weekend = timeService.isWeekend(startDate);
		DateTime nextDate = startDate.plusDays(1).withTime(0, 0, 0, 0);
		boolean currentWeekendFlag = false;
		while (nextDate.isBefore(endDate)) {
			currentWeekendFlag = timeService.isWeekend(nextDate);
			if (currentWeekendFlag != weekend) {
				durations.add(new ParkingDuration(weekend, durationInMinutes(
						startDate, nextDate)));
				startDate = nextDate;
				weekend = currentWeekendFlag;
			}
			nextDate = nextDate.plusDays(1);
		}

		durations.add(new ParkingDuration(weekend,
				durationInMinutes(startDate, endDate)));
		
		return durations;
	}

}

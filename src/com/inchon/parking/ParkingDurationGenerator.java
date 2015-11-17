package com.inchon.parking;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class ParkingDurationGenerator {

	public List<ParkingDuration> durationList(TimeService timeService, TimeInterval timeInterval) {		
		List<ParkingDuration> durations = new ArrayList<>();
		
		boolean weekend = timeService.isWeekend(timeInterval.startDate);
		DateTime nextDate = timeInterval.startDate.plusDays(1).withTime(0, 0, 0, 0);
		boolean currentWeekendFlag = false;
		while (nextDate.isBefore(timeInterval.endDate)) {
			currentWeekendFlag = timeService.isWeekend(nextDate);
			if (currentWeekendFlag != weekend) {
				durations.add(new ParkingDuration(weekend, timeInterval.durationInMinutes(
						timeInterval.startDate, nextDate)));
				timeInterval.startDate = nextDate;
				weekend = currentWeekendFlag;
			}
			nextDate = nextDate.plusDays(1);
		}
	
		durations.add(new ParkingDuration(weekend,
				timeInterval.durationInMinutes(timeInterval.startDate, timeInterval.endDate)));
		
		return durations;
	}

}

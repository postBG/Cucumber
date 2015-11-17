package com.inchon.parking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

public class TimeIntervalTest {
	private TimeService timeService = new TimeService() {
		List<DateTime> weekends = new ArrayList<DateTime>() {
			{
				add(new DateTime(2015,11,17,0,0));
				add(new DateTime(2015,11,19,0,0));
			}
		};
		
		public boolean isWeekend(DateTime date) {
			DateTime queryDate = date.withTime(0, 0, 0, 0);
			for ( DateTime weekend : weekends ) {
				if ( weekend.equals(queryDate) ) {
					return true;
				}
			}
			return false;
		};
	};

	@Test
	public void durationLessThanHour() {
		TimeInterval timeInterval = new TimeInterval("2015-11-16 00:00:00", "2015-11-16 00:01:00");
		assertThat(timeInterval.durationInMinutes(),is(1));
	}
	
	@Test
	public void durationMoreThanHour() {
		TimeInterval timeInterval = new TimeInterval("2015-11-16 00:00:00", "2015-11-16 01:01:00");
		assertThat(timeInterval.durationInMinutes(),is(61));
	}
	
	@Test
	public void durationListForWeekdayOnly() {
		TimeInterval timeInterval = new TimeInterval("2015-11-16 00:00:00", "2015-11-16 01:01:00");
		List<ParkingDuration> durations = timeInterval.durationList(timeService);
		assertThat(durations.size(),is(1));
		assertThat(durations.get(0).getDurationInMinutes(),is(61));
		assertThat(durations.get(0).getDayType(),is(true));
	}
	
	@Test
	public void testJodaDatetime() {
		DateTime dateTime = new DateTime(2015,11,17,0,0);
		assertThat(dateTime.getYear(),is(2015));
		assertThat(dateTime.getMonthOfYear(),is(11));
		assertThat(dateTime.getDayOfMonth(),is(17));
		assertThat(dateTime.getDayOfMonth(),is(17));
	}
}

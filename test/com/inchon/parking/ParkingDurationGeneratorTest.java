package com.inchon.parking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

public class ParkingDurationGeneratorTest {
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
	public void durationListForWeekdayOnly() {
		TimeInterval timeInterval = new TimeInterval("2015-11-16 00:00:00", "2015-11-16 01:01:00");
		List<ParkingDuration> durations = new ParkingDurationGenerator().durationList(timeService, timeInterval);
		assertThat(durations.size(),is(1));
		assertThat(durations.get(0).getDurationInMinutes(),is(61));
		assertThat(durations.get(0).isWeekend(),is(false));
	}	
	
	@Test
	public void durationListForTwoWeekdays() {
		TimeInterval timeInterval = new TimeInterval("2015-11-11 00:00:00", "2015-11-13 01:01:00");
		List<ParkingDuration> durations = new ParkingDurationGenerator().durationList(timeService, timeInterval);
		assertThat(durations.size(),is(1));
		assertThat(durations.get(0).getDurationInMinutes(),is(2*24*60+61));
		assertThat(durations.get(0).isWeekend(),is(false));
	}
	
	@Test
	public void durationListForWeekEndOnly() {
		TimeInterval timeInterval = new TimeInterval("2015-11-17 00:00:00", "2015-11-17 01:01:00");
		List<ParkingDuration> durations = new ParkingDurationGenerator().durationList(timeService, timeInterval);
		assertThat(durations.size(),is(1));
		assertThat(durations.get(0).getDurationInMinutes(),is(61));
		assertThat(durations.get(0).isWeekend(),is(true));
	}	

	@Test
	public void durationForMixedDays() {
		TimeInterval timeInterval = new TimeInterval("2015-11-16 23:59:00", "2015-11-17 00:01:00");
		List<ParkingDuration> durations = new ParkingDurationGenerator().durationList(timeService, timeInterval);
		assertThat(durations.size(),is(2));
		assertThat(durations.get(0).getDurationInMinutes(),is(1));
		assertThat(durations.get(0).isWeekend(),is(false));
		assertThat(durations.get(1).getDurationInMinutes(),is(1));
		assertThat(durations.get(1).isWeekend(),is(true));
	}
	
	@Test
	public void durationForTwoMixedDays() {
		TimeInterval timeInterval = new TimeInterval("2015-11-15 23:59:00", "2015-11-17 00:01:00");
		List<ParkingDuration> durations = new ParkingDurationGenerator().durationList(timeService, timeInterval);
		assertThat(durations.size(),is(2));
		assertThat(durations.get(0).getDurationInMinutes(),is(24*60+1));
		assertThat(durations.get(0).isWeekend(),is(false));
		assertThat(durations.get(1).getDurationInMinutes(),is(1));
		assertThat(durations.get(1).isWeekend(),is(true));
	}		
	
	@Test
	public void durationForTwoAnyMixedDays() {
		TimeInterval timeInterval = new TimeInterval("2015-11-16 23:59:00", "2015-11-18 00:01:00");
		List<ParkingDuration> durations = new ParkingDurationGenerator().durationList(timeService, timeInterval);
		assertThat(durations.size(),is(3));
		assertThat(durations.get(0).getDurationInMinutes(),is(1));
		assertThat(durations.get(0).isWeekend(),is(false));
		assertThat(durations.get(1).getDurationInMinutes(),is(24*60));
		assertThat(durations.get(1).isWeekend(),is(true));
		assertThat(durations.get(2).getDurationInMinutes(),is(1));
		assertThat(durations.get(2).isWeekend(),is(false));
	}	
}

package com.inchon.parking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class TimeIntervalTest {
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
}

package com.inchon.parking;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShortTermParkingLotStepDefinitions {

	private Map<String,TimeInterval> durationMap = new HashMap<String,TimeInterval>() {
		{
			put("1분",new TimeInterval("2015-11-16 00:00:00","2015-11-16 00:01:00"));
			put("30분",new TimeInterval("2015-11-16 00:00:00","2015-11-16 00:30:00"));
			put("31분",new TimeInterval("2015-11-16 00:00:00","2015-11-16 00:31:00"));
			put("45분",new TimeInterval("2015-11-16 00:00:00","2015-11-16 00:45:00"));
			put("1시간",new TimeInterval("2015-11-16 00:00:00","2015-11-16 01:00:00"));
			put("5시간",new TimeInterval("2015-11-16 00:00:00","2015-11-16 05:00:00"));
			put("5시간 1분",new TimeInterval("2015-11-16 00:00:00","2015-11-16 05:00:00"));
			put("1일",new TimeInterval("2015-11-16 00:00:00","2015-11-17 00:00:00"));
			put("1일 1분",new TimeInterval("2015-11-16 00:00:00","2015-11-17 00:01:00"));
			put("1일 31분",new TimeInterval("2015-11-16 00:00:00","2015-11-17 00:31:00"));
			put("2일 1분",new TimeInterval("2015-11-16 00:00:00","2015-11-18 00:1:00"));
			put("3일 1분",new TimeInterval("2015-11-16 00:00:00","2015-11-19 00:1:00"));
		}
	};
	private Integer durationInMinutes;
	private String durationType;

	@When("^나는 평일에 단기 주차장에 (.*)동안 주차한다\\.$")
	public void 나는_평일에_단기_주차장에_동안_주차한다(String duration) throws Throwable {
		TimeInterval timeInterval = durationMap.get(duration);
		durationInMinutes = timeInterval.durationInMinutes();
		durationType = "평일";
	}
	
	@When("^나는 주말에 단기 주차장에 (.*)동안 주차한다\\.$")
	public void 나는_주말에_단기_주차장에_동안_주차한다(String duration) throws Throwable {
		TimeInterval timeInterval = durationMap.get(duration);
		durationInMinutes = timeInterval.durationInMinutes();
		durationType = "주말";
	}	

	@When("^나는 주말과 평일 혼합하여 단기 주차장에 (.*)동안 주차한다\\.$")
	public void 나는_주말과_평일_혼합하여_단기_주차장에_동안_주차한다(String duration) throws Throwable {
		throw new PendingException();
	}	
	
	@Then("^나는 주차요금으로 (\\d+)원을 지불해야 한다\\.$")
	public void 나는_주차요금으로_원을_지불해야_한다(int expectedPrice) throws Throwable {
		if ( "평일".equals(durationType) ) {
			ParkingCalculator parkingCalculator = new ParkingCalculator();
			assertThat(parkingCalculator.calculate(durationInMinutes),is(expectedPrice));
		}
		else {
			ParkingCalculator parkingCalculator = ParkingCalculator.createWeekendParkingCalculator();
			assertThat(parkingCalculator.calculate(durationInMinutes),is(expectedPrice));			
		}
	}
}

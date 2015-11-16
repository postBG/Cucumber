package com.inchon.parking;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"integration/com/inchon/parking/ShortTermParkingLot.feature"})
public class ShortTermParkingLotTest {

}

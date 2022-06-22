package com.shedin.saucedemo.stepdefs;

import com.shedin.guicore.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.shedin.saucedemo.helpers.ScenarioHelper.checkScenario;


public class GlobalStepdefs {

	@Before(order = 1)
	public void setUpDriver() {
		DriverManager.setDriver();
	}

	@After(order = 1)
	public void closeDriver(Scenario scenario) {
		checkScenario(scenario);
		DriverManager.closeDriver();
	}
}
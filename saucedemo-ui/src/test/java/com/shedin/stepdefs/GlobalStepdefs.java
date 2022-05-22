package com.shedin.stepdefs;

import com.shedin.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Locale;


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

	public void checkScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] data = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(data, "image/png", scenario.getId() + "-screen");
		}
	}
}
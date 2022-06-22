package com.shedin.saucedemo.helpers;

import com.shedin.guicore.driver.DriverManager;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ScenarioHelper {

	private ScenarioHelper() {}

	public static void checkScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] data = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(data, "image/png", scenario.getId() + "-screen");
		}
	}
}

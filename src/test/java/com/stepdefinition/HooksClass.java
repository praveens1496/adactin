package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.base.Baseclass;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.ast.Scenario;

public class HooksClass extends Baseclass {
	@Before
	public void browserlaunch() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browsertype"));
		loadUrl(getPropertyFileValue("url"));
		maximize();

	}

	@After
	public void Screenshot(Scenario scenario) {
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		byte[] as = screenshot.getScreenshotAs(OutputType.BYTES);
//		scenario.embed(as, "Every Scenario");

	}
}

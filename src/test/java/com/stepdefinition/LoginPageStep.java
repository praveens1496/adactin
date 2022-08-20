package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.Baseclass;
import com.pageobjectmanager.PageObjectManager;
import com.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginPageStep extends Baseclass {
	static WebDriver driver;
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on Adactin Hotel Login Page")
	public void userIsOnAdactinHotelLoginPage() throws FileNotFoundException, IOException {
//		getDriver(getPropertyFileValue("browsertype"));
//		loadUrl(getPropertyFileValue("url"));
//		maximize();
	}

	@When("User Should Perform the {string},{string}")
	public void userShouldPerformThe(String username, String password) {

		pom.getLoginpage().login(username, password);
	}

	@Then("User Should verify the success messsge as {string}")
	public void userShouldVerifyTheSuccessMesssgeAs(String string) {

		WebElement welcomeName = pom.getLoginpage().getWelcomeName();
		Assert.assertEquals(welcomeName, "Hello praveen1627!");
	}
	@When("User Should verify the Error messsge as {string}")
	public void userShouldVerifyTheErrorMesssgeAs(String string) {
		
		String errormsg = pom.getLoginpage().Errormsg();
		Assert.assertEquals(errormsg, "Invalid Login details or Your Password might have expired.");
	}

}

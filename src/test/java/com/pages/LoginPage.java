package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

public class LoginPage extends Baseclass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtusername;

	@FindBy(id = "password")
	private WebElement txtpassword;

	@FindBy(id = "login")
	private WebElement btnlogin;

	@FindBy(id = "username_show")
	private WebElement welcomeName;

	@FindBy(xpath = "//div[@class='auth_error']")
	private WebElement errormsg;

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}

	public WebElement getWelcomeName() {
		return welcomeName;
	}

	public WebElement getErrormsg() {
		return errormsg;
	}

	public void login(String username, String password) {
		sendKeys(txtusername, username);
		sendKeys(txtpassword, password);
		click(btnlogin);
	}

	public String name() {
		String attribute = getAttribute(welcomeName);
		return attribute;
	}

	public void InvalidLogin(String username, String password) {
		sendKeys(txtusername, username);
		sendKeys(txtpassword, password);
		click(btnlogin);

	}

	public String Errormsg() {
		String text = getText(errormsg);
		return text;

	}

}

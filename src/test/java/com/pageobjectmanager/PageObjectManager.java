package com.pageobjectmanager;

import com.pages.LoginPage;

public class PageObjectManager {

	private LoginPage loginpage;

	public LoginPage getLoginpage() {
		return (loginpage == null) ? loginpage = new LoginPage() : loginpage;
	}

}

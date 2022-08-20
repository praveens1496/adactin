
package org.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactin  {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement txtusername = driver.findElement(By.id("username"));
		txtusername.sendKeys("praveen1627");

		WebElement txtpassword = driver.findElement(By.id("password"));
		txtpassword.sendKeys("48A543");

		WebElement btnlogin = driver.findElement(By.id("login"));
		btnlogin.click();

		WebElement selectbyvalue = driver.findElement(By.id("location"));
		Select select = new Select(selectbyvalue);
		select.selectByVisibleText("Melbourne");

		WebElement rooms = driver.findElement(By.id("room_nos"));
		Select r = new Select(rooms);
		r.selectByVisibleText("4 - Four");

		WebElement datein = driver.findElement(By.name("datepick_in"));
		datein.sendKeys("21/08/2022");

		WebElement dateout = driver.findElement(By.name("datepick_out"));
		dateout.sendKeys("23/08/2022");

		WebElement adult = driver.findElement(By.id("adult_room"));
		Select a = new Select(adult);
		a.selectByIndex(2);

		WebElement btnsearch = driver.findElement(By.id("Submit"));
		btnsearch.click();

		WebElement pick = driver.findElement(By.id("radiobutton_1"));
		pick.click();

		WebElement click2 = driver.findElement(By.id("continue"));
		click2.click();

		WebElement txtname = driver.findElement(By.id("first_name"));
		txtname.sendKeys("karan");

		WebElement txtlastname = driver.findElement(By.id("last_name"));
		txtlastname.sendKeys("karan");

		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("chennai");

		WebElement card = driver.findElement(By.name("cc_num"));
		card.sendKeys("1234567891234567");

		WebElement cardtype = driver.findElement(By.id("cc_type"));
		Select ct = new Select(cardtype);
		ct.selectByIndex(2);

		WebElement month = driver.findElement(By.id("cc_exp_month"));
		Select m = new Select(month);
		m.selectByIndex(2);

		WebElement year = driver.findElement(By.id("cc_exp_year"));
		Select y = new Select(year);
		y.selectByVisibleText("2016");

		WebElement cvv = driver.findElement(By.name("cc_cvv"));
		cvv.sendKeys("327");

		WebElement btnbook = driver.findElement(By.id("book_now"));
		btnbook.click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement printid = driver.findElement(By.xpath("//input[@name='order_no']"));
		String txt = printid.getAttribute("value");
		System.out.println(txt);

		
		
		
	}

}

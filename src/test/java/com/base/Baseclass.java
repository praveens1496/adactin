package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;

	public  void getDriver(String browseType) {
		switch (browseType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			break;	
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;	
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;		
			
		default:
			break;
		}
		
	
			
		}
		
	
	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties =new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"//config.properties"));
		Object object = properties.get(key);
		String value=(String)object;
		return value;
		

	}
		
	



	public static void loadUrl(String Url) {
		driver.get(Url);

	}

	public void maximize() {
		driver.manage().window().maximize();

	}

	public  void sendKeys(WebElement element, String data) {
		element.sendKeys(data);

	}
	public void clear(WebElement element) {
		element.clear();
	}

	public void click(WebElement element) {
		element.click();
	}
	public String getTile() {
		String title = driver.getTitle();
		return title;
	}

	public String getTitle() {

		String title = driver.getTitle();
		return title;

	}

	public WebElement findElementById(String text) {
		WebElement findElement = driver.findElement(By.id(text));
		return findElement;
	}

	public WebElement findElementByName(String text) {

		WebElement findElement = driver.findElement(By.name(text));
		return findElement;

	}

	public WebElement findElementByClassName(String text) {
		WebElement findElement = driver.findElement(By.className(text));
		return findElement;

	}

	public WebElement findElementByXpath(String text) {
		WebElement findElement = driver.findElement(By.xpath(text));
		return findElement;
	}

	public void closeAllWindows() {
		driver.quit();
	}

	public void closeCurrentWindow() {
		driver.close();
	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void simpleAlerts() {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		

	}
public void PromptAlert(String text) {
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
		

	}
public void Dismiss() {
	
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
	

}

	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public void selectDropDownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectDropDownByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public void alertSendkeys(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
	}
	
	public String alretgetText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}
	
	public void ActionsMouseOver(WebElement element) {
		Actions action =new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void ActionsDoubleClick(WebElement element) {
		Actions action =new Actions(driver);
		action.doubleClick().perform();
	}
	
	public void ActionsRightClick(WebElement element) {
		Actions action =new Actions(driver);
		action.contextClick(element).perform();
	}
	public void ActionsDragAndDrop(WebElement element) {
		Actions action =new Actions(driver);
		action.dragAndDrop(element, element).perform();
	}
	
	public void takeScreenShot(String path) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file =new File(path);
		FileHandler.copy(screenshotAs, file);
		
		
	}
	
	public void JavaScriptExecutorInsertValue(WebElement element,String data) {
		JavascriptExecutor executor =(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);

	}
	public  void JavaScriptExecutorGetAttribute(String data) {
		JavascriptExecutor executor =(JavascriptExecutor)driver;
		executor.executeScript("return arguments[0].getAttribute('value')",data );

	}
	public void switchToFrameByIndex(int i) {
		driver.switchTo().frame(i);
		
	}
	public void switchToFrameById(String data) {
		driver.switchTo().frame(data);

	}
	
	public void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);

	}
	
	public String windowHandle() {
	
		
	    String parentWindowId = driver.getWindowHandle();
		return parentWindowId;	
	}
	public  Set<String> windowHandles() {
		
        Set<String> allwindowHandles = driver.getWindowHandles();
		return allwindowHandles;  
	}
	
	
	  
	

	public String getData(String SheetName, int rownum, int cellnum) throws IOException {
		String res = null;

		File file = new File("C:\\Users\\user\\eclipse-workspace\\Pandian\\src\\test\\resources\\excel\\Maven date 1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yy");
				res = dateformat.format(dateCellValue);

			} else {
				double cellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(cellValue);
				res = valueOf.toString();
			}
			break;
		default:
			break;
		}
		return res;

	}
	
	//modify the cell value
	public void upDate(String SheetName,int rowno,int colno,String oldData,String newData) throws IOException {
		File file =new File("C:\\Users\\user\\eclipse-workspace\\Pandian\\src\\test\\resources\\excel\\Maven date 1.xlsx");
		FileInputStream inputStream =new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook();
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(rowno);
		String Value = cell.getStringCellValue();
		if(Value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		
        FileOutputStream outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
		
	}
	//create cell insert value
	public void insetCellValue(String path,String SheetName,int rowno,int colno,String data) throws IOException {
		File file =new File("C:\\Users\\user\\eclipse-workspace\\Pandian\\src\\test\\resources\\excel\\Maven date 1.xlsx");
		FileInputStream inputStream=new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowno);
		Cell cell = row.createCell(colno);
		cell.setCellValue(data);
		  FileOutputStream outputStream=new FileOutputStream(file);
	        workbook.write(outputStream);
	}
	//create row and cell insert vlaue
	        
	    	public void createRowCellValue(String path,String SheetName,int rowno,int colno,String data) throws IOException {
	    		File file =new File("C:\\Users\\user\\eclipse-workspace\\Pandian\\src\\test\\resources\\excel\\Maven date 1.xlsx");
	    		FileInputStream inputStream=new FileInputStream(file);
	    		Workbook workbook =new XSSFWorkbook(inputStream);
	    		Sheet sheet = workbook.getSheet(SheetName);
	    		Row row = sheet.createRow(rowno);
	    		Cell cell = row.createCell(colno);
	    		cell.setCellValue(data);
	    		  FileOutputStream outputStream=new FileOutputStream(file);
	    	        workbook.write(outputStream);
		
		
		
	}
     public void send(WebElement element,String data) {
    	 element.sendKeys(data);
     }
	
	
}
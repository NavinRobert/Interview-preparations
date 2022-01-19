package org.base;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.text.Element;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 static WebDriver driver;
	// Actions action = new Actions(driver);
	 
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public String browserTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public void getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
	}
	
	public String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public WebElement locationId(String Id) {
		WebElement element = driver.findElement(By.id(Id));
		return element;
	}
	
	public WebElement locationName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	
	public WebElement locationClassName(String name) {
		WebElement element = driver.findElement(By.className(name));
		return element;
	}
	
	public WebElement xyzPath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public static void sendingText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static void quiting() {
		driver.quit();
	}
	
	public void setProperty(String s1,String s2) {
		System.setProperty(s1, s2);
	}
	
	public String gettext(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public String getAttri(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	
	public void naviTo(String url) {
		driver.navigate().to(url);
	}
	
	public void naviBack() {
		driver.navigate().back();
	}
	
	public void naviForward() {
		driver.navigate().forward();
	}
	
	public void naviRefresh() {
		driver.navigate().refresh();
	}
	
	public Alert alert() {
		Alert al = driver.switchTo().alert();
		return al;
	}
	
	public void alertaccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	public void alertcancel() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}
	
	public void selectByVisbleText(WebElement element, String visible) {
		Select select = new Select(element);
		select.selectByVisibleText(visible);
	}
	
	public void selectByValue(WebElement element, String val) {
		Select select = new Select(element);
		select.selectByValue(val);
	}
	
	public int selectByIndex(WebElement element, int hot) {
		Select select = new Select(element);
		select.selectByIndex(hot);
		return hot;
	
	}
	
	
	
	
	public String fileHandle(String sheetName, int rowNum, int cellNum ) throws IOException {
		String result=null;
		File file = new File("D:\\Test\\ReusableMethod\\Excel\\sample sheet.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		int type = cell.getCellType();
		if(type==1) {
			String entertext = cell.getStringCellValue();
			result = entertext;
		}
		if(type==0) {
			if(DateUtil.isCellDateFormatted(cell)) {
				java.util.Date date = cell.getDateCellValue();
				SimpleDateFormat formatdt = new SimpleDateFormat("dd-MMM-yy");
				String enterdate = formatdt.format(date);
				result = enterdate;
			}else {
				double dou = cell.getNumericCellValue();
				long l = (long) dou;
				String numeric = String.valueOf(l);
				result = numeric;
			}	
			}
		return result;
		}
	
	
	public void printDropDownSelectByIndex(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
	}
	
	public static void sendDataToExcel(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("D:\\Test\\JUnitBaseclassExcel\\Excel\\sample sheet.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}
	
	public void assertEquals(String msg, String text, String s3) {
		Assert.assertEquals(msg, text, s3);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

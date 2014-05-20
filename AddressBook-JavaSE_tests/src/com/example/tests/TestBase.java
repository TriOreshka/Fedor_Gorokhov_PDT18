/***
 * TestBase.java
 * 
 * Created on May 19-20, 2014 as home task 1&2 for training 
 * "Programming For Testers" by Software-testing.ru 
 * (http://www.software-testing.ru/events/864-programming-for-testers-new) 
 * 
 * Base test class, contains low-level implementation of all methods,
 * including setUp and tearDown  
 *  
 */
package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
// import org.openqa.selenium.Alert;
// import org.openqa.selenium.NoAlertPresentException;
// import org.openqa.selenium.NoSuchElementException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}

	protected void openMainPage() {
	    driver.get(baseUrl + "/addressbookv4.1.4/");
	}
	
	protected void initGroupCreation() {
		findElement(By.name("new")).click();
	}

	protected void gotoGroupsPage() {
		findElement(By.cssSelector("a[href=\"group.php\"]")).click();
	}

	protected void gotoAddNewPage() {
		findElement(By.cssSelector("a[href=\"edit.php\"]")).click();
	}
	
	protected void returnToHomePage() {
		findElement(By.cssSelector("a[href=\"./\"]")).click();
	}
	
	protected void submitButtonClick() {
		findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData group) {
	    findAndFill(By.name("group_name"), group.name);
	    findAndFill(By.name("group_header"), group.header);
	    findAndFill(By.name("group_footer"), group.footer);
	}

	protected void fillAddNewAddressForm(AddressData address) {
		findAndFill(By.name("firstname"), address.first_name);
		findAndFill(By.name("lastname"), address.last_name);
		findAndFill(By.name("address"), address.address_text);
		findAndFill(By.name("home"), address.home_number);
		findAndFill(By.name("mobile"), address.mobile_phone);
		findAndFill(By.name("work"), address.work_phone);
		findAndFill(By.name("email"), address.email_1);
		findAndFill(By.name("email2"), address.email_2);
		selectAndFill(By.name("bday"),"21");
		selectAndFill(By.name("bmonth"),"May");
		findAndFill(By.name("byear"), address.bday_year);
		// selectAndFill(By.name("new_group"),"Rob");
		findAndFill(By.name("address2"), address.secondary_address_text);
		findAndFill(By.name("phone2"), address.secondary_home_phone);
	}
	
	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	protected void findAndFill(By locator, String text) {
		if (text == "" || text == null)
			return;
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	protected void selectAndFill(By locator, String text) {
		if (text == "" || text == null)
			return;
		new Select(findElement(locator)).selectByVisibleText(text);;
	}	
	/*private void clearAndFill(String searchBy, String typeIn) {
		driver.findElement(By.name(searchBy)).clear();
	    driver.findElement(By.name(searchBy)).sendKeys(typeIn);
	}*/

/*
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	}

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	}

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	}
*/
}

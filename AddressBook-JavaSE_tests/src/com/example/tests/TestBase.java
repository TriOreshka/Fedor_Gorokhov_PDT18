package com.example.tests;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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
	
	protected void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	protected void submitButtonClick() {
	    driver.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData group) {
	    clearAndFill("group_name", group.name);
	    clearAndFill("group_header", group.header);
	    clearAndFill("group_footer", group.footer);
	}

	protected void fillAddNewAddressForm(AddressData address) {
		clearAndFill("firstname", address.first_name);
		clearAndFill("lastname", address.last_name);
		clearAndFill("address", address.address_text);
		clearAndFill("home", address.home_number);
		clearAndFill("mobile", address.mobile_phone);
		clearAndFill("work", address.work_phone);
		clearAndFill("email", address.email_1);
		clearAndFill("email2", address.email_2);
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText("21");
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("May");
		clearAndFill("byear", address.bday_year);
		// new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("Rob");
		clearAndFill("address2", address.secondary_address_text);
		clearAndFill("phone2", address.secondary_home_phone);
	}
	
	private void clearAndFill(String searchBy, String typeIn) {
		driver.findElement(By.name(searchBy)).clear();
	    driver.findElement(By.name(searchBy)).sendKeys(typeIn);
	}

	protected void initGroupCreation() {
	    driver.findElement(By.name("new")).click();
	}

	protected void gotoGroupsPage() {
	    driver.findElement(By.linkText("groups")).click();
	}

	protected void gotoAddNewPage() {
	    driver.findElement(By.linkText("add new")).click();
	}
	
	protected void openMainPage() {
	    driver.get(baseUrl + "/addressbookv4.1.4/");
	}


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

	protected void returnToHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}



}

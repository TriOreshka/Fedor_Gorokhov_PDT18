package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {

	protected ApplicationManager manager;
	private WebDriver driver;
	public boolean acceptnextAlert = true;

	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;
	}

	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	protected List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	protected int countElements(By locator) {
		return findElements(locator).size();
	}

	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	protected void gotoUrl(String url) {
		driver.get(url);
	}

	protected void click(By locator) {
		findElement(locator).click();
	}

	protected void type(By locator, String text) {
		// if (text == "" || text == null)
		// return;
		WebElement element = findElement(locator);
		element.clear();
		setValue(element, text); // fast JavaScript method to enter text
		// element.sendKeys(text); // slow type-in method to enter text
	}

	protected void select(By locator, String text) {
		if (text == "" || text == null)
			return;
		new Select(findElement(locator)).selectByVisibleText(text);
	}

	public String getAttributeValue(By locator) {
		return findElement(locator).getAttribute("value");
	}

	protected String getText(WebElement row, int cellNum) {
		//return row.findElement(By.xpath("td[" + cellNum + "]")).getText();
		return row.findElement(By.cssSelector("td:nth-child(" + cellNum + ")")).getText();
	}

	protected String getCellValue(WebElement row, int cellNum) {
		return row.findElement(By.xpath("td[" + cellNum + "]/input")).getAttribute("value");
		//return row.findElement(By.cssSelector("td:nth-child(" + cellNum + ")")).getAttribute("value");
	}

	private void setValue(WebElement element, String value) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].value = arguments[1]", element, value);
	}

}

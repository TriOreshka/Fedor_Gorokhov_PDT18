package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {
	
	protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptnextAlert = true;

	public HelperBase(ApplicationManager manager){
		this.manager = manager;
		this.driver = manager.driver;
	}

	protected void click(By locator) {
		findElement(locator).click();
	}

	protected void findAndFill(By locator, String text) {
		if (text == "" || text == null)
			return;
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	protected void findAndSelect(By locator, String text) {
		if (text == "" || text == null)
			return;
		new Select(findElement(locator)).selectByVisibleText(text);
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public String getFieldText(By locator) {
		WebElement element = findElement(locator);
		return element.getAttribute("value");
	}
	
	

}

package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;

	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	static RND randomHelper;
	
	public ApplicationManager() {
		driver = new FirefoxDriver();
		// driver = new InternetExplorerDriver();
		baseUrl = "http://localhost";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void stop() {
		driver.quit();
	}
	
	public NavigationHelper getNavigationHelper(){
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);			
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper(){
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);			
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper(){
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);			
		}
		return contactHelper;
	}
	
	static RND getRandomHelper(){
		if (randomHelper == null) {
			randomHelper = new RND();			
		}
		return randomHelper;
	}
}

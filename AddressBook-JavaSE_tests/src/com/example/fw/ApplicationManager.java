package com.example.fw;

import java.util.Random;
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
	
	public String makeRandString(String characters, int length) {
	    char[] text = new char[length];
	    Random rng = new Random();
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
	public String randLetters(int len) {
	    return makeRandString("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm", len);
	}
	
	public String randNumbers(int len) {
	    return makeRandString("1234567890", len);
	}
	
	public String randAll(int len) {
	    return makeRandString("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890,.-(){}_", len);
	}
	
	public String randPhone() {
	    return ("(" + randNumbers(3) + ")" + randNumbers(3)+ "-" + randNumbers(2)+ "-" + randNumbers(2));
	}    
}

package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openMainPage() {
		//String title = driver.getTitle();
		//System.out.println("title was: [" + title + "]");
		if (! driver.getTitle().equals("Address book")) {			
			driver.get(manager.baseUrl + "/addressbookv4.1.4/");
			//System.out.println("title now:" + title);
		}
		
	}

	public void returnToHomePage() {
		click(By.cssSelector("a[href=\"./\"]"));
	}
	
	public void submitButtonClick() {
		click(By.name("submit"));
	}
	
	public void invokeDelete(String id) {
		driver.get("http://localhost/addressbookv4.1.4/delete.php?id=" + id + "&update=Delete");
	}
}

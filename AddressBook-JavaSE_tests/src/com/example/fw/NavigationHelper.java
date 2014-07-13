package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (!onMainPage()) {
			click(By.cssSelector("a[href=\"./\"]"));
		}
	}

	private boolean onMainPage() {
		return (driver.findElements(By.id("maintable")).size() > 0);
	}

	public void editPage() {
		if (!onEditPage()) {
			click(By.cssSelector("a[href=\"edit.php\"]"));
		}
	}

	private boolean onEditPage() {
		return driver.getCurrentUrl().contains("/edit.php");
	}

	public void groupsPage() {
		if (!onGroupsPage()) {
			click(By.cssSelector("a[href=\"group.php\"]"));
		}
	}

	private boolean onGroupsPage() {
		if (driver.getCurrentUrl().contains("/groups.php")
				&& driver.findElements(By.name("new")).size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void invokeDelete(String id) {
		driver.get("http://localhost/addressbookv4.1.4/delete.php?id=" + id
				+ "&update=Delete");
	}

}

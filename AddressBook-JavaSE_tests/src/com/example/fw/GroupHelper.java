package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoGroupsPage() {
		click(By.cssSelector("a[href=\"group.php\"]"));
	}

	public void fillGroupForm(GroupData groupData) {
		findAndFill(By.name("group_name"), groupData.name);
		findAndFill(By.name("group_header"), groupData.header);
		findAndFill(By.name("group_footer"), groupData.footer);
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));		
	}

}

package com.example.tests;

import org.testng.annotations.Test;

public class CroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().gotoGroupsPage();
		app.getGroupHelper().deleteGroup(1);

		app.getGroupHelper().gotoGroupsPage();
	}
}

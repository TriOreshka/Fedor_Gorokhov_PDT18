package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	//@Test
	public void deleteSomeContact() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().startEditContact(5);
// delete 4th contact - not to remove modified and empty contact
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().openMainPage();
	}

	@Test
	public void deleteNumberOfContacts() throws Exception {
		int amount = 60;
		for (int i = 0; i < amount; i++) {
			deleteSomeContact();
		}

	}
}

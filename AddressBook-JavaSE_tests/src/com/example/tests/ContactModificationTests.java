package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().startEditContact(3);

		ContactData contact = new ContactData();
		app.getContactHelper().modifyContact(contact, "Modified:");
		app.getContactHelper().fillAddressForm(contact);
		app.getContactHelper().updateContact();
		app.getNavigationHelper().returnToHomePage();
	}
}
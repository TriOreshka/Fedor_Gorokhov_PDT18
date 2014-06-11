package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact)
			throws Exception {
		app.getNavigationHelper().openMainPage();

		// save current state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// do staff
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillAddressForm(contact);
		app.getNavigationHelper().submitButtonClick();
		app.getNavigationHelper().returnToHomePage();

		// get new state + verification
		List<ContactData> newList = app.getContactHelper().getContacts();
		app.getContactHelper().workAround4FirstLastNamesMessIssue(contact);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

	// @Test(dataProvider = "randomValidContactGenerator")
	public void testFastContactCreation(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillAddressForm(contact);
		app.getNavigationHelper().submitButtonClick();
	}

	// @Test
	public void emptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillAddressForm(new ContactData());
		app.getNavigationHelper().submitButtonClick();
		app.getNavigationHelper().returnToHomePage();
	}

	// @Test
	public void createNumberOfContacts() throws Exception {
		int amount = 50;
		for (int i = 0; i < amount; i++) {
			emptyContactCreation();
		}
	}
}

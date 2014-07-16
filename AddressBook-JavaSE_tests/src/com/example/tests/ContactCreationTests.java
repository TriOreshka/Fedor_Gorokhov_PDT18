package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
	
	
	@Test(dataProvider = "contactsMegaProvider")
	public void testContactCreationWithValidData(ContactData contact)
			throws Exception {
		ContactHelper cHelper = app.getContactHelper();
		// save current state
		SortedListOf<ContactData> oldList = cHelper.getContacts();
		// do staff
		cHelper.createContact(contact);
		// get new state + verification
		SortedListOf<ContactData> newList = cHelper.getContacts();
		assertThat(newList,
				equalTo(oldList.withAdded(cHelper.workAround(contact))));
	}

	@Test(dataProvider = "contactsMegaProvider")
	public void testFastContactCreation(ContactData contact) throws Exception {
		app.getContactHelper().fastCreateContact(contact);
	}

	// @Test
	public void emptyContactCreation() throws Exception {
		testFastContactCreation(new ContactData());
		// app.getContactHelper().createContact(new ContactData());
	}

	// @Test
	public void createNumberOfContacts() throws Exception {
		int amount = 1000;
		for (int i = 0; i < amount; i++) {
			emptyContactCreation();
		}
	}
}

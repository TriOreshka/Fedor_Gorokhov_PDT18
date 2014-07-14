package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	// @Test
	public void deleteSomeContact() throws Exception {
		ContactHelper cHelper = app.getContactHelper();
		// save current state
		SortedListOf<ContactData> oldList = cHelper.getContacts();
		// do staff
		int index = getRandContactIndex(oldList);
		cHelper.removeContact(index);
		// get new state + verification
		SortedListOf<ContactData> newList = cHelper.getContacts();
		assertThat(newList, equalTo(oldList.without(index)));
	}

	//@Test
	public void deleteNumberOfContacts() throws Exception {
		int amount = 6;
		for (int i = 0; i < amount; i++) {
			deleteSomeContact();
		}
	}

	@Test
	public void deleteAllContacts() throws Exception {
		app.navigateTo().mainPage();
		List<ContactData> list = app.getContactHelper().getIDs();
		for (ContactData item : list) {
			app.navigateTo().invokeDelete(item.getId());
		}
	}
}

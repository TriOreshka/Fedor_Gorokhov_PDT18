package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.RND;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact() throws Exception {

		app.getNavigationHelper().openMainPage();
		
		// save current state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		int index = RND.getRandomInRange(oldList.size()-1);

		// do staff
		app.getContactHelper().startEditContact(index+2);
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().returnToHomePage();
		
		// get new state + verification
		List<ContactData> newList = app.getContactHelper().getContacts();
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

	//@Test
	public void deleteNumberOfContacts() throws Exception {
		int amount = 63;
		for (int i = 0; i < amount; i++) {
			deleteSomeContact();
		}

	}
	
	//@Test
	public void deleteAllContacts() throws Exception {
		app.getNavigationHelper().openMainPage();
		List<ContactData> list = app.getContactHelper().getContacts();
		for (ContactData item : list) {
			app.getNavigationHelper().invokeDelete(item.id);
		}

	}
}

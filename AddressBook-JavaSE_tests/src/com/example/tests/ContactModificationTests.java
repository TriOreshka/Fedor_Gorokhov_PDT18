package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

import com.example.fw.RND;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		
		// save current state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		int index = RND.getRandomInRange(oldList.size()-1);

		// do staff
		app.getContactHelper().startEditContact(index+2);
		app.getContactHelper().fillAddressForm(contact);
		app.getContactHelper().updateContact();
		app.getNavigationHelper().returnToHomePage();
		
		// get new state + verification
		List<ContactData> newList = app.getContactHelper().getContacts();
		oldList.remove(index);
		app.getContactHelper().workAround4FirstLastNamesMessIssue(contact);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
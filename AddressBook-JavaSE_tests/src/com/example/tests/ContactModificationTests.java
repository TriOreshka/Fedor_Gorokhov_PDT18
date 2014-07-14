package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) throws Exception {
		ContactHelper cHelper = app.getContactHelper();
		// save current state
		SortedListOf<ContactData> oldList = cHelper.getContacts();
		// do staff
		int index = getRandContactIndex(oldList);
		app.getContactHelper().modifyContact(index, contact);
		// get new state + verification
		SortedListOf<ContactData> newList = cHelper.getContacts();
		assertThat(
				newList,
				equalTo(oldList.without(index).withAdded(
						cHelper.workAround(contact))));
	}
	
	//@Test
	public void printContact() throws Exception {
		app.getContactHelper().printRows();
	}	
	
}
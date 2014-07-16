package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {

	//@BeforeTest
	private void echoBefore() throws Exception{
		printContacts();
	}
	
	//@AfterTest
	private void echoAfter() throws Exception{
		printContacts();
	}
		
	@Test(dataProvider = "contactsMegaProvider")
	public void modifySomeContact(ContactData contact) throws Exception {
		ContactHelper cHelper = app.getContactHelper();
		// save current state
		SortedListOf<ContactData> oldList = cHelper.getContacts();
		// do staff
		int index = getRandContactIndex(oldList);
		cHelper.modifyContact(index, contact);
		// get new state + verification
		SortedListOf<ContactData> newList = cHelper.getContacts();
		assertThat(newList, equalTo(oldList
									.without(index)
									.withAdded(cHelper.workAround(contact))));
	}

}
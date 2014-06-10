/***
 * ContactCreationTests.java
 * 
 * Created on May 19-20, 2014 as home task 1&2 for training 
 * "Programming For Testers" by Software-testing.ru 
 * (http://www.software-testing.ru/events/864-programming-for-testers-new) 
 * 
 * Contains 2 tests for creating of new address entry in web application 
 * "PHP-addressbook" version 4.14   
 */
package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

	//@Test
	public void notEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		
		// save current state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		// do staff
		app.getContactHelper().initContactCreation();
		ContactData contact = new ContactData();
		contact.first_name = rnd.randLetters(8);
		contact.last_name = rnd.randLetters(12);
		contact.address_text = rnd.randAll(30);
		contact.home_number = rnd.randPhone();
		contact.mobile_phone = rnd.randPhone();
		contact.work_phone = rnd.randPhone();
		contact.email_1 = rnd.randEmail(".ru");
		contact.email_2 = rnd.randEmail(".com");
		contact.bday = rnd.randNumbers(2);
		contact.bmonth = rnd.randLetters(3);
		contact.bday_year = rnd.randNumbers(4);
		contact.secondary_address_text = rnd.randAll(40);
		contact.secondary_home_phone = rnd.randPhone();

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


	//@Test
	public void emptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillAddressForm(new ContactData());
		app.getNavigationHelper().submitButtonClick();
		app.getNavigationHelper().returnToHomePage();
	}

	@Test
	public void createNumberOfContacts() throws Exception {
		int amount = 50;
		for (int i = 0; i < amount; i++) {
			notEmptyContactCreation();
		}
	}
}

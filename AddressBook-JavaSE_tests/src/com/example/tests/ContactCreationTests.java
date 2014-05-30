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

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void notEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();

		ContactData contact = new ContactData();
		contact.first_name = app.randLetters(8);
		contact.last_name = app.randLetters(12);
		contact.address_text = app.randAll(30);
		contact.home_number = app.randPhone();
		contact.mobile_phone = app.randPhone();
		contact.work_phone = app.randPhone();
		contact.email_1 = app.randLetters(10) + "@" + app.randLetters(5) + ".ru";
		contact.email_2 = app.randLetters(10) + "@" + app.randLetters(5) + ".com";
		contact.bday = app.randNumbers(2);
		contact.bmonth = app.randLetters(3);
		contact.bday_year = app.randNumbers(4);
		contact.secondary_address_text = app.randAll(40);
		contact.secondary_home_phone = app.randPhone();

		app.getContactHelper().fillAddressForm(contact);
		app.getNavigationHelper().submitButtonClick();
		app.getNavigationHelper().returnToHomePage();
	}

	@Test
	public void emptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillAddressForm(new ContactData());
		app.getNavigationHelper().submitButtonClick();
		app.getNavigationHelper().returnToHomePage();
	}
	
	//@Test
	public void createNumberOfContacts() throws Exception {
		int amount = 500;
		for (int i = 0; i < amount; i++) {
			notEmptyContactCreation();
		}
	}
}

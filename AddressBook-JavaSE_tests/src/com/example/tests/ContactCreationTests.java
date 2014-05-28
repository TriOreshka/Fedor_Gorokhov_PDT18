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

	/**
	 * Test 1 - creates ContactData object named gollum (@JRRT), fill it with
	 * data, and invokes program to create address with given parameters
	 */
	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();

		ContactData gollum = new ContactData();
		gollum.first_name = "On rodilsya";
		gollum.last_name = "I vyros`";
		gollum.address_text = "Na \nYlitse \nLenina";
		gollum.home_number = "I ego";
		gollum.mobile_phone = "Zarubaet";
		gollum.work_phone = "Vremya ot vremeni";
		gollum.email_1 = "www.leningrad@spb.ru";
		gollum.email_2 = "oh@ru!";
		gollum.bday = "21";
		gollum.bmonth = "May";
		gollum.bday_year = "2014";
		gollum.secondary_address_text = "Secondary Address:\nMulholland Drive,"
				+ " 2014";
		gollum.secondary_home_phone = "Home Sweet Home!";

		app.getContactHelper().fillAddNewAddressForm(gollum);
		app.getNavigationHelper().submitButtonClick();
		app.getNavigationHelper().returnToHomePage();
	}

	/**
	 * Test 2 - creates empty ContactData object, and invokes program to create
	 * address with given parameters
	 */
	@Test
	public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillAddNewAddressForm(new ContactData());
		app.getNavigationHelper().submitButtonClick();
		app.getNavigationHelper().returnToHomePage();
	}
}

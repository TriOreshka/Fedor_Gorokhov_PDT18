package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import com.example.fw.RND;

public class TestBase {

	static ApplicationManager app;

	@BeforeSuite
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterSuite
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 10; i++) {
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 15; i++) {
			ContactData contact = new ContactData();
			contact.first_name = RND.randLetters(8);
			contact.last_name = RND.randLetters(12);
			contact.address_text = RND.randAll(30);
			contact.home_number = RND.randPhone();
			contact.mobile_phone = RND.randPhone();
			contact.work_phone = RND.randPhone();
			contact.email_1 = RND.randEmail(".ru");
			contact.email_2 = RND.randEmail(".com");
			contact.bday = RND.randNumbers(2);
			contact.bmonth = RND.randLetters(3);
			contact.bday_year = RND.randNumbers(4);
			contact.secondary_address_text = RND.randAll(40);
			contact.secondary_home_phone = RND.randPhone();
			list.add(new Object[] { contact });
		}
		return list.iterator();
	}
}

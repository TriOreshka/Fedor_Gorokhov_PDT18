package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import com.example.fw.RAND;

public class TestBase {

	static ApplicationManager app;

	// private String name;

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
			GroupData group = new GroupData().withName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());
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
		String dateStr = new String();
		for (int i = 0; i < 10; i++) {
			dateStr = RAND.doRandDate();
			ContactData contact = new ContactData()
					.withFirstName(RAND.randLetters(8))
					.withLastName(RAND.randLetters(12))
					.withAddressText(RAND.randAll(30))
					.withHomeNumber(RAND.randPhone())
					.withMobilePhone(RAND.randPhone())
					.withWorkPhone(RAND.randPhone())
					.withEmail1(RAND.randEmail(".ru"))
					.withEmail2(RAND.randEmail(".com"))
					.withBday(dateStr.split(" ")[0])
					.withBmonth(dateStr.split(" ")[1])
					.withByear(dateStr.split(" ")[2])
					.with2ndAddressText(RAND.randAll(40))
					.with2ndHomePhone(RAND.randPhone());
			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

}

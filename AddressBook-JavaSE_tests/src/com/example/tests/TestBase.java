package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import com.example.fw.RAND;
import com.example.utils.SortedListOf;

public class TestBase {

	static ApplicationManager app;

	// private String name;

	@BeforeSuite
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
	}

	@AfterSuite
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(10)).iterator();
	}

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
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

	protected int getRandContactIndex(SortedListOf<ContactData> list) {
		return RAND.getIntRand(list.size() - 1);
	}

	protected int getRandGroupIndex(SortedListOf<GroupData> list) {
		return RAND.getIntRand(list.size() - 1);
	}

}

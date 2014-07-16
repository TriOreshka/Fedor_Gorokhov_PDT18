package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
import com.thoughtworks.xstream.XStream;

public class TestBase {

	static ApplicationManager app;
	
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
	public Iterator<Object[]> contactsMegaProvider () throws IOException {
		String provider = app.properties.getProperty("provider", "empty");
		if (provider.equals("contacts.xml.data")) {
			printlnOut("Provider used: XML file <" + provider + ">");
			return wrapContacts4DataProvider(
			loadContactsFromXmlFile(new File(provider))).iterator();
		} else if (provider.equals("contacts.csv.data")) {
			printlnOut("Provider used: CSV file <" + provider + ">");
			return wrapContacts4DataProvider(
			loadContactsFromCsvFile(new File(provider))).iterator();
		} else {
			printlnOut("Provider pattern <" + provider + 
					"> not recognised. Random Contacts Generator used");
			return randomValidContactGenerator();
		}
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file)
			throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file)
			throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(";");
			ContactData contact = new ContactData().withFirstName(part[0])
					.withLastName(part[1]).withAddressText(part[2])
					.withHomeNumber(part[3]).withMobilePhone(part[4])
					.withWorkPhone(part[5]).withEmail1(part[6])
					.withEmail2(part[7]).withBday(part[8]).withBmonth(part[9])
					.withByear(part[10]).with2ndAddressText(part[11])
					.with2ndHomePhone(part[12]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}
	
	public static List<Object[]> wrapContacts4DataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) list.add(new Object[] {contact});
		return list;
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		String dateStr = new String();
		int interations = Integer.valueOf(
				app.properties.getProperty("contacts2Modify", "10"));
		for (int i = 0; i < interations; i++) {
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

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(10)).iterator();
	}

	public static List<Object[]> wrapGroupsForDataProvider(
			List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[] { group });
		}
		return list;
	}

	protected int getRandContactIndex(SortedListOf<ContactData> list) {
		return RAND.getIntRand(list.size() - 1);
	}

	protected int getRandGroupIndex(SortedListOf<GroupData> list) {
		return RAND.getIntRand(list.size() - 1);
	}
	
	public void printContacts() throws Exception {
		app.getContactHelper().printRows();
	}

	public static void printOut(String string) {
		System.out.print(string);
	}
	
	public static void printlnOut(String string) {
		System.out.println(string);
	}

}

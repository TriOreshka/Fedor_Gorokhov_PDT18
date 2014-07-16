package com.example.tests;

import static com.example.tests.TestBase.printlnOut;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.fw.RAND;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			printlnOut("Please specify parameters: <contacts to generate>"
					+ " <file name> <file format (csv OR xml)>");
			return;
		}

		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];

		if (file.exists()) {
			printlnOut("File [" + file + "] exists, please remove it manually");
			return;
		}

		List<ContactData> Contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(Contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(Contacts, file);
		} else printlnOut("Unknown format: " + format);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) writer.write(contact.toSemicSV());
		writer.close();
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		FileWriter writer = new FileWriter(file);
		writer.write(xstream.toXML(contacts));
		writer.close();
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		String dateStr = new String();
		for (int i = 0; i < amount; i++) {
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
			list.add(contact);
		}
		return list;
	}


}

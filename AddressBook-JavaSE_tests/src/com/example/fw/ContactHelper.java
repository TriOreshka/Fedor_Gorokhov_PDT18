package com.example.fw;

import static com.example.tests.TestBase.printOut;
import static com.example.tests.TestBase.printlnOut;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.ListOf;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cachedContacts;

	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}

	private void rebuildCache() {
		printOut("Rebuild Contacts cache started. Processed:");
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> allRows = findElements(By.cssSelector("[name='entry']"));
		int i = 1;
		for (WebElement row : allRows) {
			if ((i++ % 10) == 0) {
				printOut(i-1 + ",");
				if ((i % 250) == 0) printlnOut("");
			}			
			ContactData contact = new ContactData()
				.withFirstName(getText(row, 2))
				.withLastName(getText(row, 3))
			/*
			 * .withEmail1(getText(row, 4))
			 * .withHomeNumber(getText(row, 5))
			 * .withID(getCellValue(row, 1))
			 */;
			cachedContacts.add(contact);
		}
		printlnOut("");
	}

	public List<ContactData> getIDs() {
		printlnOut("Reading of IDs started. Processed:");
		List<ContactData> contactIDs = new ListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> allRows = findElements(By
				.cssSelector("[name='entry']"));
		int i = 1;
		for (WebElement row : allRows) {
			if ((i++ % 10) == 0) {
				printOut(i-1 + ",");
				if ((i % 250) == 0) printlnOut("");
			}
			ContactData contact = new ContactData().withID(getCellValue(row, 1));
			contactIDs.add(contact);
		}
		return contactIDs;
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
		fillContactForm(contact, CREATION);
		submitButtonClick();
		returnToHomePage();
		rebuildCache();
		return this;
	}

	public void modifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		startEditContact(index + 2);
		fillContactForm(contact, CREATION);
		updateButtonClick();
		returnToHomePage();
		rebuildCache();
	}

	public void removeContact(int index) {
		manager.navigateTo().mainPage();
		startEditContact(index + 2);
		deleteButtonClick();
		returnToHomePage();
		rebuildCache();
	}

	public ContactHelper fastCreateContact(ContactData contact) {
		manager.navigateTo().editPage();
		initContactCreation();
		fillContactForm(contact, CREATION);
		submitButtonClick();
		return this;
	}

	public ContactData workAround(ContactData contact) {
		String temp = contact.getLast_name();
		return contact.withLastName(contact.getFirst_name())
				.withFirstName(temp);
	}

	public void printRows() {
		manager.navigateTo().mainPage();
		List<WebElement> allRows = findElements(By.cssSelector("[name='entry']"));
		int count = allRows.size();
		if (count > 20) {
			printOut("Too many Contacts (" + count + "), ");
			count = Math.round(count / 20);
			printlnOut("will echo 1st of " + count+ " contacts");
			int i = 0;
			for (WebElement row : allRows){
				if (i++ % count == 0) printlnOut(row.getText());
			}
		} else {
			for (WebElement row : allRows) printlnOut(row.getText());
		}
		
	}

	// --------------------------------------------------------------------------------
	public ContactHelper fillContactForm(ContactData contact, boolean fromType) {
		type(By.name("firstname"), contact.getFirst_name());
		type(By.name("lastname"), contact.getLast_name());
		type(By.name("address"), contact.getAddress_text());
		type(By.name("home"), contact.getHome_number());
		type(By.name("mobile"), contact.getMobile_phone());
		type(By.name("work"), contact.getWork_phone());
		type(By.name("email"), contact.getEmail_1());
		type(By.name("email2"), contact.getEmail_2());
		select(By.name("bday"), contact.getDay());
		select(By.name("bmonth"), contact.getMonth());
		type(By.name("byear"), contact.getBday_year());
		if (fromType == CREATION) {
			// findAndSelect(By.name("new_group"), "group 1");
		} else {
			if (countElements(By.name("new_group")) != 0) {
				throw new Error(
						"Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"), contact.getSecondary_address_text());
		type(By.name("phone2"), contact.getSecondary_home_phone());
		return this;
	}

	public ContactHelper initContactCreation() {
		click(By.cssSelector("a[href=\"edit.php\"]"));
		return this;
	}

	public ContactHelper startEditContact(int i) {
		click(By.xpath("//*[@id=\"maintable\"]//tr[" + i + "]/td[7]/a"));
		return this;
	}

	public ContactHelper deleteButtonClick() {
		click(By.cssSelector("input[value='Delete']"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper updateButtonClick() {
		click(By.cssSelector("input[value='Update']"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper submitButtonClick() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.cssSelector("a[href=\"./\"]"));
		return this;
	}
}

package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillAddressForm(ContactData addressData) {
		findAndFill(By.name("firstname"), addressData.first_name);
		findAndFill(By.name("lastname"), addressData.last_name);
		findAndFill(By.name("address"), addressData.address_text);
		findAndFill(By.name("home"), addressData.home_number);
		findAndFill(By.name("mobile"), addressData.mobile_phone);
		findAndFill(By.name("work"), addressData.work_phone);
		findAndFill(By.name("email"), addressData.email_1);
		findAndFill(By.name("email2"), addressData.email_2);
		findAndSelect(By.name("bday"), "21");
		findAndSelect(By.name("bmonth"), "May");
		findAndFill(By.name("byear"), addressData.bday_year);
		findAndFill(By.name("address2"), addressData.secondary_address_text);
		findAndFill(By.name("phone2"), addressData.secondary_home_phone);
	}

	public void initContactCreation() {
		click(By.cssSelector("a[href=\"edit.php\"]"));
	}

	public void startEditContact(int i) {
		click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[" + i + "]/td[7]/a"));
	}

	public void deleteContact() {
		click(By.cssSelector("input[value='Delete']"));
		
	}

	public ContactData modifyContact (ContactData contact, String modifier) {
		contact.first_name = modifier + getAttributeValue(By.name("firstname"));
		contact.last_name = modifier + getAttributeValue(By.name("lastname"));
		contact.address_text = modifier + getAttributeValue(By.name("address"));
		contact.home_number = modifier + getAttributeValue(By.name("home"));
		contact.mobile_phone = modifier + getAttributeValue(By.name("mobile"));
		contact.work_phone = modifier + getAttributeValue(By.name("work"));
		contact.email_1 = modifier + getAttributeValue(By.name("email"));
		contact.email_2 = modifier + getAttributeValue(By.name("email2"));
		contact.bday = getAttributeValue(By.name("bday"));
		contact.bmonth = getAttributeValue(By.name("bmonth"));
		contact.bday_year = getAttributeValue(By.name("byear"));
		contact.secondary_address_text = modifier + getAttributeValue(By.name("address2"));
		contact.secondary_home_phone = modifier + getAttributeValue(By.name("phone2"));
		return contact;
	}

	public void updateContact() {
		click(By.cssSelector("input[value='Update']"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> allRows = driver.findElements(By.cssSelector("[name='entry']"));
		for (WebElement row : allRows) {
			ContactData contact = new ContactData();
			contact.first_name = getCellText(row, 2);
			contact.last_name = getCellText(row, 3);
			contact.email_1 = getCellText(row, 4);
			contact.home_number = getCellText(row, 5);
			contact.id = getCellInputValue(row,1);
			contacts.add(contact);
		} 
		return contacts;
	}

	public ContactData workAround4FirstLastNamesMessIssue(ContactData contact) {
		String temp = contact.last_name;
		contact.last_name = contact.first_name;
		contact.first_name = temp;
		return contact;
	}

}

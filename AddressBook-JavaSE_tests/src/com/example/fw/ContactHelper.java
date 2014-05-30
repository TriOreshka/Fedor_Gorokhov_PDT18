package com.example.fw;

import org.openqa.selenium.By;
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
		contact.first_name = modifier + getFieldText(By.name("firstname"));
		contact.last_name = modifier + getFieldText(By.name("lastname"));
		contact.address_text = modifier + getFieldText(By.name("address"));
		contact.home_number = modifier + getFieldText(By.name("home"));
		contact.mobile_phone = modifier + getFieldText(By.name("mobile"));
		contact.work_phone = modifier + getFieldText(By.name("work"));
		contact.email_1 = modifier + getFieldText(By.name("email"));
		contact.email_2 = modifier + getFieldText(By.name("email2"));
		contact.bday = getFieldText(By.name("bday"));
		contact.bmonth = getFieldText(By.name("bmonth"));
		contact.bday_year = getFieldText(By.name("byear"));
		contact.secondary_address_text = modifier + getFieldText(By.name("address2"));
		contact.secondary_home_phone = modifier + getFieldText(By.name("phone2"));
		return contact;
	}

	public void updateContact() {
		click(By.cssSelector("input[value='Update']"));
	}

}

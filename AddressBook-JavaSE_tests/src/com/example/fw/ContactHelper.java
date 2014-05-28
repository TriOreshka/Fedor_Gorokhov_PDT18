package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillAddNewAddressForm(ContactData addressData) {
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

}

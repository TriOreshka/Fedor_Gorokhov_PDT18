package com.example.tests;

import org.apache.commons.lang3.StringUtils;

public class ContactData implements Comparable<ContactData> {
	private String first_name;
	private String last_name;
	private String address_text;
	private String home_number;
	private String mobile_phone;
	private String work_phone;
	private String email_1;
	private String email_2;
	private String bday;
	private String bmonth;
	private String bday_year;
	private String secondary_address_text;
	private String secondary_home_phone;
	private String id;

	public ContactData() {
	}

	@Override
	public String toString() {
		return "ContactData [first_name=" + first_name + ", last_name="
				+ last_name + "]";
	}

	public String toSemicSV() {
		return StringUtils.join(new String[] { first_name, last_name,
				address_text, home_number, mobile_phone, work_phone, email_1,
				email_2, bday, bmonth, bday_year, secondary_address_text,
				secondary_home_phone, "!\n" }, ";");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		int firstNames = this.first_name.toLowerCase().compareTo(
				other.first_name.toLowerCase());
		if (firstNames == 0) {
			return this.last_name.toLowerCase().compareTo(
					other.last_name.toLowerCase());
		} else {
			return firstNames;
		}
	}

	public ContactData withFirstName(String first_name) {
		this.first_name = first_name;
		return this;
	}

	public ContactData withLastName(String last_name) {
		this.last_name = last_name;
		return this;
	}

	public ContactData withAddressText(String address_text) {
		this.address_text = address_text;
		return this;
	}

	public ContactData withHomeNumber(String home_number) {
		this.home_number = home_number;
		return this;
	}

	public ContactData withMobilePhone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
		return this;
	}

	public ContactData withWorkPhone(String work_phone) {
		this.work_phone = work_phone;
		return this;
	}

	public ContactData withEmail1(String email_1) {
		this.email_1 = email_1;
		return this;
	}

	public ContactData withEmail2(String email_2) {
		this.email_2 = email_2;
		return this;
	}

	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}

	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactData withByear(String bday_year) {
		this.bday_year = bday_year;
		return this;
	}

	public ContactData with2ndAddressText(String secondaryAddrText) {
		this.secondary_address_text = secondaryAddrText;
		return this;
	}

	public ContactData with2ndHomePhone(String secondary_home_phone) {
		this.secondary_home_phone = secondary_home_phone;
		return this;
	}

	public ContactData withID(String id) {
		this.id = id;
		return this;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getAddress_text() {
		return address_text;
	}

	public String getHome_number() {
		return home_number;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public String getEmail_1() {
		return email_1;
	}

	public String getEmail_2() {
		return email_2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getBday_year() {
		return bday_year;
	}

	public String getSecondary_address_text() {
		return secondary_address_text;
	}

	public String getSecondary_home_phone() {
		return secondary_home_phone;
	}

	public String getId() {
		return id;
	}

	public String getDay() {
		return bday;
	}

	public String getMonth() {
		return bmonth;
	}

}
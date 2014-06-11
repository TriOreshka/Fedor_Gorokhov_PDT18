package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String first_name;
	public String last_name;
	public String address_text;
	public String home_number;
	public String mobile_phone;
	public String work_phone;
	public String email_1;
	public String email_2;
	public String bday;
	public String bmonth;
	public String bday_year;
	public String secondary_address_text;
	public String secondary_home_phone;
	public String id;

	public ContactData() {
	}

	@Override
	public String toString() {
		return "ContactData [first_name=" + first_name + ", last_name="
				+ last_name + "]";
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
		int firstNames = this.first_name.toLowerCase().compareTo(other.first_name.toLowerCase());
		if (firstNames == 0) {
			return this.last_name.toLowerCase().compareTo(other.last_name.toLowerCase());
		} else {
			return firstNames;
		}
	}
	
	
}
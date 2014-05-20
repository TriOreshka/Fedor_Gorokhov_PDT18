package com.example.tests;

public class AddressData {
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

	public AddressData() {
	}
	
	public AddressData(String first_name, String last_name,
			String address_text, String home_number, String mobile_phone,
			String work_phone, String email_1, String email_2, String bday, String bmonth,
			String bday_year, String secondary_address_text,
			String secondary_home_phone) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address_text = address_text;
		this.home_number = home_number;
		this.mobile_phone = mobile_phone;
		this.work_phone = work_phone;
		this.email_1 = email_1;
		this.email_2 = email_2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.bday_year = bday_year;
		this.secondary_address_text = secondary_address_text;
		this.secondary_home_phone = secondary_home_phone;
	}
}
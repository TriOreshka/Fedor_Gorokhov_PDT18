package com.example.utils;

import java.util.Date;
import java.util.Random;

public class test {

	public static void main(String[] args) {
		Random rndd = new Random();
		Date randDate = new Date();
		String strDate = new String();
		String monthNames = "January;February;March;April;May;June;July;August;September;October;November;December";
		// Math.abs(System.currentTimeMillis()*rndd.nextFloat()));
		for (int i = 0; i < 20; i++) {
			long temp = (long) (System.currentTimeMillis()
					* (rndd.nextFloat() - 0.5) * 2);
			// randDate = new Date(Math.abs(System.currentTimeMillis() -
			// rndd.nextLong()));
			randDate = new Date(temp);
			strDate = randDate.toLocaleString();
			Integer month = new Integer(strDate.split("\\.")[1]);
			System.out.println("date=" + strDate + "; Month ="
					+ monthNames.split("\\;")[month - 1]);

		}

	}
}

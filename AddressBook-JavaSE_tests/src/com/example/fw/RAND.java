package com.example.fw;

import java.util.Date;
import java.util.Random;

public class RAND {
	
	//private Random rndd;

	static String doRandStr(String characters, int length) {
		Random rndd = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rndd.nextInt(characters.length()));
		}
		return new String(text);
	}

	public static String doRandDate() {
		Random rndd = new Random();
		long longDate = (long) (System.currentTimeMillis()
				* (rndd.nextFloat() - 0.5) * 2);
		Date randDate = new Date(longDate);
		String strDate = randDate.toLocaleString();
		String monthNames = "January;February;March;April;May;June;July;August;September;October;November;December";
		Integer month = new Integer(strDate.split("\\.")[1]);
		Integer dayStr = new Integer(strDate.split("\\.")[0]);
		String monthStr = " " + monthNames.split("\\;")[month - 1] + " ";
		String yearStr = (strDate.split("\\.")[2]).split(" ")[0];
		// System.out.println(dayStr + monthStr + yearStr);
		return (dayStr + monthStr + yearStr);
	}

	public static String randLetters(int len) {
		Random rndd = new Random();
		if (rndd.nextInt(5) == 0) {
			return "";
		} else {
			return doRandStr(
					"QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm", len);
		}
	}

	public static String randNumbers(int len) {
		Random rndd = new Random();
		if (rndd.nextInt(5) == 0) {
			return "";
		} else {
			return doRandStr("1234567890", len);
		}
	}

	public static String randNumbersNot0(int len) {
		return doRandStr("1234567890", len);
	}

	public static String randAll(int len) {
		Random rndd = new Random();
		if (rndd.nextInt(5) == 0) {
			return "";
		} else {
			return doRandStr(
					"QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890,.-(){}_",
					len);
		}
	}

	public static String randPhone() {
		Random rndd = new Random();
		if (rndd.nextInt(5) == 0) {
			return "";
		} else {
			return ("(" + randNumbersNot0(3) + ")" + randNumbersNot0(3) + "-"
					+ randNumbersNot0(2) + "-" + randNumbersNot0(2));
		}
	}

	public static String randEmail(String domen) {
		Random rndd = new Random();
		if (rndd.nextInt(5) == 0) {
			return "";
		} else {
			return randLetters(10) + "@" + randLetters(5) + domen;
		}
	}

	public static int getIntRand(int range) {
		Random rndd = new Random();
		return rndd.nextInt(range);
	}
}

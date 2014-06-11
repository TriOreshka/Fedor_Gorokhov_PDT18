package com.example.fw;

import java.util.Random;

public class RND {
	

	static String doRandStr(String characters, int length) {
	    char[] text = new char[length];
	    Random rndd = new Random();
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rndd.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
	public static String randLetters(int len) {
		Random rndd = new Random();
		if (rndd.nextInt(5) == 0) {
			return "";
		} else {
			return doRandStr("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm", len);
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
	
	public static String randAll(int len) {
		Random rndd = new Random();
		if (rndd.nextInt(5) == 0) {
			return "";
		} else {
			return doRandStr("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890,.-(){}_", len);
		}
	}
	
	public static String randPhone() {
		Random rndd = new Random();
		if (rndd.nextInt(5) == 0) {
			return "";
		} else {
			return ("(" + randNumbers(3) + ")" + randNumbers(3)+ "-" + randNumbers(2)+ "-" + randNumbers(2));
		}
	}
	
	public static String randEmail(String domen) {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {
			return randLetters(10) + "@" + randLetters(5) + domen;
		}
	}
	
	public static int getRandomInRange(int range) {
		Random rndd = new Random();
		return rndd.nextInt(range);
	}
}

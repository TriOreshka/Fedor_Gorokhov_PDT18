package com.example.fw;

import java.util.Random;

public class RandomHelper {

	static String doRandStr(String characters, int length) {
	    char[] text = new char[length];
	    Random rng = new Random();
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
	public static String randLetters(int len) {
	    return doRandStr("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm", len);
	}
	
	public static String randNumbers(int len) {
	    return doRandStr("1234567890", len);
	}
	
	public static String randAll(int len) {
	    return doRandStr("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890,.-(){}_", len);
	}
	
	public static String randPhone() {
	    return ("(" + randNumbers(3) + ")" + randNumbers(3)+ "-" + randNumbers(2)+ "-" + randNumbers(2));
	}
	
	public static String randEmail(String domen) {
		return randLetters(10) + "@" + randLetters(5) + domen;
	}
}

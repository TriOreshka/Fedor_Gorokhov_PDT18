package com.example.tests;

public class Sample {

	public static void main(String[] args) {
		String a = "+7-(926) -987 -6543";
		String b = a.replaceAll("[ ()\\-]", "");
		System.out.println("a=" + a + "; b=" + b);
		System.out.println(b.matches("\\+\\d+"));
	}

}

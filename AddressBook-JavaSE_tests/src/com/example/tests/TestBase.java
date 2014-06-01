/***
 * TestBase.java
 * 
 * Created on May 19-20, 2014 as home task 1&2 for training 
 * "Programming For Testers" by Software-testing.ru 
 * (http://www.software-testing.ru/events/864-programming-for-testers-new) 
 * 
 * Base test class, contains low-level implementation of all methods,
 * including setUp and tearDown 
 */
package com.example.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.example.fw.ApplicationManager;

public class TestBase {

	static ApplicationManager app; // was public

	@BeforeSuite
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterSuite
	public void tearDown() throws Exception {
		app.stop();
	}
}

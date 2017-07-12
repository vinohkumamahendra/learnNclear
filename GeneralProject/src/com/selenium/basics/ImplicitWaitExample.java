package com.selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWaitExample {

	public static void main(String[] args) {
		
		/**
		 * 
		 * implicit wait means that how much time that selenium code has to wait before throwing
		 * an exception when it is not able to find an element in a web page.
		 * 
		 * NOTE: implicit wait will be set for a entire session, which is applicable for all elements located by the script.
		 * Implicit wait will not be set for each element in the page.
		 */
		
		/**
		 * Here in this example, our code will look for element which is not available in the page.
		 * you have to notice here that exception will not heppen suddeny as it will happen after
		 * implicit wait time set in the code.
		 */
		
		FirefoxDriver firefox = new FirefoxDriver();
		//load url
		firefox.get("http://www.google.com");
		//maximize window
		firefox.manage().window().maximize();
		//set implicit timeout of 15 secs
		//firefox.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//click on timing alert button    (but there is no such element actually)
		firefox.findElementByName("Timing Alert").click();
		//closing the browser
		firefox.close();

		
	}

}

package com.selenium.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertHandling {

	public static void main(String[] args) {
		FirefoxDriver firefox = new FirefoxDriver();
		firefox.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

		WebElement clickMeLink = firefox.findElementByXPath("(//button[contains(text(),'Click me!')])[1]");
		clickMeLink.click();
		

		/**
		 * 1.SWITCH TO ALERT
		 * 2.READ THE TEXT
		 * 3.CLICK THE OK BUTTON 
		 * 
		 */
		
		Alert myAppAlert =firefox.switchTo().alert();
		String textInAlertBox = myAppAlert.getText();
		System.out.println("text in the box is "+textInAlertBox);
	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		myAppAlert.accept();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		firefox.close();

	}

}

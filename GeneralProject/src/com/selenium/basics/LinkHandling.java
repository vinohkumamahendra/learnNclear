package com.selenium.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkHandling {

	public static void main(String[] args) {
		FirefoxDriver firefox = new FirefoxDriver();
		firefox.get("http://www.seleniumeasy.com/test/window-popup-modal-demo.html");
//		WebElement alertLink = firefox.findElementByXPath("(//a[contains(text(),'Alerts & Modals')])[2]");
		WebElement alertLink = firefox.findElementByXPath("(//a[contains(text(),'Alerts & Modals')])[2]/preceding-sibling::i");
		alertLink.click();
		

		try {
			Thread.sleep(000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement windowPopUpLink = firefox.findElementByXPath("(//a[contains(text(),'Window Popup Modal')])[2]");
		windowPopUpLink.click();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		firefox.close();

	}

}

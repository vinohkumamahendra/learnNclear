package com.selenium.basics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsHandling {
	static WebDriver childWindowFirefox = null;

	public static void main(String[] args) {
		
		
		/*
		 * STEPS TO HANDLE MULTIPLE WINDOWS IN SELENIUM
		 * 
		 * 1. every window  
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		FirefoxDriver firefox = new FirefoxDriver();
		firefox.get("http://www.seleniumeasy.com/test/window-popup-modal-demo.html");

		// click 'follow on twitter' link
		firefox.findElementByXPath("//a[contains(text(),'Follow On Twitter')]").click();

		// get parent window ID and save for later control back process
		String parentWindowID = firefox.getWindowHandle();
		System.out.println("parent window ID " + parentWindowID);
		
		// get all window IDs
		Set<String> windowIDs = firefox.getWindowHandles();

		/**
		 * loop thru window IDs and switch to each window & do getTitle action to verify whether the current window title
		 * matches with expected window title
		 *  
		 */
		
		for (String windowID : windowIDs) {
			System.out.println(windowID);
			
			childWindowFirefox = firefox.switchTo().window(windowID);
			String title = childWindowFirefox.getTitle();
			System.out.println("TITLE is " + title);
			
			if (title.contains("Selenium Easy (@seleniumeasy) on Twitter")) {
				childWindowFirefox.findElement(By.xpath("//label[@for='username_or_email']")).sendKeys("eeerocks89@gmail.com");
			}

		}
	
		// bring control to parent window
		childWindowFirefox.switchTo().window(parentWindowID);

		// click facebook link  (doing action in parent window)
		firefox.findElementByXPath(
				"//a[contains(text(),'Like us On Facebook ')]").click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		firefox.quit();

	}

}

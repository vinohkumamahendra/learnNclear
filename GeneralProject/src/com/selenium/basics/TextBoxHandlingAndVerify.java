package com.selenium.basics;

import java.util.Vector;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBoxHandlingAndVerify {

	public static void main(String[] args) {
	
		/*
		 * Steps to be followed while using selenium jar to interact with an element
		 * 
		 * 1. Locate the element using any one of the locator methods available in FirefoxDriver/
		 *    ChromeDriver/InternetExplorerDriver class.
		 *    
		 * 2. Store the WebElement type object returned by findElementByXXX methods.
		 * 
		 * 3. Call the respective method from WebElement interface to interact with the element. 
		 */
		
		
		//launch browser 
		FirefoxDriver firefox = new FirefoxDriver();
		//load application URL
		firefox.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
		//find the 'enter message' text box as WebElement
		WebElement messageTextBox = firefox.findElementByXPath("//input[@placeholder='Please enter your Message']");
		//enter the message in 'enter message' text box
		messageTextBox.sendKeys("Prathik");
		
		//find the show message link as WebElement
		WebElement showMessageButton = firefox.findElementByXPath("//button[contains(text(),'Show Message')]");
		//click show message link
		showMessageButton.click();
		
		WebElement showmessagetext = firefox.findElementById("display");
		String actualMessageGettingDsiplayed = showmessagetext.getText();
		
		//compare the text and declare pass or fail
		System.out.println("actual value getting displayed "+actualMessageGettingDsiplayed );
		if(actualMessageGettingDsiplayed.equalsIgnoreCase("Prathik")){
			System.out.println("case passed");
		}else
		{
			System.out.println("case failed");
		}
		
		//close the active browser window
		firefox.close();
	}

}

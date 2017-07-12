package com.selenium.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample {

	public static void main(String[] args) {
		
		
		FirefoxDriver firefox = new FirefoxDriver();
		firefox.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		
		/**
		 * 1.FIND THE DROPDOWN AS ELEMENT
		 * 2.CRETAE OBJECT FOR SELECT CLASS
		 * 3.CALL THE METHOD AVAILABLE IN SELECT CLASS
		 * 
		 * Three ways to select value from dropdown:
		 * a.selectByIndes
		 * b.selectByValue
		 * c.selectByVisibleText
		 */

		//select by visible text
		/**WebElement dayDropDown =firefox.findElementById("select-demo");
		
		Select sel = new Select(dayDropDown);
		sel.selectByVisibleText("Wednesday");*/
		
		
		/**
		 * multiple select on drop down
		 */
				
				
		//select by value
		WebElement multiSelect = firefox.findElementById("multi-select");
		Select sel = new Select(multiSelect);
		sel.selectByValue("Florida");
		sel.selectByValue("New York");
		
		//wait for 5 secs
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		firefox.close();
	}

}

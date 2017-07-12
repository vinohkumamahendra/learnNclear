package com.selenium.basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SingleCheckBox {

	public static void main(String[] args) {
		
		try {
			FirefoxDriver firefox = new FirefoxDriver();
			firefox.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

			WebElement checkBox = firefox.findElementById("isAgeSelected");
			
			/**
			 * 1.Check whether 'check box' has been already selected or not
			 * 2.select the 'checkbox' only if not already selected (reason behind this is, if you try to 
			 *   select the already selected check box, it will un checked)
			 */
			
			if(!checkBox.isSelected()){
				checkBox.click();
			}

			Thread.sleep(5000);
			
			//close the browser
			firefox.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

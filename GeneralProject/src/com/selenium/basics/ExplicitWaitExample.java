package com.selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {

	public static void main(String[] args) {
		
		/**
		 * 
		 * Explicit wait in selenium makes the code to wait until mentioned condition is met.
		 * when the condition met, the next step of selenium code will be executed.
		 * 
		 * NOTE: selenium has predefined conditions for explicit wait, from that you can choose any.
		 */
		
		/**
		 * Here in this example, our code will wait for alert to be present. when the alert is available, 
		 * code execution will resume.
		 */
		
		FirefoxDriver firefox = new FirefoxDriver();
		
		//load url
		firefox.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		//maximize window
		firefox.manage().window().maximize();
		//set implicit timeout of 15 secs
		firefox.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		//click on timing alert button
		firefox.findElementByName("Timing Alert").click();
		
		//define explicit wait
		WebDriverWait wait = new WebDriverWait(firefox, 30);
		
		//wait for condition that alert is present
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//press OK on alert box
		alert.accept();
		firefox.close();

		
	}

}

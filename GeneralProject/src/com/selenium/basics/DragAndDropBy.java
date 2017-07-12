package com.selenium.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropBy {

	public static void main(String[] args) {
		//set path for gecko driver
		System.setProperty("webdriver.gecko.driver", "C:\\softwares\\selenium jars\\geckodriver.exe");
		FirefoxDriver firefox = new FirefoxDriver();
		firefox.get("http://www.seleniumeasy.com/test/drag-and-drop-demo.html");

		//find source element
		WebElement srcElement = firefox.findElementByXPath("//span[contains(text(),'Draggable 1')]");
		
		//find target/destination element
		WebElement destElement = firefox.findElementById("mydropzone");
		
		Actions dragAction = new Actions(firefox);
		dragAction.dragAndDrop(srcElement, destElement).build().perform();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		
		firefox.close();

	}

}

package com.selenium.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtility {
	
	RemoteWebDriver driver = null;
	WebElement element = null;
	String parentWindowID = null;
	boolean windowPresence = false;
	WebDriver childWindowdriver = null;
	
	/**
	 * This method launches required browser and loads the URL in it.
	 * @param browserName
	 * @param URLAddress
	 */
	public void launchBrowserAndLoadURL(String browserName, String URLAddress){
		if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("internet")){
			System.setProperty("webdriver.ie.driver", "C:\\softwares\\drivers\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "");
			driver = new ChromeDriver();
		}else{
			try {
				throw new Exception("invalid browser name");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public WebElement locateElement(String locatorType, String locator) throws Exception{
		try {
			if (locatorType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locator));
			} else if (locatorType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locator));
			} else if (locatorType.equalsIgnoreCase("class")) {
				driver.findElement(By.className(locator));
			} else if (locatorType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locator));
			}else if(locatorType.equalsIgnoreCase("css")){
				driver.findElement(By.cssSelector(locator));
			}else{
				throw new Exception("invalid locator");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	
		return element;
	}
	
	/**
	 * Handles text box
	 * @param locatorType id,name,class,xpath,css
	 * @param locator
	 * @param textValue
	 * @throws Exception 
	 */
	public void textBoxHandling(String locatorType, String locator, String textValue) throws Exception{
		try {
			locateElement(locatorType, locator).sendKeys(textValue);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void dropDownHandling(String locatorType, String locator, String valueToBeSelected) throws Exception{
		locateElement(locatorType, locator);
		
		try {
			Select select = new Select(element);
			select.selectByValue(valueToBeSelected);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void buttonHandling(String locatorType, String locator) throws Exception{
		locateElement(locatorType, locator).click();
	}	
	
	public void checkBoxHandling(String locatorType, String locator){
		try {
			element=locateElement(locatorType, locator);
			if(!element.isSelected()){
				element.click();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public WebDriver windowHandling(String titleOfExpectedWindow){
		parentWindowID = driver.getWindowHandle();
		System.out.println("parent window ID " + parentWindowID);
		
		// get all window IDs
		Set<String> windowIDs = driver.getWindowHandles();

		/**
		 * loop thru window IDs and switch to each window & do getTitle action to verify whether the current window title
		 * matches with expected window title
		 *  
		 */
		
		for (String windowID : windowIDs) {
			System.out.println(windowID);
			
			childWindowdriver = driver.switchTo().window(windowID);
			String title = childWindowdriver.getTitle();
			System.out.println("TITLE is " + title);
			
			if (title.contains(titleOfExpectedWindow)) {
				break;
			}

		}
		
		return childWindowdriver;

	}

	public void goBackParentWindow(String titleOfExpectedWindow){
		childWindowdriver.switchTo().window(parentWindowID);
	}

	public void framesHandling(String locatorType, String locator, String titleOfExpectedWindow) throws Exception{
		driver.switchTo().frame(locateElement(locatorType, locator));
	}
	
	public void goOutOfFrame(String titleOfExpectedWindow){
		driver.switchTo().defaultContent();
	}
	public void screenShot(){
		Random random = new Random();
		random.ints(4444, 5555);
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\screenShot"+random.nextInt()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String readData(String keyName, String fileName) {
		String value = null;
		try {

			Properties prop = new Properties();
			File file = new File(fileName);

			if (file.exists()) {
				FileInputStream fileinput = new FileInputStream(file);
				prop.load(fileinput);

				value = prop.getProperty(keyName);
			} 
				
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return value;
	}

	public void closeBrowsers(){
		driver.quit();
	}
	
	
}

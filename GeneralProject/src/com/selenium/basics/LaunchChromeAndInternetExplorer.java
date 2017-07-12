package com.selenium.basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchChromeAndInternetExplorer {

	public static void main(String[] args) {
		
		//set system property webdriver.chrome.driver property
		System.setProperty("webdriver.chrome.driver", "C:\\softwares\\chrome and IE drivers\\chromedriver.exe");
		ChromeDriver chrome = new ChromeDriver();
		chrome.get("https://www.google.com");

		//set system property webdriver.ie.driver
		System.setProperty("webdriver.ie.driver", "C:\\softwares\\chrome and IE drivers\\IEDriverServer.exe");
		InternetExplorerDriver iexplorer = new InternetExplorerDriver();
		iexplorer.get("https://facebook.com");
		
		
	
		
	}

}

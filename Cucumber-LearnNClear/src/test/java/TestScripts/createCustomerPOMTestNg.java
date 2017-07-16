package TestScripts;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = "src/test/resources/features/createCustomer.feature",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		glue={"stepDefinitionPOM"},
		tags = {}
		)
public class createCustomerPOMTestNg extends AbstractTestNGCucumberTests {

	public WebDriver driver;
	public HashMap<String,String> mRecord;
	
	
	
	
	
}

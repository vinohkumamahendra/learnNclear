package selenium;

import java.lang.annotation.Annotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class SimpleExample {
	private WebDriver driver;

	@Parameters({"browser"})
	@BeforeTest
	public void initDriver(String browser) throws Exception {
		if(browser.equalsIgnoreCase("Firefox")){
			System.out.println("You are testing in firefox");
			System.setProperty("webdriver.gecko.driver","driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.out.println("You are testing in chrome");
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.out.println("You are testing in Internet explorer");
			System.setProperty("webdriver.ie.driver", "driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		else{
			System.out.println("You are testing in Headless browser");
			driver = new HtmlUnitDriver();	
		}
	}

	@Test
	@Parameters({"browser"})
	public void searchTestNGInGoogle(String browser) throws InterruptedException {
		final String searchKey = "TestNG";
		System.out.println("Search " + searchKey + " in google");
		driver.navigate().to("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		System.out.println("Enter " + searchKey);
		element.sendKeys(searchKey);
		System.out.println("submit");
		element.submit();
		
	//	Thread.sleep(5000);
		
		System.out.println(driver.getTitle());
		
/*		(new WebDriverWait(driver, 30)).until(new ExpectedCondition() {
			public Boolean apply(WebDriver d) {
				System.out.println(browser + " ---> " + d.getTitle());
				return d.getTitle().toLowerCase()
						.startsWith(searchKey.toLowerCase());
			}

			@Override
			public Object apply(Object arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		});		System.out.println("Got " + searchKey + " results");*/
	}

	@AfterTest
	public void quitDriver() throws Exception {
		driver.quit();
	}
}

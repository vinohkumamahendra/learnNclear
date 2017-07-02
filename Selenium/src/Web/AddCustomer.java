package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddCustomer {
	
	public static void main(String[] args) throws InterruptedException {
		
		/*System.setProperty("webdriver.gecko.driver", 
				 "driver/geckodriver.exe");
		FirefoxDriver driver = new  FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.learnnshine.com/drupal/node/add/customers");
		driver.manage().window().maximize();
		driver.findElement(By.id("edit-title")).sendKeys("Vinoth Kumar");
		
		driver.findElement(By.id("edit-submit")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[text()='Gender field is required.']")).isDisplayed();
		driver.close();
	}

}

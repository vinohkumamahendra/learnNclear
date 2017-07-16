package stepDefinitionPOM;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import PageObjectModel.CreateCustomerLocator;
import PageObjectModel.CreateCustomerLocatorMethod;
import PageObjectModel.CreateCustomerObj;
import TestScripts.createCustomerPOMTestNg;
import TestScripts.createCustomerTestNg;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.Data;

public class CreateCustomerPOMStepDefi extends createCustomerPOMTestNg{
	
	@Given("^Open the Customer ADD Url$")
	public void open_the_Customer_ADD_Url() throws Throwable {
		System.out.println("Hello");
		System.setProperty("webdriver.chrome.driver", "browser/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://learnnshine.com/node/add/customers");
		driver.manage().window().maximize();
	}
	
	@Given("^Read customer \"(.*)\" from the Excel \"(.*)\" and Sheet \"(.*)\"$")
	public void open_the_Excel_with_Given_Sheet(String customerName,String spreadSheetName, String sheetName) throws Throwable {
		try {
			System.out.println(customerName);
			Data.data(spreadSheetName, sheetName).forEach(p->p.get("FirstName"));
			mRecord =  Data.data(spreadSheetName, sheetName).stream().filter(p -> p.get("FirstName").equalsIgnoreCase(customerName))
					.collect(Collectors.toList()).get(0);
			System.out.println(spreadSheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//mRecord = Data.data() -
	}
	
	@Given("^Open the Excel$")
	public void open_the_Excel() throws Throwable {
		mRecord = Data.data().get(0);
	}

	
	@Then("^Enter the detail from Spread sheet$")
	public void enter_the_detail_from_Spread_sheet() throws Throwable {
		System.out.println("Enter the data");
		CreateCustomerObj cc = PageFactory.initElements(driver, CreateCustomerObj.class);
		cc.mFillPersonalInformation(mRecord);
		cc.mFillPersentAddress(mRecord);
		cc.mFillPermanentAddress(mRecord);
		cc.mProfessionalDetails(mRecord);
		cc.mFillSummaryDetails(mRecord);	
	}

	@And("^Click Submit button$")
	public void click_Submit_button() throws Throwable {
		CreateCustomerObj cc = PageFactory.initElements(driver, CreateCustomerObj.class);
		cc.mClickSummit();
	}

	@And("^Accept Confirmation Alert$")
	public void accept_confirmation_alert() throws Throwable {
		driver.switchTo().alert().accept();
	}
	
	
	@But("^Veirfy the \"(.*?)\" require error message$")
	public void veirfy_the_require_error_message(String ErrorMessage)throws Throwable {
		System.out.println("Verify the error : " + ErrorMessage);
		Assert.assertTrue(ErrorMessage + "not displays", driver.findElement(By.className("error")).getText().contains(ErrorMessage));
	}
	
	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		System.out.println("Hello");
		driver.close();
	}
	
	@And("^Take the Screenshot$")
	public void take_Screenshot(){
		Random random = new Random();
		random.ints(4444, 5555);
		String screen = "CreateCustomer" + random.nextInt() + ".png";
		try {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("ScreenShot/" + screen ));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

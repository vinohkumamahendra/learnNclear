package stepdefinition;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.Utils;
import helper.Data;
import helper.SeleniumUtility;

public class CreateCustomer {
	public WebDriver driver;
	List<HashMap<String,String>> data;
	HashMap<String,String> singleRecord;
	SeleniumUtility util;	
	
	@Given("^Open the Customer ADD Url$")
	public void open_the_Customer_ADD_Url() throws Throwable {
		util = new SeleniumUtility();
		util.launchBrowserAndLoadURL("chrome", "http://learnnshine.com/node/add/customers");
	}
	
	@Given("^Open the Excel \"(.*)\" and Sheet \"(.*)\"$")
	public void open_the_Excel_with_Given_Sheet(String spreadSheetName, String sheetName) throws Throwable {
		System.out.println("Hi");
		System.setProperty("webdriver.chrome.driver", "browser/chromedriver.exe");
		driver = new ChromeDriver();
		util = new SeleniumUtility();
		util.launchBrowserAndLoadURL("chrome", "http://learnnshine.com/node/add/customers");
	}
	
	@Given("^Open the Excel$")
	public void open_the_Excel() throws Throwable {
		data = Data.data();
	}

	
	@Then("^Enter the detail from Spread sheet$")
	public void enter_the_detail_from_Spread_sheet() throws Throwable {
		System.out.println("Enter the data");
		singleRecord = data.get(0);	   	
		util.textBoxHandling("id","edit-title",singleRecord.get("FirstName"));
		util.textBoxHandling("id","edit-field-middle-name-und-0-value",singleRecord.get("MiddleName"));
		util.textBoxHandling("id","edit-field-last-name-und-0-value",singleRecord.get("LastName"));
		util.locateElement("xpath", ".//*[@id='edit-field-dob-und-0-value-datepicker-popup-0']").clear();
		util.textBoxHandling("xpath",".//*[@id='edit-field-dob-und-0-value-datepicker-popup-0']",singleRecord.get("DOB"));
		util.textBoxHandling("id","edit-field-mobile-number-und-0-number",singleRecord.get("Mobile"));
		util.textBoxHandling("id","edit-field-email-address-und-0-email",singleRecord.get("Email"));
		
		if(singleRecord.get("Gender").equals("Male"))
			util.buttonHandling("id","edit-field-gender-und-male");
		else if(singleRecord.get("Gender").equals("Female"))
			util.buttonHandling("id","edit-field-gender-und-female");
		
		// Present Address
		util.textBoxHandling("id","edit-field-present-address-und-0-name-line",singleRecord.get("FirstName") + singleRecord.get("MiddleName") + singleRecord.get("LastName"));
		util.textBoxHandling("id","edit-field-present-address-und-0-thoroughfare",singleRecord.get("Address1"));
		util.textBoxHandling("id","edit-field-present-address-und-0-premise",singleRecord.get("Address2"));
		util.textBoxHandling("id","edit-field-present-address-und-0-locality",singleRecord.get("City"));
		util.selectDropDown("id","edit-field-present-address-und-0-administrative-area",singleRecord.get("State"));
		util.textBoxHandling("id","edit-field-present-address-und-0-postal-code",singleRecord.get("Pincode"));
		
		//Permanent Address
		util.textBoxHandling("id","edit-field-permanent-address-und-0-first-name",singleRecord.get("FirstName"));
		util.textBoxHandling("id","edit-field-permanent-address-und-0-last-name",singleRecord.get("LastName"));
		util.textBoxHandling("id","edit-field-permanent-address-und-0-thoroughfare",singleRecord.get("Address1"));
		util.textBoxHandling("id","edit-field-permanent-address-und-0-premise",singleRecord.get("Address2"));
		util.textBoxHandling("id","edit-field-permanent-address-und-0-locality",singleRecord.get("City"));
		util.selectDropDown("id","edit-field-permanent-address-und-0-administrative-area",singleRecord.get("State"));
		util.textBoxHandling("id","edit-field-permanent-address-und-0-postal-code",singleRecord.get("Pincode"));
	/*	
		//Education Information
		util.checkBoxHandling("xpath",".//*[@id='edit-field-willing-to-work-und']/div[1]/label");
		util.locateElement("xpath",".//*[@id='customers-node-form']/div/fieldset[2]/legend/span/a").click();
		util.pause(2000);
		util.textBoxHandling("xpath",".//*[@id='edit-field-education-information-und-0-field-institution-name-und-0-value']",singleRecord.get("Institute"));
		util.textBoxHandling("xpath",".//*[@id='edit-field-education-information-und-0-field-degree-name-und-0-value']",singleRecord.get("Degree"));
		util.textBoxHandling("xpath",".//*[@id='edit-field-education-information-und-0-field-specialization-und-0-value']",singleRecord.get("Specialization"));
		util.selectDropDown("xpath",".//*[@id='edit-field-education-information-und-0-field-year-of-passing-und-0-value-year']",singleRecord.get("Year of Passing"));
		util.textBoxHandling("xpath",".//*[@id='edit-field-education-information-und-0-field-percentage-of-marks-und-0-value']",singleRecord.get("Percentage"));
		*/
		//Professional Information
		util.locateElement("xpath",".//*[@id='customers-node-form']/div/fieldset[3]/legend/span/a").click();
		util.pause(2000);
		util.textBoxHandling("xpath",".//*[@id='edit-field-professional-information-und-0-field-company-name-und-0-value']",singleRecord.get("Current Company"));
		util.textBoxHandling("xpath",".//*[@id='edit-field-professional-information-und-0-field-role-und-0-value']",singleRecord.get("Role"));
		util.locateElement("xpath",".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value-datepicker-popup-0']").clear();
		util.textBoxHandling("xpath",".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value-datepicker-popup-0']",singleRecord.get("Start Period"));
		util.locateElement("xpath",".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value2-datepicker-popup-0']").clear();
		util.textBoxHandling("xpath",".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value2-datepicker-popup-0']",singleRecord.get("End Period"));
		//Summary
		util.textBoxHandling("xpath",".//*[@id='edit-body-und-0-value']",singleRecord.get("Summary"));
		
	}

	@And("^Click Submit button$")
	public void click_Submit_button() throws Throwable {
		//click submit button
		util.buttonHandling("xpath",".//*[@id='edit-submit']");
	}

	@And("^Accept Confirmation Alert$")
	public void accept_confirmation_alert() throws Throwable {
		util.Ale();		
		util.pause(20000);	
	}
	
	
	@But("^Veirfy the \"(.*?)\" require error message$")
	public void veirfy_the_require_error_message(String ErrorMessage)throws Throwable {
		System.out.println("Verify the error : " + ErrorMessage);
		Assert.assertTrue(ErrorMessage + "not displays", util.locateElement("class","error").getText().contains(ErrorMessage));
	}
	
	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		util.closeBrowser();
	}

}

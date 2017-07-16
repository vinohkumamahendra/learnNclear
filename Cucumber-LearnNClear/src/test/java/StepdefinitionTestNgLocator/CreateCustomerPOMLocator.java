package StepdefinitionTestNgLocator;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import PageObjectModel.CreateCustomerLocator;
import TestScripts.createCustomerTestNg;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.Data;

public class CreateCustomerPOMLocator extends createCustomerTestNg{
	List<HashMap<String,String>> data;
	HashMap<String,String> singleRecord;	

	@Given("^Open the Customer ADD Url$")
	public void open_the_Customer_ADD_Url() throws Throwable {
		util.launchBrowserAndLoadURL("chrome", "http://learnnshine.com/node/add/customers");
	}
	
	@Given("^Open the Excel \"(.*)\" and Sheet \"(.*)\"$")
	public void open_the_Excel_with_Given_Sheet(String spreadSheetName, String sheetName) throws Throwable {
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
		util.textBoxHandling(CreateCustomerLocator.bFirstName,singleRecord.get("FirstName"));
		util.textBoxHandling(CreateCustomerLocator.bMiddleName,singleRecord.get("MiddleName"));
		util.textBoxHandling(CreateCustomerLocator.bLastName,singleRecord.get("LastName"));
		util.locateElement(CreateCustomerLocator.bDOB).clear();
		util.textBoxHandling(CreateCustomerLocator.bDOB,singleRecord.get("DOB"));
		util.textBoxHandling(CreateCustomerLocator.bMobile,singleRecord.get("Mobile"));
		util.textBoxHandling(CreateCustomerLocator.bEmail,singleRecord.get("Email"));
		
		if(singleRecord.get("Gender").equals("Male"))
			util.buttonHandling(CreateCustomerLocator.bGenderM);
		else if(singleRecord.get("Gender").equals("Female"))
			util.buttonHandling(CreateCustomerLocator.bGenderF);
		
		// Present Address
		util.textBoxHandling(CreateCustomerLocator.bAddressFullName,singleRecord.get("FirstName") + singleRecord.get("MiddleName") + singleRecord.get("LastName"));
		util.textBoxHandling(CreateCustomerLocator.bAddress1,singleRecord.get("Address1"));
		util.textBoxHandling(CreateCustomerLocator.bAddress2,singleRecord.get("Address2"));
		util.textBoxHandling(CreateCustomerLocator.bCity,singleRecord.get("City"));
		util.selectDropDown(CreateCustomerLocator.bState,singleRecord.get("State"));
		util.textBoxHandling(CreateCustomerLocator.bPincode,singleRecord.get("Pincode"));
		
		//Permanent Address
		util.textBoxHandling(CreateCustomerLocator.bPAdrrFName,singleRecord.get("FirstName"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrrLName,singleRecord.get("LastName"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrr1,singleRecord.get("Address1"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrr2,singleRecord.get("Address2"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrrCity,singleRecord.get("City"));
		util.selectDropDown(CreateCustomerLocator.bPAdrrState,singleRecord.get("State"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrrPinCode,singleRecord.get("Pincode"));
		
	/*	//Education Information
		util.checkBoxHandling(CreateCustomerLocator.bWillingLocation);
		util.locateElement(CreateCustomerLocator.bEduSection).click();
		util.pause(2000);
		util.textBoxHandling(CreateCustomerLocator.bEduInstitute,singleRecord.get("Institute"));
		util.textBoxHandling(CreateCustomerLocator.bEduDegree,singleRecord.get("Degree"));
		util.textBoxHandling(CreateCustomerLocator.bEduSpecification,singleRecord.get("Specialization"));
		util.selectDropDown(CreateCustomerLocator.bEduYOP,singleRecord.get("Year of Passing"));
		util.textBoxHandling(CreateCustomerLocator.bEduPercentage,singleRecord.get("Percentage"));
		*/
		//Professional Information
		util.locateElement(CreateCustomerLocator.bProSection).click();
		util.pause(2000);
		util.textBoxHandling(CreateCustomerLocator.bProFCompany,singleRecord.get("Current Company"));
		util.textBoxHandling(CreateCustomerLocator.bProFCompanyRole,singleRecord.get("Role"));
		util.locateElement(CreateCustomerLocator.bProFCompanySPeriod).clear();
		util.textBoxHandling(CreateCustomerLocator.bProFCompanySPeriod,singleRecord.get("Start Period"));
		util.locateElement(CreateCustomerLocator.bProFCompanyEPeriod).clear();
		util.textBoxHandling(CreateCustomerLocator.bProFCompanyEPeriod,singleRecord.get("End Period"));
		//Summary
		util.textBoxHandling(CreateCustomerLocator.bSummary,singleRecord.get("Summary"));
		
	}

	@And("^Click Submit button$")
	public void click_Submit_button() throws Throwable {
		//click submit button
		util.buttonHandling(CreateCustomerLocator.bSummit);
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
		System.out.println("Hello");
		util.closeBrowser();
	}

}

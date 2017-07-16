package stepdefinitionTestNgPOMLocator;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;

import PageObjectModel.CreateCustomerLocator;
import PageObjectModel.CreateCustomerLocatorMethod;
import TestScripts.createCustomerTestNg;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.Data;

public class CreateCustomerPOMLocatorMethod extends createCustomerTestNg{
	List<HashMap<String,String>> data;
	HashMap<String,String> singleRecord;	
	CreateCustomerLocatorMethod oCreateCustomer;

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
		oCreateCustomer =  new CreateCustomerLocatorMethod();
		oCreateCustomer.mFillPersonalInformation(util, singleRecord);
		oCreateCustomer.mFillPersentAddress(util, singleRecord);
		oCreateCustomer.mFillPermanentAddress(util, singleRecord);
		oCreateCustomer.mProfessionalDetails(util, singleRecord);
		oCreateCustomer.mFillSummaryDetails(util, singleRecord);
		
		
		
	}

	@And("^Click Submit button$")
	public void click_Submit_button() throws Throwable {
		oCreateCustomer.mClickSummit(util);
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
	
	@AfterMethod(alwaysRun = true)
	public void getScreen(){
		System.out.println("Screen Shot capture : " + util.screenShot("CreateCustomer"));
	}

}

package PageObjectModel;

import java.util.HashMap;

import org.openqa.selenium.By;

import helper.SeleniumUtility;

public class CreateCustomerLocatorMethod {

	private By bFirstName =	By.id("edit-title");
	private By bLastName =	By.id("edit-field-last-name-und-0-value");
	private By bMiddleName =	By.id("edit-field-middle-name-und-0-value");
	private By bDOB =	By.xpath(".//*[@id='edit-field-dob-und-0-value-datepicker-popup-0']");
	private By bMobile =	By.id("edit-field-mobile-number-und-0-number");
	private By bEmail =	By.id("edit-field-email-address-und-0-email");
	private By bGenderM =	By.id("edit-field-gender-und-male");
	private By bGenderF =	By.id("edit-field-gender-und-female");
	private By bAddressFullName =	By.id("edit-field-present-address-und-0-name-line");
	private By bAddress1 =	By.id("edit-field-present-address-und-0-thoroughfare");
	private By bAddress2 =	By.id("edit-field-present-address-und-0-premise");
	private By bCity=	By.id("edit-field-present-address-und-0-locality");
	private By bState =	By.id("edit-field-present-address-und-0-administrative-area");
	private By bPincode=	By.id("edit-field-present-address-und-0-postal-code");
	private By bPAdrrFName=	By.id("edit-field-permanent-address-und-0-first-name");
	private By bPAdrrLName=	By.id("edit-field-permanent-address-und-0-last-name");
	private By bPAdrr1=	By.id("edit-field-permanent-address-und-0-thoroughfare");
	private By bPAdrr2=	By.id("edit-field-permanent-address-und-0-premise");
	private By bPAdrrCity=	By.id("edit-field-permanent-address-und-0-locality");
	private By bPAdrrState=	By.id("edit-field-permanent-address-und-0-administrative-area");
	private By bPAdrrPinCode=	By.id("edit-field-permanent-address-und-0-postal-code");
	private By bWillingLocation=	By.xpath(".//*[@id='edit-field-willing-to-work-und']/div[1]/label");
	private By bEduSection=	By.xpath(".//*[@id='customers-node-form']/div/fieldset[2]/legend/span/a");
	private By bEduInstitute=	By.xpath(".//*[@id='edit-field-education-information-und-0-field-institution-name-und-0-value']");
	private By bEduDegree=	By.xpath(".//*[@id='edit-field-education-information-und-0-field-degree-name-und-0-value']");
	private By bEduSpecification=	By.xpath(".//*[@id='edit-field-education-information-und-0-field-specialization-und-0-value']");
	private By bEduYOP=	By.xpath(".//*[@id='edit-field-education-information-und-0-field-year-of-passing-und-0-value-year']");
	private By bEduPercentage=	By.xpath(".//*[@id='edit-field-education-information-und-0-field-percentage-of-marks-und-0-value']");
	private By bProSection=	By.xpath(".//*[@id='customers-node-form']/div/fieldset[3]/legend/span/a");
	private By bProFCompany=	By.xpath(".//*[@id='edit-field-professional-information-und-0-field-company-name-und-0-value']");
	private By bProFCompanyRole=	By.xpath(".//*[@id='edit-field-professional-information-und-0-field-role-und-0-value']");
	private By bProFCompanySPeriod=	By.xpath(".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value-datepicker-popup-0']");
	private By bProFCompanyEPeriod=	By.xpath(".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value2-datepicker-popup-0']");
	private By bSummary=	By.id("edit-body-und-0-value");
	private By bSummit=	By.id("edit-submit");


	
	
	public void mFillPersonalInformation(SeleniumUtility util , HashMap<String,String> singleRecord) throws Exception{
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
	}
	
	public void mFillPersentAddress(SeleniumUtility util , HashMap<String,String> singleRecord) throws Exception{
		// Present Address
		util.textBoxHandling(CreateCustomerLocator.bAddressFullName,singleRecord.get("FirstName") + singleRecord.get("MiddleName") + singleRecord.get("LastName"));
		util.textBoxHandling(CreateCustomerLocator.bAddress1,singleRecord.get("Address1"));
		util.textBoxHandling(CreateCustomerLocator.bAddress2,singleRecord.get("Address2"));
		util.textBoxHandling(CreateCustomerLocator.bCity,singleRecord.get("City"));
		util.selectDropDown(CreateCustomerLocator.bState,singleRecord.get("State"));
		util.textBoxHandling(CreateCustomerLocator.bPincode,singleRecord.get("Pincode"));
	}
	
	public void mFillPermanentAddress(SeleniumUtility util , HashMap<String,String> singleRecord) throws Exception{
		//Permanent Address
		util.textBoxHandling(CreateCustomerLocator.bPAdrrFName,singleRecord.get("FirstName"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrrLName,singleRecord.get("LastName"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrr1,singleRecord.get("Address1"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrr2,singleRecord.get("Address2"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrrCity,singleRecord.get("City"));
		util.selectDropDown(CreateCustomerLocator.bPAdrrState,singleRecord.get("State"));
		util.textBoxHandling(CreateCustomerLocator.bPAdrrPinCode,singleRecord.get("Pincode"));
	}
	
	public void mFillEducationDetails(SeleniumUtility util , HashMap<String,String> singleRecord) throws Exception{
		util.checkBoxHandling(CreateCustomerLocator.bWillingLocation);
		util.locateElement(CreateCustomerLocator.bEduSection).click();
		util.pause(2000);
		util.textBoxHandling(CreateCustomerLocator.bEduInstitute,singleRecord.get("Institute"));
		util.textBoxHandling(CreateCustomerLocator.bEduDegree,singleRecord.get("Degree"));
		util.textBoxHandling(CreateCustomerLocator.bEduSpecification,singleRecord.get("Specialization"));
		util.selectDropDown(CreateCustomerLocator.bEduYOP,singleRecord.get("Year of Passing"));
		util.textBoxHandling(CreateCustomerLocator.bEduPercentage,singleRecord.get("Percentage"));
	}
	
	public void mProfessionalDetails(SeleniumUtility util , HashMap<String,String> singleRecord) throws Exception{
		util.locateElement(CreateCustomerLocator.bProSection).click();
		util.pause(2000);
		util.textBoxHandling(CreateCustomerLocator.bProFCompany,singleRecord.get("Current Company"));
		util.textBoxHandling(CreateCustomerLocator.bProFCompanyRole,singleRecord.get("Role"));
		util.locateElement(CreateCustomerLocator.bProFCompanySPeriod).clear();
		util.textBoxHandling(CreateCustomerLocator.bProFCompanySPeriod,singleRecord.get("Start Period"));
		util.locateElement(CreateCustomerLocator.bProFCompanyEPeriod).clear();
		util.textBoxHandling(CreateCustomerLocator.bProFCompanyEPeriod,singleRecord.get("End Period"));
	}
	
	public void mFillSummaryDetails(SeleniumUtility util , HashMap<String,String> singleRecord) throws Exception{
		util.textBoxHandling(CreateCustomerLocator.bSummary,singleRecord.get("Summary"));
	}
	
	public void mClickSummit(SeleniumUtility util) throws Exception{
		util.buttonHandling(CreateCustomerLocator.bSummit);;
	}	

}

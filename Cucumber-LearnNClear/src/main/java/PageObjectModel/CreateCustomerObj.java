package PageObjectModel;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.SeleniumUtility;

public class CreateCustomerObj {
	WebDriver driver;
	
    @FindBy(id="edit-title")
    WebElement wFirstName;
    
    @FindBy(id="edit-field-last-name-und-0-value")
    WebElement wLastName;
    
    @FindBy(id="edit-field-middle-name-und-0-value")
    WebElement wMiddleName;
    
    @FindBy(id="edit-field-dob-und-0-value-datepicker-popup-0")
    WebElement wDOB;
    
    @FindBy(id="edit-field-mobile-number-und-0-number")
    WebElement wMobile;
    
    @FindBy(id="edit-field-email-address-und-0-email")
    WebElement wEmail;
    
    @FindBy(id="edit-field-gender-und-male")
    WebElement wMaleGender;
    
    @FindBy(id="edit-field-gender-und-female")
    WebElement wFemaleGender;
    
    @FindBy(id="edit-field-present-address-und-0-name-line")
    WebElement wAddrFullName;
    
    @FindBy(id="edit-field-present-address-und-0-thoroughfare")
    WebElement wAddr1;
    
    @FindBy(id="edit-field-present-address-und-0-premise")
    WebElement wAddr2;
    
    @FindBy(id="edit-field-present-address-und-0-locality")
    WebElement wCity;
    
    @FindBy(id="edit-field-present-address-und-0-administrative-area")
    WebElement wState;
    
    @FindBy(id="edit-field-present-address-und-0-postal-code")
    WebElement wPostalCode;
    
    @FindBy(id="edit-field-permanent-address-und-0-first-name")
    WebElement wPAddrFName;
    
    @FindBy(id="edit-field-permanent-address-und-0-last-name")
    WebElement wPAddrLName;
    
    @FindBy(id="edit-field-permanent-address-und-0-thoroughfare")
    WebElement wPAddr1;
    
    @FindBy(id="edit-field-permanent-address-und-0-premise")
    WebElement wPAddr2;
    
    @FindBy(id="edit-field-permanent-address-und-0-locality")
    WebElement wPAddrCity;
    
    @FindBy(id="edit-field-permanent-address-und-0-administrative-area")
    WebElement wPAddrState;
    
    @FindBy(id="edit-field-permanent-address-und-0-postal-code")
    WebElement wPAddrZip;
    
    @FindBy(xpath=".//*[@id='edit-field-willing-to-work-und']/div[1]/label")
    WebElement wWilingLocation;
    
    @FindBy(xpath=".//*[@id='customers-node-form']/div/fieldset[2]/legend/span/a")
    WebElement wEduSection;
    
    @FindBy(id="edit-field-education-information-und-0-field-institution-name-und-0-value")
    WebElement wEduInstitute;
    
    @FindBy(id="edit-field-education-information-und-0-field-degree-name-und-0-value")
    WebElement wEduDegree;
    
    @FindBy(id="edit-field-education-information-und-0-field-specialization-und-0-value")
    WebElement wEduSpecification;
    
    @FindBy(id="edit-field-education-information-und-0-field-year-of-passing-und-0-value-year")
    WebElement wEduYOP;
    
    @FindBy(id="edit-field-education-information-und-0-field-percentage-of-marks-und-0-value")
    WebElement wEduPercentage;
    
    @FindBy(xpath=".//*[@id='customers-node-form']/div/fieldset[3]/legend/span/a")
    WebElement wProfSection;
   
    @FindBy(id="edit-field-professional-information-und-0-field-company-name-und-0-value")
    WebElement wProfFCompany;
    
    @FindBy(id="edit-field-professional-information-und-0-field-role-und-0-value")
    WebElement wProfFCompnayRole;
    
    @FindBy(id="edit-field-professional-information-und-0-field-duration-und-0-value2-datepicker-popup-0")
    WebElement wProfFCompanyEPeriod;
    
    @FindBy(id="edit-field-professional-information-und-0-field-duration-und-0-value-datepicker-popup-0")
    WebElement wProfFCompanySPeriod;
    
    @FindBy(id="edit-body-und-0-value")
    WebElement wSummary;
    
    @FindBy(id="edit-submit")
    WebElement wSummitButton;
    
    
    public void mFillPersonalInformation(HashMap<String,String> singleRecord) throws Exception{
		wFirstName.sendKeys(singleRecord.get("FirstName"));
		wMiddleName.sendKeys(singleRecord.get("MiddleName"));
		wLastName.sendKeys(singleRecord.get("LastName"));
		wDOB.clear();
		wDOB.sendKeys(singleRecord.get("DOB"));
		wMobile.sendKeys(singleRecord.get("Mobile"));
		wEmail.sendKeys(singleRecord.get("Email"));
		
		if(singleRecord.get("Gender").equals("Male"))
			wMaleGender.click();
		else if(singleRecord.get("Gender").equals("Female"))
			wFemaleGender.click();
	}
	
	public void mFillPersentAddress(HashMap<String,String> singleRecord) throws Exception{
		// Present Address
		wAddrFullName.sendKeys(singleRecord.get("FirstName") + singleRecord.get("MiddleName") + singleRecord.get("LastName"));
		wAddr1.sendKeys(singleRecord.get("Address1"));
		wAddr2.sendKeys(singleRecord.get("Address2"));
		wCity.sendKeys(singleRecord.get("City"));
		wState.sendKeys(singleRecord.get("State"));
		wPostalCode.sendKeys(singleRecord.get("Pincode"));
		if(wWilingLocation.isSelected())
			wWilingLocation.click();	
	}
	
	public void mFillPermanentAddress(HashMap<String,String> singleRecord) throws Exception{
		//Permanent Address
		wPAddrFName.sendKeys(singleRecord.get("FirstName"));
		wPAddrLName.sendKeys(singleRecord.get("LastName"));
		wPAddr1.sendKeys(singleRecord.get("Address1"));
		wPAddr2.sendKeys(singleRecord.get("Address2"));
		wPAddrCity.sendKeys(singleRecord.get("City"));
		wPAddrState.sendKeys(singleRecord.get("State"));
		wPAddrZip.sendKeys(singleRecord.get("Pincode"));
	}
	
	public void mFillEducationDetails(HashMap<String,String> singleRecord) throws Exception{			
		wEduSection.click();
		Thread.sleep(2000);
		wEduInstitute.sendKeys(singleRecord.get("Institute"));
		wEduDegree.sendKeys(singleRecord.get("Degree"));
		wEduSpecification.sendKeys(singleRecord.get("Specialization"));
		wEduYOP.sendKeys(singleRecord.get("Year of Passing"));
		wEduPercentage.sendKeys(singleRecord.get("Percentage"));
	}
	
	public void mProfessionalDetails(HashMap<String,String> singleRecord) throws Exception{
		wProfSection.click();
		Thread.sleep(2000);
		wProfFCompany.sendKeys(singleRecord.get("Current Company"));
		wProfFCompnayRole.sendKeys(singleRecord.get("Role"));
		wProfFCompanySPeriod.clear();
		wProfFCompanySPeriod.sendKeys(singleRecord.get("Start Period"));
		wProfFCompanyEPeriod.clear();
		wProfFCompanyEPeriod.sendKeys(singleRecord.get("End Period"));
	}
	
	public void mFillSummaryDetails(HashMap<String,String> singleRecord) throws Exception{
		wSummary.sendKeys(singleRecord.get("Summary"));
	}
	
	public void mClickSummit() throws Exception{
		wSummitButton.click();
	}	
}

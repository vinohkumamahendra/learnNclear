package SeleniumUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Editaddress {
	static SeleniumUtility a=null;
	static RemoteWebDriver d;
	public static void main(String[] args) throws Exception {	
//		RemoteWebDriver driver = null;
		a= new SeleniumUtility();
		a.launchBrowserAndLoadURL("firefox", "http://learnnshine.com/drupal/node/add/customers");
		a.textBoxHandling("id","edit-title","Vignesh");
		a.textBoxHandling("id","edit-field-middle-name-und-0-value","Thevendriya");
		a.textBoxHandling("id","edit-field-last-name-und-0-value","Anandam");
		a.locateElement("xpath", ".//*[@id='edit-field-dob-und-0-value-datepicker-popup-0']").clear();
		a.textBoxHandling("xpath",".//*[@id='edit-field-dob-und-0-value-datepicker-popup-0']","10/29/1988");
		a.buttonHandling("id","edit-field-gender-und-male");
		a.textBoxHandling("id","edit-field-mobile-number-und-0-number","8122784828");
		a.textBoxHandling("id","edit-field-email-address-und-0-email","tavignesh@gmail.com");
		a.textBoxHandling("id","edit-field-present-address-und-0-name-line","Vignesh Thevendriya Anandam");
		a.textBoxHandling("id","edit-field-present-address-und-0-thoroughfare","45/18, Michael moopanar street");
		a.textBoxHandling("id","edit-field-present-address-und-0-premise","Kamarajar Salai");
		a.textBoxHandling("id","edit-field-present-address-und-0-locality","Madurai");
		a.dropDownHandling("id","edit-field-present-address-und-0-administrative-area",24);
		a.textBoxHandling("id","edit-field-present-address-und-0-postal-code","625009");
		a.textBoxHandling("id","edit-field-permanent-address-und-0-first-name","Vignesh");
		a.textBoxHandling("id","edit-field-permanent-address-und-0-last-name","Thevendriya Anandam");
		a.textBoxHandling("id","edit-field-permanent-address-und-0-thoroughfare","45/18, Michael moopanar street");
		a.textBoxHandling("id","edit-field-permanent-address-und-0-premise","Kamarajar Salai");
		a.textBoxHandling("id","edit-field-permanent-address-und-0-locality","Madurai");
		a.dropDownHandling("id","edit-field-permanent-address-und-0-administrative-area",24);
		a.textBoxHandling("id","edit-field-permanent-address-und-0-postal-code","625009");
		a.checkBoxHandling("xpath",".//*[@id='edit-field-willing-to-work-und']/div[1]/label");
		a.locateElement("xpath",".//*[@id='customers-node-form']/div/fieldset[2]/legend/span/a").click();
		a.textBoxHandling("xpath",".//*[@id='edit-field-education-information-und-0-field-institution-name-und-0-value']","KLNCIT");
		a.textBoxHandling("xpath",".//*[@id='edit-field-education-information-und-0-field-degree-name-und-0-value']","B.E");
		a.textBoxHandling("xpath",".//*[@id='edit-field-education-information-und-0-field-specialization-und-0-value']","CSE");
		a.dropDownHandling("xpath",".//*[@id='edit-field-education-information-und-0-field-year-of-passing-und-0-value-year']",18);
		a.textBoxHandling("xpath",".//*[@id='edit-field-education-information-und-0-field-percentage-of-marks-und-0-value']","80");
		a.locateElement("xpath",".//*[@id='customers-node-form']/div/fieldset[3]/legend/span/a").click();
		a.textBoxHandling("xpath",".//*[@id='edit-field-professional-information-und-0-field-company-name-und-0-value']","CTS");
		a.textBoxHandling("xpath",".//*[@id='edit-field-professional-information-und-0-field-role-und-0-value']","STA");
		a.locateElement("xpath",".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value-datepicker-popup-0']").clear();
		a.textBoxHandling("xpath",".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value-datepicker-popup-0']","5/2010");
		a.locateElement("xpath",".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value2-datepicker-popup-0']").clear();
		a.textBoxHandling("xpath",".//*[@id='edit-field-professional-information-und-0-field-duration-und-0-value2-datepicker-popup-0']","12/2017");
		a.textBoxHandling("xpath",".//*[@id='edit-body-und-0-value']","HI");
		a.buttonHandling("xpath",".//*[@id='edit-submit']");
		//a.windowHandling("are you sure about submitting the page");
		//a.goOutOfFrame("Create Customers | Online Software Testing Training");
		a.Ale();
		Thread.sleep(2000);
		a.launchBrowserAndLoadURL("firefox", "http://www.learnnshine.com/drupal/manage-customers");
		a.buttonHandling("xpath",".//*[@id='block-system-main']/div/div/div/table/tbody/tr[1]/td[4]/a[1]");
		a.locateElement("id","edit-field-present-address-und-0-thoroughfare").clear();
		a.locateElement("id","edit-field-present-address-und-0-premise").clear();
		a.locateElement("id","edit-field-permanent-address-und-0-locality").clear();
		a.locateElement("id","edit-field-present-address-und-0-postal-code").clear();
		a.textBoxHandling("id","edit-field-present-address-und-0-thoroughfare","Plot no 109");
		a.textBoxHandling("id","edit-field-present-address-und-0-premise","Medavakkam");
		a.textBoxHandling("id","edit-field-present-address-und-0-locality","Chennai");
		a.textBoxHandling("id","edit-field-present-address-und-0-postal-code","600100");
		a.buttonHandling("xpath",".//*[@id='edit-submit']");
		a.Ale();
		}

}

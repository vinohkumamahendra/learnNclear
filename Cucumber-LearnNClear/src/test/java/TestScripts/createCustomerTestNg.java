package TestScripts;

import org.testng.annotations.AfterMethod;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import helper.SeleniumUtility;
@CucumberOptions(
		features = "src/test/resources/features/createCustomer.feature",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		glue={"stepdefinitionTestNgPOMLocator"},
		tags = {}
		)
public class createCustomerTestNg extends AbstractTestNGCucumberTests {

	protected SeleniumUtility util = new SeleniumUtility();
	

}

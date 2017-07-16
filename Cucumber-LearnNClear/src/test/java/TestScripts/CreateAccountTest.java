package TestScripts;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/createCustomer.feature",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		glue={"stepdefinition"},
		tags = {}
		)
public class CreateAccountTest{
	
}	


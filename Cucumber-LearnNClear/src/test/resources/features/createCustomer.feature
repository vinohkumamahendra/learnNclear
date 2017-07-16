Feature: Create a new customer

Scenario: Create a customer without manadatory data
Given Open the Customer ADD Url
#Given Open the Excel "CustomerDetails" and Sheet "CustomerDetails"
#Given Open the Excel
Given Read customer "Nadimuthu" from the Excel "CustomerDetails.xlsx" and Sheet "CustomerDetails"
Then Enter the detail from Spread sheet
	And Click Submit button
	And Accept Confirmation Alert
	But Veirfy the "Institution Name field is required in the Educational Information collection" require error message
	Then Close the browser
package com.vtiger.stepdefinitions;

import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class leaddefinitions extends BaseTest {
	public LeadPage lp;
	
	@Given("^user should be create lead page$")
	public void user_should_be_create_page() throws Throwable {
		lp = new LeadPage(driver);
		lp.clickNewLead();
	   
	}
	
	@When("^user enter lastname and company name and click on save button$")
	public void create_lead() throws Throwable {
		lp.createleadwithmandatoryfields("Modi", "BJP");
	   
	}
	
	@When("^lead should be created successfully$")
	public void validate_leadcreation() throws Throwable {
		lp.verifyLogout();
	   
	}
	
	@When("^user need to click on logout$")
	public void click_logout() throws Throwable {
		lp.clickLogout();
	   
	}

}

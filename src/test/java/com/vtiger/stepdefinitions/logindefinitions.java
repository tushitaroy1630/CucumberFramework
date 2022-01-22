package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class logindefinitions extends BaseTest {
	
	
	@Given("^user should on login page$")
	public void user_should_on_login_page() throws Throwable {
		launchApp();  
	}
	
	


	@When("^user enters valid credentials and press login button$")
	public void user_enters_valid_credentials_and_press_login_button() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.validlogin("admin", "admin");
	   
	}
	
	@When("^user enters invalid userid as \"([^\"]*)\" and invalid password as \"([^\"]*)\"  and press login button$")
	public void user_enters_invalid_userid_as_and_invalid_password_as_and_press_login_button(String uid, String pwd) throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.validlogin(uid, pwd);
	}
	
	@When("^user enters invalid credentials and press login button$")
	public void user_enters_invalid_credentials_and_press_login_button() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.validlogin("admin1", "admin1");
	   
	}

	@Then("^user should landed on homepage$")
	public void user_should_landed_on_homepage() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.verifyHomeTab();
	   
	}

	@Then("^logut button should be appear$")
	public void logut_button_should_be_appear() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.clickLogout();
	  
	}
	
	@Then("^error message should appear$")
	public void error_message_should_appear() throws Throwable {
		
		LoginPage lp = new LoginPage(driver);
		lp.verifyErrorMsg();
	}
	
	@Then("^close the browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}


}

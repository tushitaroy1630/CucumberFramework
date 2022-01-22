package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import com.vtiger.utilities.GenericMethods;

public class LoginPage {
	
	private WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}
	
	//public WebElement username = driver.findElement(By.name("user_name"));
	////public WebElement pwd = driver.findElement(By.name("user_password"));
	//public WebElement btnLogin = driver.findElement(By.name("Login"));
	//By name = By.name("user_name");
	@FindBy(name="user_name") 
	WebElement username;
	
	@FindBy(name="user_password") 
	WebElement pwd;
	
	@FindBy(how = How.NAME, using = "Login") 
	WebElement btnLogin;
	
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password.')]") 
	WebElement errormsg;
	
	
	
	
	
	
	public void validlogin(String userid, String password)
	{
		GenericMethods.entervalue(driver, username, userid);
		GenericMethods.entervalue(driver, pwd, password);	
		GenericMethods.clickelement(driver, btnLogin);		
	}
	
	
	
	public void verifyErrorMsg()
	{
		errormsg.isDisplayed();
	}

}

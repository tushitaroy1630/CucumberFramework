package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utilities.GenericMethods;

public class LeadPage extends HeaderPage {
	private WebDriver driver;
	
	
	public LeadPage(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	
		
	}
	
	@FindBy(name="lastname") 
	WebElement lname;
	
	@FindBy(name="company") 
	WebElement company;
	
	@FindBy(name="button") 
	WebElement save;
	
	@FindBy(name="Edit") 
	WebElement Edit;
	
	public void createleadwithmandatoryfields(String lastname, String comp)
	{
		GenericMethods.entervalue(driver, lname, lastname);
		GenericMethods.entervalue(driver, company, comp);
		GenericMethods.clickelement(driver, save);		
	}
	
	public void verifyEditButton()
	{
		Edit.isDisplayed();
	}

}

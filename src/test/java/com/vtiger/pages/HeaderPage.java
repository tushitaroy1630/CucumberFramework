package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	
private WebDriver driver;
	
	
	public HeaderPage(WebDriver driver)
	{
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	@FindBy(linkText="Logout") 
	WebElement logout;
	
	@FindBy(linkText="New Lead") 
	WebElement NewLead;
	
	@FindBy(xpath="//a[@class='currentTab' and text()='Home']") 
	WebElement HomeTab;
	
	
	
	public void clickLogout()
	{
		logout.click();
	}
	
	public void clickNewLead()
	{
		NewLead.click();
	}
	
	public boolean verifyLogout()
	{
		return logout.isDisplayed();
	}
	
	public boolean verifyHomeTab()
	{
		return HomeTab.isDisplayed();
	}

	

}

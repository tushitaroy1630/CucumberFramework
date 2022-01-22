package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage extends HeaderPage {
	private WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	@FindBy(xpath="//table[@class='formOuterBorder']") 
	WebElement MyPipelines;
	
	
	
	
	public boolean verifyLogout()
	{
		return MyPipelines.isDisplayed();
	}
	
	

}

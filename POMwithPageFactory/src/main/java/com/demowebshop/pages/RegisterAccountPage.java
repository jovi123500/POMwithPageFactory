package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.PageUtility;

public class RegisterAccountPage extends PageUtility
	{
		WebDriver driver;
		public RegisterAccountPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//div[@class='header-links']//a[@class='account']")
		WebElement registerAccountName;
		@FindBy(xpath="//a[@class='ico-logout']")
		WebElement logout;
		@FindBy(xpath="//input[@value='Continue']")
		WebElement continuebutton;
		
		public String getUsername()
		{
			String result=getElementText(registerAccountName);
			return result;
		}
		
		public HomePage clickOnlogout()
		{
			clickOnElement(logout);
			return new HomePage(driver);
		}
		public UserAccountPage clickOnContinue()
		{
			clickOnElement(continuebutton);
			return new UserAccountPage(driver);
		}
	}

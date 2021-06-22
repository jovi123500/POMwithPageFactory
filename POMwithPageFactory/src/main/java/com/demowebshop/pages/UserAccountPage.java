package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.PageUtility;

public class UserAccountPage extends PageUtility
{
	WebDriver driver;
	public UserAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='header']//a[@class='account']")
	WebElement userAccountName;
//	WebElement userAccountName=driver.findElement(By.xpath("//div[@class='header']//a[@class='account']"));
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement logout;
	//WebElement logout=driver.findElement(By.xpath("//a[@class='ico-logout']"));
	public String getUserName() 
	{
		String result=getElementText(userAccountName);
		return result;
	}
	
	public HomePage clickOnlogout()
	{
		clickOnElement(logout);
		return new HomePage(driver);
	}
	
}

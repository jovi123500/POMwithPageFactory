package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.PageUtility;

public class HomePage extends PageUtility
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement loginmenu;
	//WebElement loginmenu=driver.findElement(By.xpath("//a[@class='ico-login']"));
	
	@FindBy(xpath="//a[@class='ico-register']")
	WebElement registermenu;
	
	public String getHomePageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public LoginPage clickOnLoginMenu()
	{
		loginmenu.click();
		return new LoginPage(driver);
	}
	public RegisterPage clickOnRegisterMenu()
	{
		registermenu.click();
		return new RegisterPage(driver);
	}
}

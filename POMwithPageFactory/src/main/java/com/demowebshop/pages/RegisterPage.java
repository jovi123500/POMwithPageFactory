package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.PageUtility;

public class RegisterPage extends PageUtility
{
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='page registration-page']")
	WebElement registerpage;
	@FindBys(
	@FindBy(xpath="//label[@class='forcheckbox']"))
	List<WebElement> gender;
	@FindBy(id="FirstName")
	WebElement firstname;
	@FindBy(id="LastName")
	WebElement lastname;
	@FindBy(id="Email")
	WebElement email;
	@FindBy(id="Password")
	WebElement pass;
	@FindBy(id="ConfirmPassword")
	WebElement confirmpass;
	@FindBy(id="register-button")
	WebElement registerbutton;
	
	public boolean isRegisterPageLoaded()
	{
		waitForElementToBeVisible(driver,registerpage,15);
		return getElementDisplayedStatus(registerpage);
	}
	
	
	public void selectGender(String gender1)
	{
		for(int i=0;i<gender.size();i++)
		{
			if(gender.get(i).getText().equals(gender1))
			{
				clickOnElement(gender.get(i));
			}
		}
	}
	
	public void enterFirstname(String fname)
	{
		enterText(firstname,fname);
	}
	public void enterLastName(String lname)
	{
		enterText(lastname,lname);
	}
	public void enteremail(String email1)
	{
		enterText(email,email1);
	}
	public void enterPassword(String pw)
	{
		enterText(pass,pw);
	}
	public void enterConfirmPassword(String cpw)
	{
		enterText(confirmpass,cpw);
	}
	public RegisterAccountPage clickOnRegisterButton()
	{
		clickOnElement(registerbutton);
		sleep(200);
		return new  RegisterAccountPage(driver);
	}
	
	
}

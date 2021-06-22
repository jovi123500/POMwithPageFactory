package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.RegisterAccountPage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;

public class RegisterTest extends Base
{
	HomePage home;
	LoginPage login;
	UserAccountPage userAccount;
	RegisterAccountPage registerAccount;
	RegisterPage register;
	
	//@Test
	public void verifyRegisterPageLoadOrNot()
	{
		home=new HomePage(driver);
		register= home.clickOnRegisterMenu();
		Boolean result=register.isRegisterPageLoaded();
		Assert.assertTrue(result, "registerpage not loaded");

	}
	@Test
	public void verifyRegister()
	{
		home=new HomePage(driver);
		register=home.clickOnRegisterMenu();
		register.selectGender("Female");
		register.enterFirstname("sana");
		register.enterLastName("ahamed");
		register.enteremail("sana123@gmail.com");
		register.enterPassword("sana@123);");
		register.enterConfirmPassword("sana@123");
		
		registerAccount=register.clickOnRegisterButton();
		String actualUserid=registerAccount.getUsername();
		String expectedUserid="sana123@gmail.com";
		Assert.assertEquals(actualUserid, expectedUserid,"registerpage not loaded");
		registerAccount.clickOnlogout();
		
	}
}

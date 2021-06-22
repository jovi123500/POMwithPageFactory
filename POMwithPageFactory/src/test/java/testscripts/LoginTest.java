package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;

public class LoginTest extends Base
{
	HomePage home;
	LoginPage login;
	UserAccountPage userAccount;
	@Test
	public void verifyLoginPageLoadOrNot()
	{
		home=new HomePage(driver);
		login= home.clickOnLoginMenu();
		Boolean result=login.isLoginPageLoaded();
		Assert.assertTrue(result, "loginpage not loaded");

	}
	@Test
	public void verifyLogin()
	{
		home=new HomePage(driver);
		login=home.clickOnLoginMenu();
		login.enterUsername("jovi123@gmail.com");
		login.enterPassword("jovi@123");
		userAccount=login.clickOnLoginButton();
		String actualUserid=userAccount.getUserName();
		String expectedUserid="jovi123@gmail.com";
		Assert.assertEquals(actualUserid, expectedUserid,"loginpage not loaded");
		userAccount.clickOnlogout();
	}
	

}

package com.demowebshop.automationcore;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base 
{
	public WebDriver driver;
	public void testInitialize(String browser) throws Exception
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","‪E:\\seleniumfiles\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","E:\\seleniumfiles\\driverfiles\\geckodriver-v0.29.1-win32\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","E:\\seleniumfiles\\driverfiles\\edgedriver_win32\\edgedriver.exe");
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid browser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.get("http://demo.guru99.com/test/newtours/");
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	@Parameters({"url","browser"})
	public void setUp(String urlValue,String browserName) throws Exception
	{
		testInitialize(browserName);
		driver.get(urlValue);
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException 
	{
	if(ITestResult.FAILURE==result.getStatus())
	{
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./Screenshots/"+result.getName()+".png"));
	}
	}
	{
		//driver.close();
		// driver.quit();
	}
	
}

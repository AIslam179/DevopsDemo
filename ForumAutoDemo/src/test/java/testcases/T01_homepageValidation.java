package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.browserEng;
import utilities.testData;

public class T01_homepageValidation {
	
	
	// Import Selenium Web Driver interface 
		
	public static WebDriver driver;
	
	@BeforeMethod 

	public static void openBrowser()

	{
		//open Browser
		driver=browserEng.browserConfig();
	}
	
	@Test 

	public static void homepage()

	{ 
		
		// Load the application under test 
		driver.get(testData.homepageURL);
		
				
		// Home page title validation 
		
		String homepageActualT= driver.getTitle();
		
		
		Assert.assertEquals(homepageActualT, testData.homepageTitleExpected);
		
	}
	
	@AfterMethod

	public static void tearDown()


	{
		
		//close the browser 
		  driver.close();
	}





}

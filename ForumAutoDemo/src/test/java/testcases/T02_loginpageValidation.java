package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.browserEng;
import utilities.testData;

public class T02_loginpageValidation {
	
	public static WebDriver driver;

@BeforeMethod 

public static void openBrowser()

{
	driver=browserEng.browserConfig();
}




@Test 

public static void loginpage()

{
	driver.get(testData.logpageURL);
	
	
	String logpageActualT = driver.getTitle();
	
	Assert.assertEquals(logpageActualT, testData.loginpageTitle1Expected);
	
	// Identify the UID Text and send the vslue 
	
	driver.findElement(By.name("email")).sendKeys(testData.loginUID);
	
	// Identify the Password text box and send the value 
	
	driver.findElement(By.name("password")).sendKeys(testData.loginPW);
	
	// click the signIn Button 
	
	driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[2]/div[3]/div[2]/button")).click();
	
}


@AfterMethod

public static void tearDown()


{
	driver.close();
}



}

package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.browserEng;
import utilities.testData;

public class T03_registrationpageValidation {

	public static WebDriver driver;

	@BeforeMethod

	public static void openBrowser()

	{
		driver = browserEng.browserConfig();
	}

	@Test

	public static void loginpage() throws Exception

	{
		driver.get(testData.forumRegistrationURL);

		String forumRegistrationActualT = driver.getTitle();

		Assert.assertEquals(forumRegistrationActualT, testData.forumRegistrationTitleExpected);

		// Select Language from drop down field

		WebElement language = driver.findElement(By.name("language"));

		Select anylanguage = new Select(language);
		// Select by Index
		// anylanguage.selectByIndex(1);

		// Select by value

		// anylanguage.selectByValue("Bangla");

		// Select by visuble text

		// anylanguage.selectByVisibleText("Spanish");

		// WebElement submit=driver.findElement(By.name("submit"));
		// submit.click();

		// Print all the options for the selected drop down and select one option of
		// your choice

		// Get the size of the Select element

		List<WebElement> oSize = anylanguage.getOptions();

		int iListSize = oSize.size();

		// Setting up the loop to print all the options

		for (int i = 0; i < iListSize; i++) {

			// Storing the value of the options

			String sValue = anylanguage.getOptions().get(i).getText();

			// Printing the stored value

			// System.out.println(sValue);

			// Putting a check on each option that if any of the option is equal to
			// "Bangla" then select it

			if (sValue.equalsIgnoreCase("Bangla")) {

				anylanguage.selectByIndex(i);
				break;

			}
		}

		// Enter the First Name in the First Name field

		driver.findElement(By.name("fname")).sendKeys(testData.forumFirstName);

		// Enter the last Name in the Last Name field

		driver.findElement(By.name("lname")).sendKeys(testData.forumLastName);

		// Enter the email in the Email field

		driver.findElement(By.name("email")).sendKeys(testData.forumEmail);

		// Enter the phone in the phone field

		driver.findElement(By.name("phone")).sendKeys(testData.forumPhone);
        
		// Enter the Password in the Password field

		driver.findElement(By.name("password")).sendKeys(testData.forumPWD);
		// Checked Gender
		WebElement maleRadioWe = driver.findElement(By.xpath("//*[@type='radio' and @value='male']"));

		if (maleRadioWe != null && !maleRadioWe.isSelected()) {
			maleRadioWe.click();
		}
		
		// Select Course from drop down field

		WebElement course= driver.findElement(By.name("course"));

		Select anycourse = new Select(course);
		// Select by visuble text

		anycourse.selectByVisibleText(testData.forumCourse);
		
		//Checked Gender
				WebElement checkboxWe=driver.findElement(By.xpath("//*[@type='checkbox']"));
				
				if (checkboxWe != null && !checkboxWe.isSelected()) {
					checkboxWe.click();
				}
				
				//click on Sign Up button
				WebElement signUpBtn=driver.findElement(By.xpath("//*[@type='submit']"));
				if (signUpBtn != null) {
					signUpBtn.click();
					Thread.sleep(2000);
				}
		
	}
	
	

	

	@AfterMethod

	public static void tearDown()

	{
		driver.close();
	}

}

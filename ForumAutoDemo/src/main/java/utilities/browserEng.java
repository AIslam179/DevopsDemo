package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserEng {
	
	public static WebDriver driver;
	
public static WebDriver browserConfig()
	
	{
		
     // System.setProperty("webdriver.chrome.driver","C:\\Users\\abumi\\eclipse-workspaceUdemyPractice\\ForumAuto\\drivers\\chromedriver.exe");
		
	// driver= new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\abumi\\eclipse-workspaceUdemyPractice\\ForumAuto\\drivers\\geckodriver.exe");
		 
		driver=new FirefoxDriver();
			
		System.out.println("Firefox Browser opened");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;

}
}

package take_Home_WebDriver_Test.reusableBaseTestComponents;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableBaseTest {
	
	public WebDriver driver;
	
	// Parent URL of the web site
	//public String baseURL = "http://localhost:7080";
	
	public String baseURL = "https://the-internet.herokuapp.com/";
	
	protected String downloadPath = System.getProperty("user.dir");
	
	/*
	  General Requirement -02 
	   All the tests is initiating the browser before test
	 */
	@BeforeMethod
	public WebDriver intitiateBrowser() {
		
		// Setting up the ChromeDriver
		WebDriverManager.chromedriver().setup();
		
		
		
		
		// This HashMap send commands to the WebDriver that what ever it is
				//downloading store in the project.
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("download.default_directory", downloadPath);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				
		
		driver = new ChromeDriver(options);
		// maximise the chrome browser
		driver.manage().window().maximize();
		
		// wait at least 5 seconds at the beginning of chrome browser loading
		// so that all the elements become visible.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
	
	 
	/*
	  General Requirement -02 
	   All the tests is closing the browser after test
	 */
	@AfterMethod
	public void tearBrowser() {
		driver.quit();
	}
	 
	  
	 
} // class ReusableBaseTest ends

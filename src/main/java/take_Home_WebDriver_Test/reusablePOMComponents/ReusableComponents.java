package take_Home_WebDriver_Test.reusablePOMComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReusableComponents {
	
	WebDriver driver;
	
	// Constructor
	public ReusableComponents(WebDriver driver) {
		this.driver = driver;
		// Defining Page Factory Pattern in this class
		PageFactory.initElements(driver, this);
	}
	
	


}

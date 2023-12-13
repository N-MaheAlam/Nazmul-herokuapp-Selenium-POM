package take_Home_WebDriver_Test.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import take_Home_WebDriver_Test.reusablePOMComponents.ReusableComponents;

public class LoginPage extends ReusableComponents {

		// this driver we will use in this class
		WebDriver driver;
		private String correctUserName	=	"tomsmith";
		private String correctPassword	=	"SuperSecretPassword!";
		private String wrongUserName	=	"Nazmul";
		private String wrongPassword	=	"nazmulMaheAlam";
		private String compareSuccessLoginMessage	= 
				"Welcome to the Secure Area. When you are done click logout below.";
		private String compareWrongPasswordMessage 	= "Your password is invalid!\n"
				+ "×";
		private String compareWrongUserNameMessage	= "Your username is invalid!\n"
				+ "×";
		
		
		
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} // Constructor ends 
	
	
	// user Name locator
	private @FindBy(id="username")
	WebElement userName;
	
	// password locator
	 private @FindBy(id="password")
	WebElement userPassword;
	
	 // Login Button locator
	 private @FindBy(css="button[type='submit']")
	WebElement loginButton;
	 
	// After login the succes message locator
	private @FindBy(css=".subheader")
	WebElement successLoginMessageLocator;
				
	private @FindBy(css="#flash")
	WebElement loginErorMessageLocator;
	
	 // log in credentials to log  in the URL
	public void login(String name, String password) {
		userName.sendKeys(name);
		userPassword.sendKeys(password);
		loginButton.click();
		
	} // login
	
	// get the success message from Browser
	public String getSuccessLoginMessage() {
		return successLoginMessageLocator.getText();
			
			}//getSuccessLoginMessage ends 
	
	// get the error message from the browser
	public String getLoginErrorMessage() {
		return loginErorMessageLocator.getText();
	}
	
	
	// return the correctUserName variable value by this method 
	public String getCorrectUserName() {
		return correctUserName;
	} //getCorrectUserName() ends 
	
	
	// return the correctPassword variable value by this method 
	public String getCorrectPassword() {
		return correctPassword;
	}//getCorrectPassword() ends 
	
	
	// return the wrongUserName variable value by this method 
	public String getWrongUsername() {
		return wrongUserName;
	} //getWrongUsername() ends
	
	
	// return the wrongPassword variable value by this method 
	public String getWrongPassword() {
		return wrongPassword;
	}//getWrongPassword() ends 
	
	
	// return the compareSuccessLoginMessage variable value by this method 
	public String getCompareSuccessLoginMessage()
	{
		return compareSuccessLoginMessage;
	} //getExactSuccessLoginMessage() ends
	
	// return the compareWrongPasswordMessage variable value by this method
	public String getCompareWrongPasswordMessage()
	{
		return compareWrongPasswordMessage;
	} //getCompareWrongPasswordMessage() ends
	
	
	// return the compareWrongUserNameMessage variable value by this method
	public String getCompareWrongUserNameMessage() {
		return compareWrongUserNameMessage;
	}// getCompareWrongUserNameMessage() ends

} // class LoginPage ends

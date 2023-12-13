package take_Home_WebDriver_Test.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import take_Home_WebDriver_Test.reusablePOMComponents.ReusableComponents;

public class AllTestsPageObjectModelExceptLoginPage extends ReusableComponents {
	
		WebDriver driver;
	public AllTestsPageObjectModelExceptLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	} //constructor ends
	
	
	
	// ****** code for check boxes  START *********
	 private @FindBy(xpath= ("(//input[@type='checkbox'])[1]"))
	WebElement unchecheckToCheckLocator;
	 
	 private @FindBy(xpath=("(//input[@type='checkbox'])[2]"))
		WebElement checheckToUncheckLocator;
	 
	 public Boolean isUncheckToCheckSelected() {
		 return unchecheckToCheckLocator.isSelected();
		 
	 } //isUncheckToCheckSelected
	 
	 public void getClickUncheckToCheck() {
		 unchecheckToCheckLocator.click();
	 }
	 public Boolean isChecheckToUnCheckSelected() {
		 return checheckToUncheckLocator.isSelected();
	 } //isChecheckToUnCheckSelected
	 
	 public void getClickCheckToUnCheck() {
		 checheckToUncheckLocator.click();
	 }//getClickCheckToUnCheck
	 
	  // ****** code for check boxes  END *********
	 
	 
	// ****** code for context menu  START *********
	 
	  private @FindBy(id = ("hot-spot"))
	  	WebElement contextMenuSpot;
	  public WebElement getContextMenuSpot() {
		  return contextMenuSpot;
	  }
	  
	  private String alertTextMessage = "You selected a context menu";
	  
	  public String  getAlertTextMessage() {
		  return alertTextMessage;
	  }
	 
	// ****** code for context menu  END *********
	 
	// ****** code for Drag and Drop  START *********
	 
	  // First Drag "A"
	  private @FindBy(id =("column-a"))
	  WebElement sourcePath;
	  
	  
	  public WebElement getSourcePath() {
		  return sourcePath;
	  }
	  
	  // 2nd Drag "B"
	  private @FindBy(id = ("column-b"))
	  WebElement destinationPath;
	  
	  public WebElement getDestinationPath() {
		  return destinationPath;
	  }
	  //After Drag the xpath of A
	  private @FindBy(css =("div[id='column-a'] header"))
	  WebElement afterDragPath;
	  
	  //get the text of A
	  public String getAfterDragPathText() {
		  return afterDragPath.getText();
	  }
	// ****** code for Drag and Drop  END *********

	// ****** code for Drop Down Menu  START *********
	  
	  
	  
	  private @FindBy(id ="dropdown")
	  WebElement dropDownPath;
	  
	  public WebElement getDropDownPath() {
		  return dropDownPath;
	  }
	  
	  private String firstOption = "Option 1";
	  
	  public String getOptionOne() {
		  return firstOption;
	  }
	  private String secondOption = "Option 2";
	  
	  public String getOption2nd() {
		  return secondOption;
	  }
	// ****** code for Drop Down Menu  END *********
	 
	  
	// ****** code for Dynamic Control  START *******
	  
	  
	  private @FindBy(css = ("button[onclick='swapCheckbox()']"))
	  WebElement firstCheckBoxPath;
	  
	  public void getFirstCheckBoxPath() {
		   firstCheckBoxPath.click();
	  }
	  
	 
	  
	  private @FindBy(id =("message"))
	  WebElement dynamicControlRemoverButtonPath;
	  
	  public WebElement getDynamicControlRemoverButtonPath() {
		  return dynamicControlRemoverButtonPath;
	  }
	  private String goneMessage = "It's gone!";
	  
	  public String getGoneMessage() {
		  return goneMessage;
	  }
	  
	  
	  
	  private @FindBy(css=("button[onclick='swapInput()']"))
	  WebElement enableButtonPath;
	  
	  public void clickOnEnableButton() {
		   enableButtonPath.click();
	  }
	  
	  
	  private @FindBy(css= ("form[id='input-example'] p[id='message']"))
	  WebElement afterClickingDisabledButtonPath;
	  
	  public WebElement getAfterClickingDisabledButtonPath() {
		  return afterClickingDisabledButtonPath;
	  }
	  
	  public String getAfterClickingDisabledButtonText() {
		  return afterClickingDisabledButtonPath.getText();
	  }
	  
	  private String enableMessage = "It's enabled!";
	  
	  public String getEnableMessage() {
		  return enableMessage;
	  }
	// ****** code for Dynamic Control  END *********
	  
	// ****** code for File UPLOAD  START *********
	  
	
	  
	  private @FindBy(xpath =("//input[@id='file-upload']"))
	  WebElement filUploadPath;
	  
	  public void sendFileUploadDirection() {
		  filUploadPath.sendKeys(System.getProperty("user.dir")
				+ "/src/main/java/take_Home_WebDriver_Test/dataResources/UploadFile.txt");
	  }
		  
	  private @FindBy(id =("file-submit"))
	  WebElement fileSubmitButtonPath;
	  
	  public void clickOnFileSubmitButton() {
		  fileSubmitButtonPath.click();
	  }
	  
	  
	  private @FindBy(css =("div[class='example'] h3"))
	  WebElement fileUploadConfirmationPath;
	  
	  public String getFileUploadConfirmationPathText() {
		  return fileUploadConfirmationPath.getText();
	  }
	  
	  private String fileUploadString = "File Uploaded!";
	  public String getFileUploadString() {
		  return fileUploadString;
	  }
	// ****** code for File UPLOAD END *********
	  
	// ****** code for File DOWNLOAD START *****
	  
	  
	  private @FindBy(css=("a[href='download/some-file.txt']"))
	  WebElement fileDownLoadPath;
	  
	  public void clickOnFileDownLoad() {
		  fileDownLoadPath.click();
	  }
	
	// ****** code for File DOWNLOAD START *****
	  
	  
	// ****** code for DYANMIC CONTROL START ****
	  
	  
	  private @FindBy(css=("div[id='start'] button"))
	  WebElement startButtonPath;
	  
	  public void clickOnStartButtonDyanamicLoading() {
		  startButtonPath.click();
	  }
	  
	
	  private @FindBy(id=("finish"))
	  WebElement dynamicLoadingText;
	  
	  public WebElement dynamicLoadingTextLocation() {
		  return dynamicLoadingText;
	  }
	  
	  public String getDynamicLoadingText() {
		  return dynamicLoadingText.getText();
	  }
	  
	  private String dynamicHelloWorldText = "Hello World!";
	  
	  public String getDynamicHelloWorldString() {
		  return dynamicHelloWorldText;
	  }
	  
	// ****** code for DYANMIC CONTROL END ****
	  
	// ****** code for FLOATING MENU START ****
	
	
	  private @FindBy (css=("a[href='#news']"))
	  WebElement newsButtonPath;
	  
	  public String getNewsButtonText() {
		  return newsButtonPath.getText();
	  }
	  
	  private String newsButtonString = "News";
	  
	  public String getNewsButtonString() {
		  return newsButtonString;
	  }
	// ****** code for FLOATING MENU START ****
	 
	  
	// // ****** code for I FRAME START ****
	  // I Frame xpath
	  private @FindBy(xpath=("//iframe[@id='mce_0_ifr']"))
	  WebElement switchIFramePath;
	  
	  // get the I frame location path
	  public WebElement getToSwichiFramePathLoaction() {
		  return switchIFramePath;
	  }
	  
	  // Inside I frame 
	  private @FindBy(id=("tinymce"))
	  WebElement insideIFramePath;
	  
	  public void getInsideIFramePathClear() {
		   insideIFramePath.clear();
	  }
	  public void getAndPutStringInIframePath(String str) {
		  
		  // clear inside I frame
		  //insideIFramePath.clear();
		  //put the string "str"
		  insideIFramePath.sendKeys(str);
	  }
	  
	  // A string which will be used to compare 
	  private String putThisStringInIFrame = "Nazmul Mahe Alam ";
	  
	  // call that above string by this method
	  public String getPutThisStringInIFrame() {
		  return putThisStringInIFrame;
	  }
	  
	 // get the text that we will put inside the Frame
	 public String getTheNewStringInsideIFrame() {
		 return insideIFramePath.getText();
	 }
	    
	// ****** code for I FRAME END ****
	
	 
	// ****** code for MOUSE HOVER START ****
	 
	 // This string shows when we hover in every image 
	 private String viewProfileString = "View profile";
	 
	 // get the String "View profile"
	 public String getViewProfileString() {
		 return viewProfileString;
	 }
	
	 // first image xpath
	 private @FindBy(xpath=("(//img[@alt='User Avatar'])[1]"))
	 WebElement firstImgPath;
	 
	 // get the first image xpath
	 public WebElement getFirstImgPath() {
		 return firstImgPath;
	 }
	 
	 private @FindBy(xpath=("(//div/a[contains(text(),'View profile')])[1]"))
	 WebElement firstImagetextlocation;
	 // get the text present in first image 
	 public String getFirstImgNameText() {
		 return firstImagetextlocation.getText();
	 }
	 
	// 2nd image xpath
	 private @FindBy(xpath=("(//img[@alt='User Avatar'])[2]"))
	 WebElement secondImgPath;
	 
	// get the 2nd image xpath
	 public WebElement getSecondImgPath() {
		 return secondImgPath;
	 }
	 
	 private @FindBy(xpath=("(//div/a[contains(text(),'View profile')])[2]"))
	 WebElement secondImagetextlocation;
	 
	 // get the text present in first image 
	 public String getSecondImgNameText() {
		 return secondImagetextlocation.getText();
	 }
	 
	// 3rd image xpath
	 private @FindBy(xpath=("(//img[@alt='User Avatar'])[3]"))
	 WebElement thirdImgPath;
	 
	// get the 2nd image xpath
	 public WebElement getThirdImgPath() {
		 return thirdImgPath;
	 }
	 
	 private @FindBy(xpath=("(//div/a[contains(text(),'View profile')])[3]"))
	 WebElement thirdImagetextlocation;
	 
	 // get the text present in first image 
	 public String getThirdImgNameText() {
		 return thirdImagetextlocation.getText();
	 }
	 
	// ****** code for MOUSE HOVER ENDS ****
	 
	// ****** code for JAVASCRIPTS ALERT START ****
	 
	
	 // JS Alert path
	 private @FindBy(css=("button[onclick='jsAlert()']"))
	 WebElement jSAlertPath;
	 
	 // click on the JS ALert Button.
	 public void  getClickOnJSAlertPath() {
		 jSAlertPath.click();
	 }
	 
	 // Accept the alert
	 public void getAcceptJavaScriptPopUp() {
		 driver.switchTo().alert().accept();
	 }
	 
	
	 // When clicked the alert then a success message comes
	 // under.
	 private @FindBy(xpath=("(//p[@id='result'])[1]"))
	 WebElement jSuccessMessagePath;
	 
	 //Success message get from the web site.
	 public String getJSSuccessMessage() {
		 return jSuccessMessagePath.getText();
	 }
	 
	 private String jsAlertString = "You successfuly clicked an alert";
	 
	 public String getJSAlertString() {
		 return jsAlertString;
	 }
	 
	 // JS confirm path
	 private @FindBy(css=("button[onclick='jsConfirm()']"))
	 WebElement jSConfirmPath;
		 
	// click on the JS ALert Button.
	 public void  getClickOnJSConfirmPath() {
			 jSConfirmPath.click();
		 }
		 
	 private String jsConfirmString = "You clicked: Ok";
	 
	 public String getJSConfirmString() {
		 return jsConfirmString;
	 }
	// JS Prompt path
		 private @FindBy(css=("button[onclick='jsPrompt()']"))
		 WebElement jSPromptPath;
		 
	// click on the JS Prompt Button.
	 public void  getClickOnJSPromptPath() {
		 	jSPromptPath.click();
	}

	 
	private String jsInputPromptString = "Nazmul Mahe Alam";
	 
	 public String getJSInputPromptString() {
		 return jsInputPromptString;
	 }
	 
	 private String jSFinalPromptMessage = "You entered: Nazmul Mahe Alam";
	 
	 public String getJSFinalPromptMessage() {
		 return jSFinalPromptMessage;
	 }
	
	// ****** code for JAVASCRIPTS ALERT ENDS ****
	 
	
	 
    // ****** code for JavaScript Errors  STARTS ****
	 
	 
	 private String jsStringError = "Cannot read properties of undefined (reading 'xyz')";

	 public String getJsStringError() {
	 return jsStringError;
	 }
	 
	// ****** code for JavaScript Errors ALERT ENDS ***
	 
	 
	// ****** code for OPEN  TAB START ****
	 
	// New tab open path
	 private @FindBy(xpath=("//a[normalize-space()='Click Here']"))
	 WebElement clickToOpenTabPath;
			 
		// click on the licnk to openn a new tab.
		 public void  getClickToOpenTab() {
			 clickToOpenTabPath.click();
		}
		
		// child window tab path
		 private @FindBy(tagName=("h3"))
		 WebElement childWindowTagPath;
				 
		// get the Text in Child window path
		 public String  getChildWindowTag() {
				return childWindowTagPath.getText();
		} 
		 
		 private String newWindowString = "New Window";

		 public String getNewWindowString() {
		 return newWindowString;
		 } 
	 
	// ****** code for OPEN  TAB ENDS ****
	
	// ****** code for Notification  Message START ***
		 
		 // click on "Click Here" css path
		 private @FindBy(css=("a[href='/notification_message']"))
		 WebElement clickToNewNotificationMessagePath;
				 
			// click on the "Click here".
			 public void  getClickToNewNotificationMessagePath() {
				 clickToNewNotificationMessagePath.click();
			}
			 
			 //
			 private @FindBy(id=("flash"))
			  WebElement alertNotificationMessagePath;
			  
			  public String getAlertNotificationMessage() {
				 return alertNotificationMessagePath.getText();
			  }
	// ****** code for Notification  Message ENDS ****
	  
} // class AllTestsPageObjectModelExceptLoginPage ends

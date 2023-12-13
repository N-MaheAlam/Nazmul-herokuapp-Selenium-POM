package take_Home_WebDriver_Test.testCasePackage;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import take_Home_WebDriver_Test.pageObjectModel.AllTestsPageObjectModelExceptLoginPage;
import take_Home_WebDriver_Test.pageObjectModel.LoginPage;
import take_Home_WebDriver_Test.reusableBaseTestComponents.ReusableBaseTest;

public class WebDriverTest_01 extends ReusableBaseTest {
	
	
	/*
	  General Requirement -01 
	  All the test has Test annotation
	 */
	
	@Test
	public void testCase_01_loginSuccessful(){
		
		// go to the URL and this "driver" object has come from the 
		// "ReusableBaseTest" parent class
		driver.get(baseURL+"/login");
		
		// pass the driver to logPage object
		LoginPage logPage = new LoginPage(driver);
		
		// use login method from LoginPage class and get the user name & password
		// from that LoginPage class
		logPage.login(logPage.getCorrectUserName(), logPage.getCorrectPassword());
		
		// pass the test if the log in message the we get from browser and stored in 
		// LoginPage class are same.
		Assert.assertEquals( 
				logPage.getCompareSuccessLoginMessage(),logPage.getSuccessLoginMessage());
	
	}//  testCase_01_loginSuccessful() ends
	
	@Test
	public void testCase_02_wrongPasswordCredential() {
		
		// go to the URL and this "driver" object has come from the 
		// "ReusableBaseTest" parent class
		driver.get(baseURL+"/login");
		
		// pass the driver to logPage object
		LoginPage logPage = new LoginPage(driver);
		
		// use login method from LoginPage class and get the user name & wrong password
		// from that LoginPage class
		logPage.login(logPage.getCorrectUserName(), logPage.getWrongPassword());
		
		// pass the test if the log failed  messages that we get from browser and stored in 
		// LoginPage class are same.
		Assert.assertEquals(logPage.getCompareWrongPasswordMessage(), 
				logPage.getLoginErrorMessage());
		
	} //testCase_02_wrongPasswordCredential() ends

	@Test
	public void testCase_03_wrongUserNameCredential() {
		
		// go to the URL and this "driver" object has come from the 
		// "ReusableBaseTest" parent class
		driver.get(baseURL+"/login");
		
		// pass the driver to logPage object
		LoginPage logPage = new LoginPage(driver);
		
		// use login method from LoginPage class and get the user name & wrong password
		// from that LoginPage class
		logPage.login(logPage.getWrongUsername(), logPage.getCorrectPassword());
		Assert.assertEquals(logPage.getCompareWrongUserNameMessage(), 
				logPage.getLoginErrorMessage());
		
	} //testCase_03_wrongUserNameCredential() ends
	

	@Test
	public void testCase_04_uncheckToCheck() {
		
		// go to the URL
		driver.get(baseURL+"/checkboxes");
	
		// create object of AllTestsPageObjectModelExceptLoginPage class
		AllTestsPageObjectModelExceptLoginPage uncheckObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		 
		// if the box  selected is false I mean not check
		 if(uncheckObject.isUncheckToCheckSelected()==false)
			 // click the check box
			 uncheckObject.getClickUncheckToCheck();
		 
		
	}//testCase_04_uncheckToCheck() ends
	
	@Test
	public void testCase_05_checkToUnCheck() {
		
		// go to the URL
		driver.get(baseURL+"/checkboxes");
		 
		// create object of AllTestsPageObjectModelExceptLoginPage class
		AllTestsPageObjectModelExceptLoginPage checkObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		 
		// if the check box is selected 
		if(checkObject.isChecheckToUnCheckSelected()== true)
			 checkObject.getClickCheckToUnCheck();
	
	}// testCase_05_checkToUnCheck() ends
	
	@Test 
	public void testCase_06_Context_menu() {
		
		
		driver.get(baseURL+"/context_menu");
		
		AllTestsPageObjectModelExceptLoginPage contextMenuObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		// create and Actions object
		Actions actions = new Actions(driver);
		
		// it will place mouse to the position & will right click the mouse.
		actions.contextClick(contextMenuObject.getContextMenuSpot()).build().perform();
		
		
		// creating a wait which will wait at least for 3 seconds
		WebDriverWait  waitForAlert = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		// Now, wait 3 seconds until the alert is present
		Alert alert = waitForAlert.until(ExpectedConditions.alertIsPresent());
		
		// grab the text message of the alert
		String textAlertMeessage = alert.getText();
		
		// compare the exact string message that has come from AllTestsPageObjectModelExceptLoginPage
		// class with the exact alert message
		Assert.assertEquals(contextMenuObject.getAlertTextMessage(), textAlertMeessage);
		
		// Now, accept the alert.
		alert.accept();
	
	} //testCase_06_Context_menu() ends 
	

	@Test
	public void testCase_07_DragAndDrop() {
		
		driver.get(baseURL+"/drag_and_drop");
		
		Actions actions = new Actions(driver);
		
		AllTestsPageObjectModelExceptLoginPage dragAndDropObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		
		// Now, putting the Drag A to Drag B.
		actions.dragAndDrop(dragAndDropObject.getSourcePath(), dragAndDropObject.getDestinationPath()).build().perform();
		 
		
		 System.out.println(dragAndDropObject.getAfterDragPathText());
		 
		// Checking the value and if true pass the test
		Assert.assertEquals("A", dragAndDropObject.getAfterDragPathText());	
		
	}// testCase_07_DragAndDrop() ends 
	
	
	
	@Test
	public void testCase_08_Dropdown() {
		
		driver.get(baseURL+"/dropdown");
		
		
		AllTestsPageObjectModelExceptLoginPage dropDownObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		Select dropDown = new Select(dropDownObject.getDropDownPath());
		
		// select the first index in Option
		dropDown.selectByIndex(1);
		
		// get the text of first option
		String optionsOneValue = dropDown.getFirstSelectedOption().getText();
		
		// Assert these two value and pass the test if it's true ("Option 1" - this is the
		// value.
		Assert.assertEquals(optionsOneValue,dropDownObject.getOptionOne() );
		
		// select the 2nd index
		dropDown.selectByIndex(2);
		
		// get the text of 2nd index
		String optionsTwoValue = dropDown.getFirstSelectedOption().getText();
		
		// Assert these two value and pass the test if it's true ("Option 2" - this is the
		// value.
		Assert.assertEquals(optionsTwoValue, dropDownObject.getOption2nd());
	
	} //testCase_08_Dropdown() ends 
	
	
	@Test
	public void testCase_09_DynamicContent() throws InterruptedException {
		
		driver.get(baseURL+"/dynamic_content");
		
		for(int i =0; i<4;i++) {
		driver.navigate().refresh();
		Thread.sleep(1000);
		}
	}// testCase_09_DynamicContent() ends 
	
	
	@Test
	public void  testCase_10_Dynamic_Controls() {
		
		driver.get("http://localhost:7080/dynamic_controls");
		
		AllTestsPageObjectModelExceptLoginPage dyanamicControlObject = new 
				AllTestsPageObjectModelExceptLoginPage(driver);
		// click on "A Check Box"
		dyanamicControlObject.getFirstCheckBoxPath();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//wait until a message shows after click
		wait.until(ExpectedConditions.visibilityOf(dyanamicControlObject.getDynamicControlRemoverButtonPath()));
		
		// after clicking and waiting a message will come then grab the value.
		String messageAfterClickingRemoveButton =
				dyanamicControlObject.getDynamicControlRemoverButtonPath().getText();
		
		Assert.assertEquals(dyanamicControlObject.getGoneMessage(), messageAfterClickingRemoveButton);
		
		// click on enable button
		dyanamicControlObject.clickOnEnableButton();
		
		// wait for visibility of "It's disabled!"
		wait.until(ExpectedConditions.visibilityOf
				(dyanamicControlObject.getAfterClickingDisabledButtonPath()));
		
		// comparing if both has "It's disabled!"
		Assert.assertEquals(dyanamicControlObject.getEnableMessage(), 
				dyanamicControlObject.getAfterClickingDisabledButtonText());
	
	} //testCase_10_Dynamic_Controls() ends
	
	
	@Test
	public void testCase_11_File_Upload(){
		
		driver.get(baseURL+"/upload");
		
		AllTestsPageObjectModelExceptLoginPage fileUploadObject = 
					new AllTestsPageObjectModelExceptLoginPage(driver);
		
		// this will click on "choose file" button and will automatically 
		// select and upload the file from computer.
		fileUploadObject.sendFileUploadDirection();
		
		// Clicking on Submit button
		fileUploadObject.clickOnFileSubmitButton();
		
		Assert.assertEquals(fileUploadObject.getFileUploadString(), 
				fileUploadObject.getFileUploadConfirmationPathText());
	} //testCase_11_File_Upload() ends 
	
	@Test
	public void testCase_12_File_DownLoad() {
		
		driver.get(baseURL+"/download");
		
		
		File file = new File(downloadPath+"/some-file.txt");
		if(file.exists()) {
			file.delete();
		}
		AllTestsPageObjectModelExceptLoginPage fileDownLoadObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		fileDownLoadObject.clickOnFileDownLoad();
	
	} //testCase_12_File_DownLoad
	
	@Test
	public void  testCase_13_Dynamic_Loading() {
		
		driver.get(baseURL+"/dynamic_loading/2");
		
		AllTestsPageObjectModelExceptLoginPage dynamicLoadingObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		
		//click on Start Button
		dynamicLoadingObject.clickOnStartButtonDyanamicLoading();
		
		//creating a wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait untill the "Hello World" text is visible
		wait.until(ExpectedConditions.visibilityOf(dynamicLoadingObject.dynamicLoadingTextLocation()));
		
		
		// compare the String ("Hello World") with the text that we have got from page
		Assert.assertEquals(dynamicLoadingObject.getDynamicHelloWorldString(),
				dynamicLoadingObject.getDynamicLoadingText());	
	
	}//testCase_13_Dynamic_Loading() ends
	
	
	@Test
	public void  testCase_14_Floating_Menu()  {
		
		driver.get(baseURL+"/floating_menu");
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		
		// scrolling down 
		js.executeScript("window.scrollBy(0,1000)");
		
		AllTestsPageObjectModelExceptLoginPage floatingMenuObject = new
				AllTestsPageObjectModelExceptLoginPage(driver);
		
		// get the "News" string , get the "News" button text from web site & compare
		// if the value is same , then the test will pass.
		 Assert.assertEquals(floatingMenuObject.getNewsButtonString(), 
				 floatingMenuObject.getNewsButtonText());
	
	} //testCase_14_Floating_Menu() ends
	
	
	@Test
	public void  testCase_15_IFrame() {
		
		driver.get(baseURL+"/iframe");
		
		AllTestsPageObjectModelExceptLoginPage iframeObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		
		// Now, go to the i frame where is the text editor
		driver.switchTo().frame(iframeObject.getToSwichiFramePathLoaction());
		
		iframeObject.getInsideIFramePathClear();
		
		// this method getClearAndPutStringInIframePath() will clear the iframe & will 
		//put the string getPutThisStringInIFrame() from this method.
		iframeObject.getAndPutStringInIframePath(iframeObject.getPutThisStringInIFrame());
		
		// Now compare String & text in I frame , if it's true pass the test
		Assert.assertEquals(iframeObject.getPutThisStringInIFrame(), iframeObject.getTheNewStringInsideIFrame());
		
		System.out.println(iframeObject.getTheNewStringInsideIFrame());
	
	} //testCase_15_IFrame() ends 
	
	
	@Test
	public void testCase_16_Mouse_Hover() {
		
		driver.get(baseURL+"/hovers");
		
		AllTestsPageObjectModelExceptLoginPage mouseHoverObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		Actions act = new Actions(driver);
		 
		
		// move to mouse in 1st image
		act.moveToElement(mouseHoverObject.getFirstImgPath()).build().perform();
		
		// when hover there will be a message "View Profile" and compare that message 
		// with actual message & pass the test if it's true 
		Assert.assertEquals(mouseHoverObject.getViewProfileString(), 
				mouseHoverObject.getFirstImgNameText());
		
		// move to mouse in 2nd image
		act.moveToElement(mouseHoverObject.getSecondImgPath()).build().perform();
		
		// when hover there will be a message "View Profile" and compare that message 
		// with actual message & pass the test if it's true 
		Assert.assertEquals(mouseHoverObject.getViewProfileString(), 
				mouseHoverObject.getSecondImgNameText());
		 
		
		
		// move te mouse in 3rd image 
		act.moveToElement(mouseHoverObject.getThirdImgPath()).build().perform();
		
		// when hover there will be a message "View Profile" and compare that message 
		// with actual message & pass the test if it's true 
		Assert.assertEquals(mouseHoverObject.getViewProfileString(),
				mouseHoverObject.getThirdImgNameText());
		
	} //testCase_16_Mouse_Hover() ends 
	
	
	
	@Test
	public void testCase_17_JavaScriptAlerts() {
		
		driver.get(baseURL+"/javascript_alerts");
		
		AllTestsPageObjectModelExceptLoginPage jSAlertObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		
		//click on JS Alert 
		jSAlertObject.getClickOnJSAlertPath();
		// Accept the Java script alert.
		jSAlertObject.getAcceptJavaScriptPopUp();
		//Checking the success string message, & get the text from 
		//website.
		Assert.assertEquals(jSAlertObject.getJSAlertString(),
				jSAlertObject.getJSSuccessMessage() );
		
		// click on Js Confirm
		jSAlertObject.getClickOnJSConfirmPath();
		
		// Accept it 
		jSAlertObject.getAcceptJavaScriptPopUp();
		
		//
		Assert.assertEquals(
				jSAlertObject.getJSConfirmString(),jSAlertObject.getJSSuccessMessage());
		
		
		jSAlertObject.getClickOnJSPromptPath();
		
		
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys(jSAlertObject.getJSInputPromptString());
		promptAlert.accept();	
		
		Assert.assertEquals(jSAlertObject.getJSFinalPromptMessage(), 
				jSAlertObject.getJSSuccessMessage());
	} //testCase_17_JavaScriptAlerts() ends 
	
	
	@Test
	public void testCase_18_JavaScriptErrors() {
		
		driver.get(baseURL+"/javascript_error");
		AllTestsPageObjectModelExceptLoginPage jSErrorObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		
		 LogEntries jsLoggers =  driver.manage().logs().get(LogType.BROWSER);
		 
		 String checkString = jsLoggers.getAll().get(0).toString();
		 boolean jsError = checkString.contains("Cannot read "
		 		+ "properties of undefined (reading 'xyz')");
		 Assert.assertTrue(jsError, jSErrorObject.getJsStringError());
		 
	}//testCase_18_JavaScriptErrors() ends 
	
	
	@Test
	public void testCase_19_OpenNewTab() {
		
		driver.get(baseURL+"/windows");
		AllTestsPageObjectModelExceptLoginPage openNewTabObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		
		// click on the "Click Here" button.
		openNewTabObject.getClickToOpenTab();
		
		// a Set to handle all the windows related to this test
		Set<String> totalTabs = driver.getWindowHandles();
		// will iterate through each window according to there name we call.
		Iterator<String> itarateEachTab = totalTabs.iterator();
		
		
		// This is the first window
		String parerntTab = itarateEachTab.next();
		
		// This is the 2nd window that will be automatically open when we will 
		// click the "click here" Link
		String childTab = itarateEachTab.next();
		
		// Transfer our driver control to the new indicated child window.
		driver.switchTo().window(childTab);
		
		//comparing the value "New Window" that is as actual message & 
		// expected message. if same then pass.
		Assert.assertEquals(openNewTabObject.getNewWindowString(), 
				openNewTabObject.getChildWindowTag());
		
		// just switch to parent windows.
		driver.switchTo().window(parerntTab);
		
		} //testCase_19_OpenNewTab() ends 
	
	
	@Test
	public void testCase_20_NotificationMessage() {
		
		driver.get(baseURL+"/notification_message_rendered");
		AllTestsPageObjectModelExceptLoginPage notificationMessageObject = 
				new AllTestsPageObjectModelExceptLoginPage(driver);
		boolean a = false;
		for(int i=0;i<13;i++) 
		{
			notificationMessageObject.getClickToNewNotificationMessagePath();
			
			String  alertMessage= driver.findElement(By.id("flash"))
									.getText();
			if(alertMessage.contains("Action successful")||
			alertMessage.contains("Action unsuccesful, please try again")||
					alertMessage.contains("Action Unsuccessful")) 
			{
				a = true;
			} //if ends 
		
		}// for ends 
			
		Assert.assertTrue(a);
		
	} //testCase_20_NotificationMessage() ends

} // class ends

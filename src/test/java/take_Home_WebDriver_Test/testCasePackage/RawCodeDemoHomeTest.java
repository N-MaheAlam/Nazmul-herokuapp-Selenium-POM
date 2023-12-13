package take_Home_WebDriver_Test.testCasePackage;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RawCodeDemoHomeTest  {

	WebDriver driver;
	
	@Test(enabled = true)
	public void demo_testCase_01_login() {
		
		// setting up the chrome driver
		WebDriverManager.chromedriver().setup();
		
		// creating driver object
		driver = new ChromeDriver();
		
		//maximising the browser
		driver.manage().window().maximize();
		
		// wait at least 5 seconds to load the browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// login to the URL
		driver.get("http://localhost:7080/login");
		
		// send the user name in use name box
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		//send the password in password box
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		//click the log in button 
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		// once the login button is clicked then , get the success message and store
		String successMessage = driver.findElement(By.cssSelector(".subheader")).getText();
		
		// Now, using assert , compare the message that you have with the success message
		// pass the test if the messages are same.
		Assert.assertEquals( 
		"Welcome to the Secure Area. When you are done click logout below.",successMessage);
	}
	
	@Test(enabled = false)
	public void demo_testCase_02_wrongPasswordCredential() {
		// this method is the same as the above "demo_testCase_01_login" method but only
		// the password is wrong.
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/login");
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		String errorMessage = driver.findElement(By.cssSelector("#flash")).getText();
		System.out.println(errorMessage);
		Assert.assertEquals("Your password is invalid!\n"
				+ "×", errorMessage);
		
	} //wrongPasswordCredential() ends
	
	@Test(enabled = false)
	public void demo_testCase_03_wrongUserNameCredential() {
		
		// this method is the same as the above "demo_testCase_01_login" method but only
		// the user name is wrong.
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/login");
		
		driver.findElement(By.id("username")).sendKeys("nazmul");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		String errorMessage = driver.findElement(By.cssSelector("#flash")).getText();
		System.out.println(errorMessage);
		Assert.assertEquals("Your username is invalid!\n"
				+ "×", errorMessage);
		
	} //wrongUserNameCredential() ends
	
	
	
	@Test(enabled = false)
	public void demo_testCase_04_uncheckToCheck() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/checkboxes");
		
		// it will store true if the check box is selected 0r false if it is not 
		// selected (it will store false as it is not selected)
		boolean uncheckedToCheck = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"))
				 		   .isSelected();
		
		// if the check box value is false I mean not checked then click the check box.
		if(uncheckedToCheck==false)
			 driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		
	}//testCase_04_uncheckToCheck() ends
	
	@Test(enabled = false)
	public void demo_testCase_05_checkToUnCheck() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/checkboxes");
		 
		// it will store false if the check box is selected 0r false if it is not 
				// selected (it will store true as it is  selected)
		boolean checkToUncheck = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"))
				 			  .isSelected();
		 
		// if the check box value is true I mean  checked then 
		//click the check box and make it not check.
		if(checkToUncheck== true)
			 driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	}// testCase_05_checkToUnCheck() ends
	
	
	@Test(enabled = false)
	public void demo_testCase_06_Context_menu() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/context_menu");
		
		
		// Action class object is to use or to manipulate mouse and keyboard.
		Actions actions = new Actions(driver);
		
		
		WebElement contextSpot = driver.findElement(By.id("hot-spot"));
		
		// right click mouse operation  into the "contextSpot" web element.
		actions.contextClick(contextSpot).build().perform();
	
		// creating a wait which will wait at least for 3 seconds
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		// Now, wait 3 seconds until the alert is present
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	
		// grab the text message of the alert
		String textAlertMeessage = alert.getText();
		
		// compare the string with the alert text.
		Assert.assertEquals("You selected a context menu", textAlertMeessage);
		
		// Now, accept the alert.
		alert.accept();
	
	} //demo_testCase_06_Context_menu() ends 
	
	/*
	 	demo_testCase_07_DragAndDrop() method its everything 
	 */
	
	@Test(enabled = false)
	public void demo_testCase_07_DragAndDrop() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/drag_and_drop");
		Actions actions = new Actions(driver);
		
		// First, Drag "A" path
		WebElement source = driver.findElement
				(By.id("column-a"));
		
		// 2nd, Drag "B" path
		WebElement destination = driver.findElement
				(By.id("column-b"));
		
		// Now draging A to postion B.
		actions.dragAndDrop(source, destination).build().perform();
		
		//After Drag & Drop the position of "A"
		String afterDragAndDropTextOfA = 
		driver.findElement(By.cssSelector("div[id='column-a'] header")).getText();
		 System.out.println(afterDragAndDropTextOfA);
		 
		 // Asserting the value of Drag & Drop of A
		Assert.assertEquals("A", afterDragAndDropTextOfA);	
		
	}// demo_testCase_07_DragAndDrop() ends 
	
	
	
	@Test(enabled = false)
	public void demo_testCase_08_Dropdown() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/dropdown");
		
		// location of drop down
		WebElement selectOptions = driver.findElement(By.id("dropdown"));
		
		// pass the web element to "Select" class object to manipulate
		Select dropDown = new Select(selectOptions);
		
		//select the first option
		dropDown.selectByIndex(1);
		String optionsOneValue = dropDown.getFirstSelectedOption().getText();
		
		// compare the value and pass if the values are correct.
		Assert.assertEquals(optionsOneValue, "Option 1");
		
		// Now, select the 2nd option
		dropDown.selectByIndex(2);
		
		// get the text and store, in a variable
		String optionsTwoValue = dropDown.getFirstSelectedOption().getText();
		
		// compare the value and pass the test if the values are correct.
		Assert.assertEquals(optionsTwoValue, "Option 2");
	}//demo_testCase_08_Dropdown() ends 
	
	
	@Test(enabled = false)
	public void demo_testCase_09_DynamicContent() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	
		driver.get("http://localhost:7080/dynamic_content");
		
		// this loop will refresh the website for 4 times according to the 
		for(int i =0; i<4;i++) {
		driver.navigate().refresh();
		Thread.sleep(1000);
		}
	}// demo_testCase_09_DynamicContent() ends 
	
	
	@Test(enabled = false)
	public void  demo_testCase_10_Dynamic_Controls() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/dynamic_controls");
		
		
		// check the first check box "A"
		driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"))
											.click();
		WebElement afterClickingRemoveButton= driver.findElement(By.id("message"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		// wait after click a message is shown
		wait.until(ExpectedConditions.visibilityOf(afterClickingRemoveButton));
		
		// get the String and store in a variable
		String messageAfterClickingRemoveButton =afterClickingRemoveButton.getText();
		
		// compare the value if it has same value "It's gone" then pass the test and 
		// go next line
		Assert.assertEquals("It's gone!", messageAfterClickingRemoveButton);
		
		// click on disable button
		driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
		WebElement afterClickingDisabledButton = driver.findElement(By.cssSelector
				("form[id='input-example'] p[id='message']"));
		
		// wait untill a message is shown after the click in disable button
		wait.until(ExpectedConditions.visibilityOf(afterClickingDisabledButton));
			String messageAfterClickingDisabledButton = 
					afterClickingDisabledButton.getText();
		// comparing the value, and pass the test if it is true.
		Assert.assertEquals("It's enabled!", messageAfterClickingDisabledButton);
	}
	//
	
	@Test(enabled = false )
	public void demo_testCase_11_File_Upload(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/upload");
		
		// this will select the "choose" button, 
		driver.findElement(By.xpath("//input[@id='file-upload']"))
		.sendKeys(System.getProperty("user.dir")
				+ "/src/main/java/take_Home_WebDriver_Test"
				+ "/dataResources/UploadFile.txt");
		
		// click on submit button, to upload the file
		driver.findElement(By.id("file-submit")).click();
		String uploadedConfirmation = driver.findElement(By.cssSelector
				("div[class='example'] h3")).getText();
		
		// there will be a message "File Uploaded" and compare the actual 
		// message & expected message if the message is same then the
		// test will pass.
		Assert.assertEquals("File Uploaded!", uploadedConfirmation);
	}
	
	@Test(enabled = false )
	public void demo_testCase_12_File_DownLoad() {
		WebDriverManager.chromedriver().setup();
		
		String downloadPath = System.getProperty("user.dir");
		
		// This HashMap send commands to the WebDriver that what ever it is
		//downloading store in the project.
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", downloadPath);
	
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/download");
		
		// if the file already present then delete it.
		File file = new File(downloadPath+"/some-file.txt");
		if(file.exists()) {
			file.delete();
		}
		
		// click on the download button
		driver.findElement(By.cssSelector
				("a[href='download/some-file.txt']")).click();
	
	} //demo_testCase_12_File_DownLoad() ends
	
	@Test(enabled = false)
	public void  demo_testCase_13_Dynamic_Loading() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/dynamic_loading/2");
		
		// click on the start button
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		WebElement helloTextLocator = driver.findElement(By.id("finish"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// wait until the hello text appears
		wait.until(ExpectedConditions.visibilityOf(helloTextLocator));
		String helloTextMessage = helloTextLocator.getText();
		
		// compare the actual and expected text and pass the test if true.
		Assert.assertEquals("Hello World!", helloTextMessage);	
	
	}//demo_testCase_13_Dynamic_Loading() ends
	
	
	@Test(enabled = false)
	public void  demo_testCase_14_Floating_Menu() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/floating_menu");
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		
		// this will scroll down 100px to the web page
		js.executeScript("window.scrollBy(0,1000)");
		
		// grap the "News" text from web page
		 String newsButton = driver.findElement(By.cssSelector
				 ("a[href='#news']")).getText();
		 
		 // compare the actual & expected "News" text. if true then pass the 
		 // test.
		 Assert.assertEquals("News", newsButton);
	
	  }//demo_testCase_14_Floating_Menu() ends
	
	
	@Test(enabled = false)
	public void  demo_testCase_15_IFrame() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/iframe");
		
		// I frame location
		WebElement iFrameSwitch = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		
		// now driver will switch to the frame
		driver.switchTo().frame(iFrameSwitch);
		
		// frame editor box locator
		WebElement insideFrame = driver.findElement(
				By.id("tinymce"));
		
		// clear insider the editor
		insideFrame.clear();
		
		// put this String in I frame editor
		insideFrame.sendKeys("This Nazmul Mahe Alam");
		
		
		// Now, get the new text in I frame that we have put
		String contextInsideFrame = driver.findElement(By.id("tinymce")).getText();
		
		// Now, compare with actual & expected String & pass the tes if the values are same
		Assert.assertEquals("This Nazmul Mahe Alam", contextInsideFrame);
	
	}//demo_testCase_15_IFrame() ends 
	
	
	@Test(enabled = true)
	public void demo_testCase_16_Mouse_Hover() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/hovers");
		
		WebElement firstImg =	driver.findElement
								(By.xpath("(//img[@alt='User Avatar'])[1]"));
		WebElement secondImg =	driver.findElement
								(By.xpath("(//img[@alt='User Avatar'])[2]"));
		WebElement thirdImg =	driver.findElement
								(By.xpath("(//img[@alt='User Avatar'])[3]"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(firstImg).build().perform();
		String firstTextAfterHover = driver.findElement(By.xpath
				("(//div/a[contains(text(),'View profile')])[1]")).getText();
		Assert.assertEquals("View profile", firstTextAfterHover);
		
		act.moveToElement(secondImg).build().perform();
		String secondTextAfterHovber = driver.findElement(By.xpath
				("(//div/a[contains(text(),'View profile')])[2]")).getText();
		Assert.assertEquals("View profile", secondTextAfterHovber);
		
		act.moveToElement(thirdImg).build().perform();
		String thirdTextAfterHovber = driver.findElement(By.xpath
				("(//div/a[contains(text(),'View profile')])[3]")).getText();
		Assert.assertEquals("View profile", thirdTextAfterHovber);
	
	} // demo_testCase_16_Mouse_Hover() ends 
	
	
	
	@Test(enabled = false)
	public void demo_testCase_17_JavaScriptAlerts() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/javascript_alerts");
		
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']"))
		.click();
		driver.switchTo().alert().accept();
		WebElement resultsJSAlert = driver.findElement
				(By.xpath("(//p[@id='result'])[1]"));
		Assert.assertEquals(resultsJSAlert.getText(),
				"You successfuly clicked an alert" );
		
		
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"))
		.click();
		driver.switchTo().alert().accept();
		WebElement resultJSConfirm = driver.findElement
				(By.xpath("(//p[@id='result'])[1]"));
		Assert.assertEquals(
				resultJSConfirm.getText(),"You clicked: Ok");
		
		
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"))
		.click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Nazmul Mahe Alam");
		promptAlert.accept();
		WebElement resultsPrompt = driver.findElement
				(By.xpath("(//p[@id='result'])[1]"));
		Assert.assertEquals(resultsPrompt.getText(), 
				"You entered: Nazmul Mahe Alam");
	} //demo_testCase_17_JavaScriptAlerts() ends 
	
	
	@Test(enabled = false)
	public void demo_testCase_18_JavaScriptErrors() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/javascript_error");
		
		 LogEntries jsLoggers =  driver.manage().logs().get(LogType.BROWSER);
		 
		 String checkString = jsLoggers.getAll().get(0).toString();
		 boolean jsError = checkString.contains("Cannot read "
		 		+ "properties of undefined (reading 'xyz')");
		 Assert.assertTrue(jsError,
				 "Cannot read properties of undefined (reading 'xyz')");
		 
	} //demo_testCase_18_JavaScriptErrors() ends 
	
	
	@Test(enabled = false)
	public void demo_testCase_19_OpenNewTab() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/windows");
		driver.findElement(By.xpath
				("//a[normalize-space()='Click Here']")).click();
		Set<String> totalTabs = driver.getWindowHandles();
		Iterator<String> itarateEachTab = totalTabs.iterator();
		
			
		String parerntTab = itarateEachTab.next();
		String childTab = itarateEachTab.next();
		driver.switchTo().window(childTab);
		String childTabMessage = driver.findElement(By.tagName("h3"))
									.getText();
		Assert.assertEquals("New Window", childTabMessage);
		driver.switchTo().window(parerntTab);
		
		}// demo_testCase_19_OpenNewTab() ends 
	
	
	@Test(enabled = false)
	public void demo_testCase_20_NotificationMessage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:7080/notification_message_rendered");
		
		
		
		boolean a = false;
		for(int i=0;i<13;i++) 
		{
			driver.findElement(By.cssSelector
					("a[href='/notification_message']")).click();
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
			
	}// Method - demo_testCase_20_NotificationMessage() ends
	
	
}// class ends 

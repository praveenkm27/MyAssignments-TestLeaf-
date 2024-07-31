package homeassignments.week5;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {

	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public Actions action;

	@Parameters({ "username", "password", "url" }) // key is case sensitive , but order is not prefered
	@BeforeMethod
	public void preCondition(String uname, String pwd, String url) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		// Disable chrome menu side panel notification -> "You can open bookmarks,
		// reading mode, and more from the Chrome menu"
		options.addArguments("--disable-features=SidePanelPinning");
		// Disable other notifications from the site
		options.addArguments("--disable-notifications");

		// Initialize Chrome driver
		driver = new ChromeDriver(options);

		// Set Explicit wait and create an instance of Actions class
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		action = new Actions(driver);

		// Launch URL, maximize window and set implicit wait
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Enter username and password
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd + Keys.ENTER);

		// Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement legalEntitiesLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Legal Entities']")));
		Thread.sleep(1000);
		action.moveToElement(legalEntitiesLink).click().perform();
		
		// Got to the Legal Entities tab
		action.moveToElement(driver
				.findElement(By.xpath("//div/*[contains(@class, 'slds-is-active')]//span[text()='Legal Entities']"))).click().perform();
		
		// Click on the Dropdown icon in the legal Entities tab
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Legal Entities']/following-sibling::*//a[@role='button']"))).click().perform();
				
		// Click on New Legal Entity
		action.moveToElement(driver.findElement(By.xpath("//span[text()='New Legal Entity']"))).click().perform();
	}
	
	public void verifyAlertMessage(String expectedAlertMsg) throws InterruptedException {
	    
		// Click Save
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    
	    Thread.sleep(500);

	    // Wait for the alert msg to be displayed
	    WebElement alertMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By
	            .xpath("//div[@class='forceVisualMessageQueue']//span[contains(@class, 'slds-text-heading--small')]")));

	    // Print and verify the alert msg displayed
	    String actualAlertMsg = alertMsg.getText();
	    Assert.assertEquals(actualAlertMsg, expectedAlertMsg, "The Alert message displayed is not correct");
	    System.out.println("The Alert message displayed is correct: " + actualAlertMsg);
	}


	@AfterMethod
	public void postCondition() {
		// Close the browser
		driver.close();
	}
}

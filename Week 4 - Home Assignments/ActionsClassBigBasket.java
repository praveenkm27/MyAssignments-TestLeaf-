package week4.homeassignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassBigBasket {
	public static void main(String[] args) throws InterruptedException, IOException {
		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Navigate to the BigBasket website
		driver.get("https://www.bigbasket.com/");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the implicit wait to 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Create a new instance of the WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Create a new instance of the Actions class
		Actions action = new Actions(driver);

		// Move to the menu button and click on it
		action.moveToElement(driver.findElement(By.xpath("//*[@id='headlessui-menu-button-:R5bab6:']"))).click()
				.perform();

		// Wait for 2 seconds
		Thread.sleep(2000);

		// Find the "Foodgrains" link and move to it
		WebElement foodGrainsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@id, 'R9bab6')]//li/a[contains(., 'Foodgrains')]")));
		action.moveToElement(foodGrainsLink).perform();

		// Find the "Rice Products" link and move to it
		WebElement riceProductsLink = driver.findElement(By.xpath("//a[contains(., 'Rice Products')]"));
		action.moveToElement(riceProductsLink).perform();

		// Find the "Boiled" link and move to it and click on it
		WebElement boiledRiceLink = driver.findElement(By.xpath("//a[contains(., 'Boiled')]"));
		action.moveToElement(boiledRiceLink).click().perform();

		// Move to the "BB Royal" checkbox and click on it
		action.moveToElement(driver.findElement(By.xpath("//section//input[@id='i-BBRoyal']"))).click().perform();

		// Find the "Tamil Ponni Boiled Rice" link and click on it
		WebElement tamilPonniBoiledRiceLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//section//h3[.='Tamil Ponni Boiled Rice']")));
		tamilPonniBoiledRiceLink.click();
//      action.moveToElement(tamilPonniBoiledRiceLink).pause(Duration.ofSeconds(3)).click().perform(); // can use this as well

		// Get all the window handles
		Set<String> allwindows = driver.getWindowHandles();

		// Convert the set of window handles to a list
		List<String> window = new ArrayList<>(allwindows);

		// Switch to the second window
		driver.switchTo().window(window.get(1));

		// Wait for 1 second
		Thread.sleep(1000);

		// Find the "5 kg" link and click on it
		WebElement select5kgLink = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class, 'mb-2.5') and .//span[.='5 kg']]")));
//      select5kgLink.click();
		action.moveToElement(select5kgLink).pause(Duration.ofSeconds(3)).click().perform();

		// Get the price of the item
		String price = driver
				.findElement(By
						.xpath("//div[contains(@class, 'border-appleGreen')]//span[contains(@class, 'StyledLabel5')]"))
				.getText();
		System.out.println("The price of the item is: " + price);

		// Wait for 2 seconds
		Thread.sleep(2000);

		// Click on the "Add to basket" button
		driver.findElement(By.xpath("(//button[.='Add to basket'])[1]")).click();

		// Get the expected success message
		String expectedMsg = "An item has been added to your basket successfully";

		// Wait for 1 second
		Thread.sleep(1000);

		// Get the actual success message
		String successMsg = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toast___StyledDiv-sc-1uergwq-0')]")))
				.getText();
		System.out.println("The success message displayed is: " + successMsg);

		// Check if the success message is correct
		if (successMsg.equals(expectedMsg)) {
			System.out.println("The success message displayed is correct. test passed");
		} else {
			System.out.println("The success message displayed is incorrect. test failed");
		}

		// Take a screenshot and store it at the specified location
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("./screenshot/BigBasket.png"));
		System.out.println("Screenshot taken and stored at location ./screenshot/BigBasket.png");

		// Close the current window
		driver.close();

		// Switch to the first window
		driver.switchTo().window(window.get(0));

		// Close the first window
		driver.close();
	}
}

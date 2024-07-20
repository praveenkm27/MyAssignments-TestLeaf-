package week4.homeassignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassSnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Create a new instance of the ChromeOptions
		ChromeOptions option = new ChromeOptions();

		// Disable notifications
		option.addArguments("--disable-notifications");

		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver(option);

		// Navigate to the Snapdeal website
		driver.get("https://www.snapdeal.com/");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the implicit wait to 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Create a new instance of the WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Create a new instance of the Actions class
		Actions action = new Actions(driver);

		// Move to the "Men's Fashion" link and perform the action
		action.moveToElement(driver.findElement(By.xpath("//span[normalize-space()=\"Men's Fashion\"]"))).perform();

		// Move to the "Sports Shoes" link and click on it
		action.moveToElement(driver.findElement(By.xpath("//div[@id='category1Data']//span[.='Sports Shoes']"))).click()
				.perform();

		// Get the count of "Sports Shoes" available on the site
		String countOfSportsShoes = driver.findElement(By.xpath("//span[contains(@class, 'category-count')]"))
				.getText();

		// Remove the brackets and extra spaces from the count
		countOfSportsShoes = countOfSportsShoes.substring(1, countOfSportsShoes.length() - 1).trim();
		System.out.println("The count of 'sports shoes' available on the site is: " + countOfSportsShoes);

		// Click on the "Training Shoes" link
		driver.findElement(By.xpath("//div[.='Training Shoes']")).click();

		// Click on the "Sort by" dropdown and select "Price Low To High"
		driver.findElement(By.xpath("//span[.='Sort by:']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Price Low To High']")).click();

		// Select the price range from 500 to 700 and click "GO"
		WebElement priceFrom = driver.findElement(By.xpath("//input[@name='fromVal']"));
		priceFrom.clear();
		priceFrom.sendKeys("500"); // starting price

		WebElement priceTo = driver.findElement(By.xpath("//input[@name='toVal']"));
		priceTo.clear();
		priceTo.sendKeys("700"); // max price

		driver.findElement(By.xpath("//div[normalize-space()='GO']")).click(); // click GO

		// Filter color by choosing black
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//label[@for='Color_s-Black']"))).click().perform();

		// Verify all the applied filters
		List<WebElement> numOfFilters = driver.findElements(By.xpath("//div[@class='filters']"));
		System.out.println("\nFilters selected are: ");

		for (int i = 1; i <= numOfFilters.size(); i++) {
			System.out.println(
					driver.findElement(By.xpath("//div[contains(@class,'filters-top-selected')]//div[" + i + "]/a"))
							.getText());
		}

		// Move to the product image and perform the action
		action.moveToElement(driver.findElement(By.xpath("//div[@class='product-tuple-image ']"))).perform();

		// Click on the "Quick View" button
		WebElement quickView = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space()='Quick View' and @class[contains(., 'quick-view-bar')]]")));
		quickView.click();

		// Wait for 1 second
		Thread.sleep(1000);

		// Get the cost of the product and the discount
		System.out.println("\nThe cost of the product is: "
				+ driver.findElement(By.xpath("//span[contains(@class,'payBlkBig')]")).getText());
		System.out.println(
				"The discount is: " + driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());
		System.out.println();

		// Take a screenshot and save it at the specified location
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("./screenshot/Snapdeal.png"));
		System.out.println("Screenshot taken and saved at location: ./screenshot/Snapdeal.png");

		// Close the browser
		driver.close();
	}
}

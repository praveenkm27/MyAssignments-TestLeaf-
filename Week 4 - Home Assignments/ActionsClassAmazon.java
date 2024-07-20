package week4.homeassignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassAmazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Navigate to the Amazon website
		driver.get("https://www.amazon.in/");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the implicit wait to 20 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Find the search input field and enter the search query "oneplus 9 pro" and
		// press Enter
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro" + Keys.ENTER);

		// Find the price of the first product and print it
		String priceOfProduct = driver
				.findElement(By.xpath("(//div[@data-cy='price-recipe']//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of the first product is: ₹" + priceOfProduct);

		// Find the number of ratings of the first product and print it
		String ratingsOfProduct = driver.findElement(By.xpath("(//div[@data-cy='reviews-block']//a/span)[1]"))
				.getText();
		System.out.println("The no. of ratings of the first product is: " + ratingsOfProduct);

		// Find the link of the first product
		WebElement firstProductTextLink = driver.findElement(By.xpath("(//div[@class='sg-col-inner']//h2/a)[1]"));

		// Create a new instance of the Actions class
		Actions action = new Actions(driver);

		// Move to the first product link and click on it
		action.moveToElement(firstProductTextLink).click().perform();

		// Get all the window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Convert the set of window handles to a list
		List<String> windowList = new ArrayList<>(allWindows);

		// Switch to the second window
		driver.switchTo().window(windowList.get(1));

		// Take a screenshot of the current window
		TakesScreenshot ss = (TakesScreenshot) driver;
		File screenshot = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/product.png");
		FileUtils.copyFile(screenshot, dest);
		System.out.println("Screenshot taken");

		// Click on the "Add to cart" button
		driver.findElement(By.id("add-to-cart-button")).click();

		// Wait for 2 seconds
		Thread.sleep(2000);

		// Find the cart subtotal and print it
		String subTotal = driver.findElement(By.xpath("//b[.='Cart subtotal']/ancestor::span/following::span[1]/span"))
				.getText();

		// Remove the currency symbol and the decimal points from the subtotal
		subTotal = subTotal.substring(1, subTotal.length() - 3);
		System.out.println("The cart subtotal is: ₹" + subTotal);

		// Check if the price of the selected product is correctly displayed in the cart
		if (priceOfProduct.equals(subTotal)) {
			System.out.println("Price of the selected product is correctly displayed in the cart");
		} else {
			System.out.println("Price of the selected product is not correctly displayed in the cart");
		}

		// Quit the browser
		driver.quit();
	}
}

package week3.homeassignments.list;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajio {
	public static void main(String[] args) throws InterruptedException {
		// Creating a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		// Navigating to the Ajio website
		driver.get("https://www.ajio.com/");
		
		// Maximizing the browser window
		driver.manage().window().maximize();
		
		// Setting an implicit wait of 20 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Entering the search query "bags" in the search box
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags" + Keys.ENTER);
		
		// Clicking on the "Men" filter
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		
		// Waiting for 2 seconds
		Thread.sleep(2000);
		
		// Clicking on the "Fashion Bags" filter
		driver.findElement(By.xpath("//label[contains(text(), 'Fashion Bags')]")).click();
		
		// Waiting for 2 seconds
		Thread.sleep(2000);
		
		// Getting the total number of items found
		String itemsFound = driver.findElement(By.xpath("//div[@class='filter']/div")).getAttribute("aria-label");
		
		// Printing the total number of items found
		System.out.println("The total number of items found are: " + itemsFound);
		
		// Getting the list of brands displayed on the page
		List<WebElement> brandsDisplayed = driver.findElements(By.xpath("//div[@class='brand']"));
		
		// Printing the brands displayed on the page
		System.out.println("\nThe List of brands (Marked by '>') and bag names (Marked by '--' under brand) displayed in the page are: ");
		
		for (WebElement brand : brandsDisplayed) {
			System.out.println("> " + brand.getText()); // Print the brand name
			String bagName = brand.findElement(By.xpath("./following::div[@class='nameCls']")).getText(); // Get the bag name
			System.out.println("  -- " + bagName); // Print the bag name
		}
		
		System.out.println();
		
		// Closing the browser
		driver.close();
	}

}

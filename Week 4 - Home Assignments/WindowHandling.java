package week4.homeassignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Navigate to the specified URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the implicit wait to 20 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Enter the username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click the login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click the CRM/SFA link
		driver.findElement(By.xpath("//div[@id='button']/a/img")).click();

		// Click the Contacts link
		driver.findElement(By.xpath("//*[text()='Contacts']")).click();

		// Click the Merge Contacts link
		driver.findElement(By.xpath("//*[text()='Merge Contacts']")).click();

		// Click the From Contact lookup button
		driver.findElement(By.xpath("//td/input[@id='partyIdFrom']/following-sibling::a")).click();

		// Get the window handles
		Set<String> windowHandles = driver.getWindowHandles();

		// Convert the set to a list
		List<String> window = new ArrayList<String>(windowHandles);

		// Switch to the second window
		driver.switchTo().window(window.get(1));

		// Wait for 1 second
		Thread.sleep(1000);

		// Click the first contact link
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();

		// Switch back to the first window
		driver.switchTo().window(window.get(0));

		// Wait for 1 second
		Thread.sleep(1000);

		// Click the To Contact lookup button
		driver.findElement(By.xpath("//td/input[@id='partyIdTo']/following-sibling::a")).click();

		// Get the window handles again
		windowHandles = driver.getWindowHandles();

		// Convert the set to a list again
		window = new ArrayList<String>(windowHandles);

		// Switch to the second window again
		driver.switchTo().window(window.get(1));

		// Click the first contact link again
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();

		// Switch back to the first window again
		driver.switchTo().window(window.get(0));

		// Click the Merge button
		driver.findElement(By.xpath("//*[text()='Merge']")).click();

		// Accept the alert box
		driver.switchTo().alert().accept();

		// Print the title of the page
		System.out.println("The title of the page is: " + driver.getTitle());

		// Close the browser
		driver.close();
	}
}

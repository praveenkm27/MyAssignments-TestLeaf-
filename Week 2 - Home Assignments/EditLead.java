package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		// Open the specified URL
		driver.get("http://leaftaps.com/opentaps/");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Set the implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Login steps
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a/img")).click();
		
		// Click the Leads tab & click the Create Lead button
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text() = 'Create Lead']")).click();

		// Fill in lead information
		driver.findElement(By.xpath("//td/input[@name = 'companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//td/input[@name = 'firstName']")).sendKeys("Praveen");
		driver.findElement(By.xpath("//td/input[@name = 'lastName']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//td/input[@name = 'firstNameLocal']")).sendKeys("Praveen");
		driver.findElement(By.xpath("//td/input[@name = 'lastNameLocal']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//td/input[@name = 'departmentName']")).sendKeys("IT");
		driver.findElement(By.xpath("//td/textarea[@name = 'description']")).sendKeys("Creating a lead");
		driver.findElement(By.xpath("//td/input[@name = 'primaryEmail']")).sendKeys("anonyveen@gmail.com");
		Select states = new Select(driver.findElement(By.xpath("//select[@name = 'generalStateProvinceGeoId']")));

		// Select state from drop down
		states.selectByVisibleText("New York");

		// Create lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		// Edit lead
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		// Clear and update lead description
		driver.findElement(By.xpath("//td/textarea[@name = 'description']")).clear();
		
		// Update important notes
		driver.findElement(By.xpath("//td/textarea[@name='importantNote']")).sendKeys("This is important");
		driver.findElement(By.xpath("//td/input[@value='Update']")).click();

		// Print title of resulting page
		System.out.println("The title of the resulting page is: " + driver.getTitle());

		// Quit WebDriver
		driver.quit();
	}
}

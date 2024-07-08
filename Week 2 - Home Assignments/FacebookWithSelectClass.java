package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookWithSelectClass {

	public static void main(String[] args) throws InterruptedException {
		
		// Create a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		// Navigate to the Facebook registration page
		driver.get("https://en-gb.facebook.com/");
		
		// Maximize the browser window
		driver.manage().window().maximize();

		// Set an implicit wait for the page to load 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Click to open the registration form
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		// Enter the first name in the input field
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Praveen");

		// Enter the last name in the input field
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kumar");

		// Enter the email in the email input field
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("dummyfbaccount@sharklasers.com");

		// Confirm the email by entering it again in the confirmation input field
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("dummyfbaccount@sharklasers.com");

		// Set the password in the password input field
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("test@123");

		// Select the day from the dropdown for birthday
		Select day = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		day.selectByValue("1");

		// Select the month from the dropdown for birthday
		Select month = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		month.selectByVisibleText("May");

		// Select the year from the dropdown for birthday
		Select year = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		year.selectByValue("1990");

		// Click on the gender label
		driver.findElement(By.xpath("//label[text()='Male']")).click();

		// Click on the submit button
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();

		// Close the driver
		driver.close();
	}
}

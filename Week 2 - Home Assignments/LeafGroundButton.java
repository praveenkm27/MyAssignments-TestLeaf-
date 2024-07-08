package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LeafGroundButton {

	public static void main(String[] args) {

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();

		// Open the specified URL
		driver.get("https://leafground.com/button.xhtml");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Click the 'Click' button
		driver.findElement(By.xpath("//span[text()='Click']")).click();

		// Verify that the page title is 'Dashboard'
		String expectedTitle = "Dashboard";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "The Title of the page differs from the expected");
		System.out.println("The Title of the page matches the expected Title: " + expectedTitle);

		// Go back to the previous page
		driver.navigate().back();

		// Check if the button under the message 'Confirm if the button is disabled' is
		// disabled
		boolean disabledButtonState = driver.findElement(By.xpath("//button[contains(@id, 'j_idt92')]/span"))
				.isEnabled();

		if (disabledButtonState == true) {
			System.out.println("The button under the message ‘Confirm if the button is disabled’ is disabled");
		} else {
			System.out.println("The button under the message ‘Confirm if the button is disabled’ is enabled");
		}

		// Print the location of the submit button under the message 'Find the position
		// of the Submit button'
		System.out.println(
				"The location of the submit button under the message 'Find the position of the Submit button' is: "
						+ driver.findElement(By.xpath("//button[contains(@id, 'j_idt94')]/span[text()='Submit']"))
								.getLocation());

		// Print the background color of the button under the message 'Find the Save
		// button color'
		System.out.println("The b/g color of the button under the message 'Find the Save button color' is: "
				+ driver.findElement(By.xpath("//button[contains(@id, 'j_idt96')]/span[text()='Save']"))
						.getCssValue("background-color"));

		// Print the height and width of the button with the text 'Find the height and
		// width of this button'
		System.out.println(
				"The height and width of the button with the text ‘Find the height and width of this button’ is: "
						+ driver.findElement(By.xpath("//button[contains(@id, 'j_idt98')]/span[text()='Submit']"))
								.getSize());

		// Close the browser
		driver.close();

	}
}

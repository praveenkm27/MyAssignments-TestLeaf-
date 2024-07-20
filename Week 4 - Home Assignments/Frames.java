package week4.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	public static void main(String[] args) {
		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Navigate to the specified URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the implicit wait to 20 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Switch to the iframe with the name "iframeResult"
		driver.switchTo().frame("iframeResult");

		// Click the button with the onclick attribute "myFunction()"
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

		// Switch to the alert box and enter the text "Praveen"
		driver.switchTo().alert().sendKeys("Praveen");

		// Accept the alert box
		driver.switchTo().alert().accept();

		// Define the expected text
		String expectedText = "Hello Praveen! How are you today?";

		// Get the actual text from the paragraph with the id "demo"
		String actualText = driver.findElement(By.xpath("//p[@id='demo']")).getText();

		// Compare the expected and actual text
		if (expectedText.equals(actualText)) {
			System.out.println("Text displayed is correct");
		} else {
			System.out.println("Text displayed is incorrect");
		}

		// Switch back to the default content
		driver.switchTo().defaultContent();

		// Close the browser
		driver.close();
	}
}

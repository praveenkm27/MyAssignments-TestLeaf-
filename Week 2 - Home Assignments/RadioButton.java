package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Click the 'Firefox' radio button
		driver.findElement(By.xpath("//table[contains(@id, 'console1')]//label[text()='Firefox']")).click();

		// Click the 'Bengaluru' radio button
		driver.findElement(By.xpath(
				"//label[text()='Bengaluru']/preceding-sibling::div/div[contains(@class, 'ui-radiobutton-box')]"))
				.click();
		boolean isSelected = driver
				.findElement(By.xpath(
						"//label[text()='Bengaluru']/preceding-sibling::div/div[contains(@class, 'ui-state-active')]"))
				.isDisplayed();
		System.out.println("After clicking the button, is it selected? " + isSelected);

		// Pause the execution for 2 seconds
		Thread.sleep(2000);

		// Click the 'Bengaluru' radio button again to try and unselect it
		driver.findElement(
				By.xpath("//label[text()='Bengaluru']/preceding-sibling::div/div[contains(@class, 'ui-state-active')]"))
				.click();
		isSelected = driver.findElement(By.xpath(
				"//label[text()='Bengaluru']/preceding-sibling::div/div[contains(@class, 'ui-radiobutton-box')]"))
				.isDisplayed();
		System.out.println("After clicking the button again, is it deselected? " + isSelected);

		// Get the default selected radio button
		WebElement defaultSelectedRadio = driver
				.findElement(By.xpath("//table[contains(@id, 'console2')]//input[@checked]"));
		WebElement defaultSelectedLabel = defaultSelectedRadio
				.findElement(By.xpath("./ancestor::div/following-sibling::label"));
		System.out.println("Initially selected radio button: " + defaultSelectedLabel.getText());

		// Click the '21-40 Years' radio button if it is not already selected
		WebElement ageGroupRadio = driver
				.findElement(By.xpath("//label[text()='21-40 Years']/preceding-sibling::div//input"));
		if (!ageGroupRadio.isSelected()) {
			ageGroupRadio.click();
		}
		
		// Close the WebDriver instance
		driver.close();
	}
}

package homeassignments.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class StaticParameterization extends ProjectSpecificMethod {

	@Test(invocationCount = 5)
	public void runStaticParameterization() throws InterruptedException {

		// Enter the Company name as 'TestLeaf'
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("TestLeaf");

		// Enter Description as 'Salesforces'
		driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div//textarea"))
				.sendKeys("Salesforces" + Keys.PAGE_DOWN);

		// Select Status as 'Active'
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//div[@part='combobox']//button[@data-value='--None--']")))
				.click().perform();
		driver.findElement(By.xpath("//span[@title='Active']")).click();

		// Call "verifyAlertMessage" method from ProjectSpecificMethod class and pass the expected alert message
		verifyAlertMessage("Legal Entity \"TestLeaf\" was created.");
	}
}

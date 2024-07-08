package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DeleteLead {

    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Opentaps login page
        driver.get("http://leaftaps.com/opentaps/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Enter the username and password
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");

        // Click the login button
        driver.findElement(By.className("decorativeSubmit")).click();

        // Click on the CRM/SFA link
        driver.findElement(By.xpath("//a/img")).click();

        // Click on the Leads link
        driver.findElement(By.xpath("//a[text()='Leads']")).click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Click on the Find Leads link
        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

        // Click on the Phone radio button
        driver.findElement(By.xpath("//span[text()='Phone']")).click();

        // Enter the phone number
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");

        // Click the Find Leads button
        driver.findElement(By.cssSelector("button[type='button']")).click();

        // Get the lead ID of the first resulting lead
        String leadID = driver.findElement(By.xpath("(//div[contains(@class, 'partyId')]/a[@class='linktext'])[1]")).getText();
        System.out.println("Lead ID of the first resulting lead is " + leadID);

        // Click on the first resulting lead
        driver.findElement(By.xpath("(//div[contains(@class, 'partyId')]/a[@class='linktext'])[1]")).click();

        // Click on the Delete button
        driver.findElement(By.xpath("//a[text()='Delete']")).click();

        // Click on the Find Leads link again
        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

        // Enter the lead ID in the search field
        driver.findElement(By.xpath("//input[@name ='id']")).sendKeys(leadID);

        // Wait for 1 second
        Thread.sleep(1000);

        // Click the Find Leads button again
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Get the message displayed after searching for the deleted lead
        String message = driver.findElement(By.xpath("//div[contains(@class, 'x-toolbar')]/div")).getText();

        // Assert that the message is "No records to display"
        String expectedMessage = "No records to display";
        Assert.assertEquals(message, expectedMessage, "Expected Message does not match the actual message");

        // Print a success message if the assertion passes
        System.out.println("Expected message matches the actual message:'No records to display'. The deletion is successful");

        // Close the browser
        driver.quit();
    }
}

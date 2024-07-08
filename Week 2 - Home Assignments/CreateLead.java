package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {
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

        // Wait for 1 second
        Thread.sleep(1000);

        // Click on the Leads link
        driver.findElement(By.xpath("//a[text()='Leads']")).click();

        // Click on the Create Lead link
        driver.findElement(By.xpath("//a[text()='Create Lead']")).click();

        // Enter the company name
        driver.findElement(By.cssSelector("input#createLeadForm_companyName")).sendKeys("TestLeaf");

        // Enter the first name
        driver.findElement(By.cssSelector("input#createLeadForm_firstName")).sendKeys("Praveen");

        // Enter the last name
        driver.findElement(By.cssSelector("input#createLeadForm_lastName")).sendKeys("Kumar");

        // Enter the general profession title
        driver.findElement(By.cssSelector("input#createLeadForm_generalProfTitle")).sendKeys("PracticeAssignment");

        // Click the Create Lead button
        driver.findElement(By.cssSelector("input.smallSubmit")).click();

        // Verify that the title "View Lead" is displayed correctly
        if (driver.findElement(By.cssSelector("div#sectionHeaderTitle_accounts")).getText().equals("View Lead")) {
            System.out.println("Title is displayed correctly!");
        }

        // Close the browser
        driver.close();
    }
}

package week2.homeassignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

    public static void main(String[] args) throws InterruptedException {
        
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the LeafTaps website
        driver.get("http://leaftaps.com/opentaps/");
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Set the implicit wait to 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Enter the username and password, and click the login button
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        
        // Click on the CRM/SFA link
        driver.findElement(By.xpath("//a/img")).click();
        Thread.sleep(1000);
        
        // Click on the Accounts link
        driver.findElement(By.xpath("//a[text()='Accounts']")).click();
        
        // Click on the Create Account link
        driver.findElement(By.xpath("//a[text()='Create Account']")).click();
        
        // Enter the account details
        driver.findElement(By.cssSelector("input#accountName")).sendKeys("Praveen_KM");
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
        
        // Enter the number of employees and office site name
        driver.findElement(By.cssSelector("input#numberEmployees")).sendKeys("8");
        driver.findElement(By.cssSelector("input#officeSiteName")).sendKeys("LeafTaps"); 
        
        // Click the Create Account button
        driver.findElement(By.cssSelector("input.smallSubmit")).click();

        // Verify that the account details page is displayed correctly
        String actualTitle = driver.getTitle();
        String expectedTitle = "Create Account | opentaps CRM";
        
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("Title is displayed correctly!");
        }
        
        // Close the browser
        driver.close();
    }

}

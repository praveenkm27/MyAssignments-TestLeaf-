package week2.homeassignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Checkboxes {

    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the LeafGround website
        driver.get("https://leafground.com/checkbox.xhtml");
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Set the implicit wait to 15 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Click on the Basic and Ajax checkboxes
        driver.findElement(By.xpath("//span[text()='Basic']")).click();
        driver.findElement(By.xpath("//span[text()='Ajax']")).click();

        // Create a WebDriverWait with a 10 seconds timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for the popup to be visible and get the notification text
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[./span[text()='Checked']]")));
        String actualNotificationText = popup.getText();
        String expectedNotificationText = "Checked";

        // Assert that the actual notification text matches the expected text
        Assert.assertEquals(actualNotificationText, expectedNotificationText, "Expected Notification message is not displayed");
        System.out.println("Expected Notification message is displayed: " + actualNotificationText);

        // Click on the Java, Python, and Javascript checkboxes
        driver.findElement(By.xpath("//label[text()='Java']")).click();
        driver.findElement(By.xpath("//label[text()='Python']")).click();
        driver.findElement(By.xpath("//label[text()='Javascript']")).click();

        // Click on the tri-state checkbox
        driver.findElement(By.xpath("//div[contains(@id, 'ajaxTriState')]//div[contains(@class, 'ui-chkbox-box')]")).click();
        
        // Wait for the tri-state popup to be visible and get the state
        WebElement triStatePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[./span[text()='State has been changed.']]/p")));
        String actualState = triStatePopup.getText();

        // Define the tri-state options
        String[] triStateOptions = { "Default/Empty []", "Checked [✓]", "Crossed [x]" };

        // Print the currently chosen tri-state option
        if (actualState.equals("State = 0")) {
            System.out.println("Currently chosen tri-state option is: " + triStateOptions[0]);
        } else if (actualState.equals("State = 1")) {
            System.out.println("Currently chosen tri-state option is: " + triStateOptions[1]);
        } else if (actualState.equals("State = 2")) {
            System.out.println("Currently chosen tri-state option is: " + triStateOptions[2]);
        }

        // Click on the toggle switch
        driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
        Thread.sleep(1000);
        
        // Wait for the toggle switch popup to be visible and get the state
        WebElement toggleSwitchPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[./span[text()='Checked']]")));
        String actualToggleState = toggleSwitchPopup.getText();
        String expectedToggleText = "Checked";

        // Assert that the actual toggle switch state matches the expected text
        Assert.assertEquals(actualToggleState, expectedToggleText, "Expected Toggle Switch message is not displayed");
        System.out.println("Expected Toggle Switch message is displayed: " + actualToggleState);

        // Get the status of the checkbox
        String checkBoxStatus = driver.findElement(By.xpath("//div[contains(@id, 'j_idt102')]/span")).isSelected() ? "Enabled" : "Disabled";

        System.out.println("Check box status is: " + checkBoxStatus);

        // Click on the Select Multiple checkbox
        driver.findElement(By.xpath("//div[./*[text() = 'Select Multiple']]/div")).click();

        // Get the list of cities
        List<WebElement> cities = driver.findElements(By.xpath("//ul[@role='group']//label"));

        System.out.print("Selected cities are: ");
        for (WebElement city : cities) {
            if (city.getText().equals("London") || city.getText().equals("Paris") || city.getText().equals("Berlin")
                    || city.getText().equals("Amsterdam")) {
                System.out.print(city.getText() + " ");
                city.click();
            }
        }

        // Click on the Close button
        driver.findElement(By.xpath("//a[@aria-label='Close']")).click();

        // Quit the browser
        driver.quit();
    }
}

package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountWithSelectClass {

    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Opentaps login page
        driver.get("http://leaftaps.com/opentaps/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait of 20 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Enter the username and password
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");

        // Click the login button
        driver.findElement(By.className("decorativeSubmit")).click();

        // Click on the CRM/SFA link
        driver.findElement(By.xpath("//a/img")).click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Click on the Accounts link
        driver.findElement(By.xpath("//a[text()='Accounts']")).click();

        // Click on the Create Account link
        driver.findElement(By.xpath("//a[text()='Create Account']")).click();

        // Enter the account name
        driver.findElement(By.cssSelector("input#accountName")).sendKeys("Praveen_KM");

        // Enter the description
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");

        // Select the industry from the dropdown
        WebElement industry = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
        Select industryDropdown = new Select(industry);
        industryDropdown.selectByVisibleText("Computer Software");

        // Select the ownership from the dropdown
        WebElement ownership = driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
        Select ownershipDropdown = new Select(ownership);
        ownershipDropdown.selectByVisibleText("S-Corporation");

        // Select the source from the dropdown
        WebElement source = driver.findElement(By.xpath("//select[@name='dataSourceId']"));
        Select sourceDropdown = new Select(source);
        sourceDropdown.selectByValue("LEAD_EMPLOYEE");

        // Select the marketing campaign from the dropdown
        WebElement marketingCampaign = driver.findElement(By.xpath("//select[@name='marketingCampaignId']"));
        Select marketingCampaignDropdown = new Select(marketingCampaign);
        marketingCampaignDropdown.selectByIndex(6);


        // Select the state from the dropdown
        WebElement state = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
        Select stateDropdown = new Select(state);
        stateDropdown.selectByValue("TX");

        // Click the Create Account button
        driver.findElement(By.cssSelector("input.smallSubmit")).click();

        // Verify if the account name displayed is as expected
        String accountName = driver
                .findElement(
                        By.xpath("//td[./span[text()='Account Name']]/following-sibling::td/span[@class='tabletext']"))
                .getText();
        String[] splitName = accountName.split("\\s\\(\\d+\\)");
        accountName = splitName[0];

        if (accountName.equals("Praveen_KM")) {
            System.out.println("Verified that the Account Name " + accountName + " is displayed correctly!");
        }

        // Close the browser
        driver.close();
    }
}

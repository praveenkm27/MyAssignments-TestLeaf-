package homeassignments.week5;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicParameterization extends ProjectSpecificMethod {

	@Test(dataProvider = "sendData")
	public void runDynamicParameterization(String company, String name) throws InterruptedException {

		// Enter Name as 'Salesforce Automation by *Your Name*'(Parameterized value)
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by " + name + " from " + company );

		// Call "verifyAlertMessage" method from ProjectSpecificMethod class and pass the expected alert message
		verifyAlertMessage("Legal Entity \"Salesforce Automation by " + name + " from " + company + "\" was created.");
	}
	
	@DataProvider(/* indices = {0} */)
	public String[][] sendData() throws IOException {

		String[][] data = new String[3][2];

		data[0][0] = "CTS";
		data[0][1] = "Hemanth";
		
		data[1][0] = "Meta";
		data[1][1] = "Praveen";
		
		data[2][0] = "TCS";
		data[2][1] = "Mano";

		return data;
	}
}

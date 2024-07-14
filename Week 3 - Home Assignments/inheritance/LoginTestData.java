package week3.homeassignments.inheritance;

// This class represents LoginTestData, which is a type of TestData
public class LoginTestData extends TestData {
    
    // This method simulates the action of entering a username
    public void enterUsername() {
        System.out.println("Entering username...");
    }

    // This method simulates the action of entering a password
    public void enterPassword() {
        System.out.println("Entering password...");
    }
    
    public static void main(String[] args) {
        // Create an object of the superclass TestData
        TestData testData = new TestData();
        testData.enterCredentials(); // Calls the enterCredentials method from TestData
        testData.navigateToHomePage(); // Calls the navigateToHomePage method from TestData

        // Create an object of the subclass LoginTestData
        LoginTestData loginTestData = new LoginTestData();
        loginTestData.enterUsername(); // Calls the enterUsername method from LoginTestData
        loginTestData.enterPassword(); // Calls the enterPassword method from LoginTestData
        loginTestData.enterCredentials(); // Inherited from TestData, calls the enterCredentials method
        loginTestData.navigateToHomePage(); // Inherited from TestData, calls the navigateToHomePage method
    }
}

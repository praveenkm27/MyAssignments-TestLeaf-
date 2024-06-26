package week1.day2;

public class Browser {
    
    public static void main(String[] args) {
        
        // Create an instance of the Browser class
        Browser browser = new Browser();
        
        // Call the launchBrowser method with "Chrome" as an argument and store the result in a String variable
        String browserName = browser.launchBrowser("Chrome");
        
        System.out.println("The browser name is " + browserName);
        
        // Call the loadUrl method
        browser.loadUrl();
    }
    
    
    public String launchBrowser(String browserName) {
        // Print a message indicating the browser was launched successfully
        System.out.println("Browser launched successfully");
        return browserName; // Return the name of the browser
    }
    
    
    public void loadUrl() {
        // Print a message indicating the URL was loaded successfully
        System.out.println("Application URL loaded successfully");
    }
}


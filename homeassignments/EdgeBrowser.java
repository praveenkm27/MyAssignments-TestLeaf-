package week1.homeassignments;

public class EdgeBrowser {
	public static void main(String[] args) {
		
		// Create an instance of the Browser class
		Browser browser1 = new Browser();
		
		// Call the launchBrowser method with "Edge" as an argument and store the result in a String variable
		String browserName = browser1.launchBrowser("Edge");
		
		System.out.println("The browser name is " + browserName);
		
		// Call the loadUrl method
		browser1.loadUrl();
		
		}
}

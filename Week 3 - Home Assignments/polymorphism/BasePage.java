package week3.homeassignments.polymorphism;

// This class represents a BasePage
public class BasePage {
	
	// This method simulates finding an element on the page
	public void findElement() {		
		System.out.println("Finding element");
	}
	
	// This method simulates clicking an element on the page
	public void clickElement() {		
		System.out.println("Clicking element");
	}
	
	// This method simulates entering text into an element on the page
	public void enterText() {		
		System.out.println("Entering text");
	}
	
	// This method performs common tasks that are applicable to all pages
	public void performCommonTasks() {
		System.out.println("Performing common tasks on the BasePage class");
	}
	
	public static void main(String[] args) {
		// Create an instance of the BasePage
		BasePage basePage = new BasePage();
		
		// Call methods on the BasePage instance
		basePage.findElement();
		basePage.clickElement();
		basePage.enterText();
		basePage.performCommonTasks();
		
		// Create an instance of the LoginPage, which is a subclass of BasePage
		LoginPage loginPage = new LoginPage();
		
		// Call methods on the LoginPage instance, which will inherit behavior from BasePage
		loginPage.findElement();
		loginPage.clickElement();
		loginPage.enterText();
		loginPage.performCommonTasks(); //Overrides the performCommonTasks method from BasePage
	}
}

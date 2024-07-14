package week3.homeassignments.polymorphism;

// This class represents a LoginPage, which is a subclass of BasePage
public class LoginPage extends BasePage {
	
	// This method overrides the performCommonTasks method from the BasePage class
	@Override
	public void performCommonTasks() {
		System.out.println(
				"Performing Common Tasks on the LoginPage by overriding performCommonTasks() from BasePage class");
	}
}

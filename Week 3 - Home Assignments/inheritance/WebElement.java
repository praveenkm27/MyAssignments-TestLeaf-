package week3.homeassignments.inheritance;

// This is a base class that represents a generic Web Element
public class WebElement {

	// This method simulates the action of clicking on a web element
	public void click() {
		System.out.println("Clicking on the element");
	}

	// This method simulates the action of setting text on a web element
	public void setText(String text) {
		System.out.println("Setting text to: " + text);
	}
}

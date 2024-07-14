package week3.homeassignments.inheritance;

// This class represents a collection of Elements and is the Execution class
public class Elements extends Button {

	public static void main(String[] args) {
		
		// Create objects for sub classes and call their respective methods and from their base class
        // Create a Button object and call click and submit methods
        Button button = new Button();
        button.click(); // Inherited from WebElement, simulates clicking on the element
        button.submit(); // Defined in Button, submits the form

        // Create a TextField object and call click, setText, and getText methods
        TextField textField = new TextField();
        textField.click(); // Inherited from WebElement, simulates clicking on the element
        textField.setText("Hello, World!"); // Inherited from WebElement, sets text on the element
        textField.getText(); // Defined in TextField, gets text from the element

        // Create a CheckBoxButton object and call click, submit, and clickCheckButton methods
        CheckBoxButton checkBoxButton = new CheckBoxButton();
        checkBoxButton.click(); // Inherited from WebElement, simulates clicking on the element
        checkBoxButton.submit(); // Inherited from Button, submits the form
        checkBoxButton.clickCheckButton(); // Defined in CheckBoxButton, clicks the checkbox button

        // Create a RadioButton object and call click, submit, and selectRadioButton methods
        RadioButton radioButton = new RadioButton();
        radioButton.click(); // Inherited from WebElement, simulates clicking on the element
        radioButton.submit(); // Inherited from Button, submits the form
        radioButton.selectRadioButton(); // Defined in RadioButton, selects the radio button
		
	}
}

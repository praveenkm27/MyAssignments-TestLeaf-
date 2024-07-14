package week3.homeassignments.string;

public class ChangeOddIndexToUppercase {
	
	public static void main(String[] args) {
		// Initialize an empty string to store the result
		String result = "";
		
		// Define a test string
		String test = "changeme";
		
		// Convert the test string to a character array
		char[] charArray = test.toCharArray();

		// Iterate through the character array
		for(int i = 0; i < charArray.length; i++) {
			// Check if the current index is odd
			if (i % 2 != 0) {
				// If the index is odd, convert the character to uppercase and add it to the result
				result += Character.toUpperCase(charArray[i]);
			} else {
				// If the index is even, add the character to the result as is
				result += charArray[i];
			}
		}
		
		// Print the resulting string
		System.out.println(result);
	}
}

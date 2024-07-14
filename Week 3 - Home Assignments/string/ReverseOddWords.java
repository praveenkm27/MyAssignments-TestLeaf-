package week3.homeassignments.string;

public class ReverseOddWords {

	public static void main(String[] args) {
		// Define a test string
		String test = "I am a software tester";
		
		// Split the test string into an array of words
		String[] words = test.split(" ");
		
		// Create a StringBuilder to build the resulting string
		StringBuilder reversedString = new StringBuilder();
		
		// Iterate through the array of words
		for (int i = 0; i < words.length; i++) {
			
			// Check if the current index is odd using a bitwise AND operator
			if ((i & 1) != 0) {
				// If the index is odd, reverse the word using a StringBuilder reverse method
				words[i] = new StringBuilder(words[i]).reverse().toString();
			}
			// Append the word (reversed or not) to the resulting string
			reversedString.append(words[i]).append(" ");
		}
		// Print the resulting string
		System.out.println(reversedString);
	}

}

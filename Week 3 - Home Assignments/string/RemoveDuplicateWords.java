package week3.homeassignments.string;

public class RemoveDuplicateWords {

	public static void main(String[] args) {
		// Define a sample text with duplicate words
		String text = "We learn Java basics as part of java sessions in java week1";
		
		// Initialize a count variable to track the number of duplicates found
		int count = 0;
		
		// Split the text into an array of words
		String[] textArray = text.split(" ");
		
		// Iterate through the array of words to find duplicates
		for (int i = 0; i < textArray.length; i++) {
			for (int j = i + 1; j < textArray.length; j++) {
				// Check if the current word is equal to any of the subsequent words
				if (textArray[i].equals(textArray[j])) {
					// If a duplicate is found, set both words to empty strings
					textArray[i] = "";
					textArray[j] = "";
					// Increment the count of duplicates found
					count++;
				}
			}
		}

		// If duplicates were found, print the modified array of words
		if (count > 0) {
			for (int i = 0; i < textArray.length; i++) {
				System.out.print(textArray[i] + " ");
			} 
		}
	}
}

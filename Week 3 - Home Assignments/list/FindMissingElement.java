package week3.homeassignments.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMissingElement {
	public static void main(String[] args) {
		// Declaring and initializing an array of Integers
		Integer[] array = {1, 2, 3, 4, 10, 6, 8};
		
		// Converting the array to a List
		List<Integer> list = new ArrayList<>(Arrays.asList(array));
		
		// Initializing a variable to store the missing element
		int missingElement = 0;
		
		// Sorting the list in ascending order
		Collections.sort(list);
				
		// Iterating over the list
		for (int i = 0; i < array.length; i++) {
			// Checking if the current element is not equal to its expected value (i+1)
			if (list.get(i) != (i+1)) {
				// If it's not, the missing element is the expected value
				missingElement = (i+1);
				// Breaking out of the loop since we've found the missing element
				break;
			}
		}
		// Printing the missing element
		System.out.println("The Missing Element is: " + missingElement);
	}

}

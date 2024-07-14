package week3.homeassignments.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {
	public static void main(String[] args) {
		// Declaring and initializing an array of Strings
		String[] array = { "HCL", "Wipro", "Aspire Systems", "CTS" };
		
		// Converting the array to a List
		List<String> list = new ArrayList<>(Arrays.asList(array));

		// Sorting the list in ascending order using the Collections.sort() method
		Collections.sort(list);
		
		// Iterating over the list in reverse order to print the elements in descending order
		for (int i = list.size() - 1; i >= 0; i--) {
			// Printing the elements with commas in between, except for the last element
			if (i == list.size() - 1) {
				System.out.print(list.get(i));
			} else {
				System.out.print(", " + list.get(i));
			}
		}
	}
}

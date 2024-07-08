package week2.homeassignments;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		// initial array
		int[] array = { 1, 4, 3, 2, 8, 6, 7 };

		// Sort the array
		Arrays.sort(array);

		// Loop through each element of the array. It starts with 0 as the index and
		// compares it with the sorted values in the array
		for (int i = 0; i < array.length; i++) {
			// If the current element is not the expected value, print the missing element
			// and break out of the loop
			if (array[i] != i + 1) {
				System.out.println("The missing element in the array is: " + (i + 1));
				break;
			}
		}
	}
}

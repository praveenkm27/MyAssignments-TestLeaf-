package week3.homeassignments.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargestNumber {

	public static void main(String[] args) {

		// Declaring and initializing an array of Integers
		Integer[] a = { 3, 2, 11, 4, 6, 7 };
		
		// Converting the array to a List
		List<Integer> list = new ArrayList<>(Arrays.asList(a));
		
		// Sorting the list in ascending order
		Collections.sort(list);
		
		// Printing the second largest number, which is the second last element in the sorted list
		System.out.println("Second largest number: " + list.get(list.size() - 2));
		
	}

}

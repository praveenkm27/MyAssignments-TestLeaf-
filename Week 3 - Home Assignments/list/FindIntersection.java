package week3.homeassignments.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersection {
	public static void main(String[] args) {
		// Declaring and initializing two arrays of Integers
		Integer[] a = { 3, 2, 11, 4, 6, 7 };
		Integer[] b = { 1, 2, 8, 4, 9, 7 };
		
		// Converting the arrays to Lists
		List<Integer> list1 = new ArrayList<>(Arrays.asList(a));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(b));
		
		// Creating a new List to store the intersection of list1 and list2
		List<Integer> intersection = new ArrayList<>();
		
		// Iterating over each element in list1
		for (Integer number : list1) {
			// Checking if list2 contains the current element
			if(list2.contains(number)) {
				// If it does, adding the element to the intersection list
				intersection.add(number);
			}
		}
		// Printing the intersection list
		System.out.println("Intersection: " + intersection);
	}

}

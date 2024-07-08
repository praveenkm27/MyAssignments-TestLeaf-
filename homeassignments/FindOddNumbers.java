package week1.homeassignments;

public class FindOddNumbers {
	public static void main(String[] args) {
		//set the max value of the odd number
		int maxValue = 10; 
		
		System.out.println("The odd numbers between 1 & " + maxValue + " are: ");
		
		// helper variable to track if the first odd number is printed
		boolean isFirstOddNumber = true;
		
		// loop through the numbers from 0 to max value		
		for (int i = 1; i <= maxValue; i++) {
			// check if number is odd. i.e a number when divided by 2 has a reminder of 1
			if (i % 2 == 1) {
				if (isFirstOddNumber) { 
					System.out.print(i); // print the first odd number without a comma
					isFirstOddNumber = false; //after printing 1st odd no. set this to false
				} else {
					System.out.print(", " + i); // print the rest of the odd numbers with a comma
				}
			} 			
		}
	}
}
